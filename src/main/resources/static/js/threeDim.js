import * as THREE from '/js/three.js-master/build/three.module.js';
import { GUI } from '/js/three.js-master/examples/jsm/libs/dat.gui.module.js';
import { Stats } from 'js/three.js-master/examples/jsm/libs/stats.module.js';
import { GLTFLoader } from "/js/three.js-master/examples/jsm/loaders/GLTFLoader.js";
import { OrbitControls } from '/js/three.js-master/examples/jsm/controls/OrbitControls.js';

var renderer, camera, scene, gui, light, stats, controls, meshHelper, mixer, action,datGui;
var clock = new THREE.Clock();


function initRender() {
    renderer = new THREE.WebGLRenderer({alpha:true,antialias: true});
    renderer.setPixelRatio(window.devicePixelRatio);
    renderer.shadowMap.enabled = true;
    //告诉渲染器需要阴影效果

    renderer.setSize(window.innerWidth, window.innerHeight);
    //告诉渲染器需要阴影效果
    //renderer.shadowMap.enabled = true;
    //renderer.shadowMap.type = THREE.PCFSoftShadowMap; // 默认的是，没有设置的这个清晰 THREE.PCFShadowMap
    renderer.setClearColor(0xffffff);
    document.body.appendChild(renderer.domElement);
}


function initCamera() {
    camera = new THREE.PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 10000);
    camera.position.set(1200, 1200, 1200);
    camera.lookAt(new THREE.Vector3(0, 0, 0));
}


function initScene() {
    scene = new THREE.Scene();
}


function initLight() {
    scene.add(new THREE.AmbientLight(0x444444));

    light = new THREE.DirectionalLight(0xffffff);
    light.position.set(0, 200, 100 );

    light.castShadow = true;
    light.shadow.camera.top = 180;
    light.shadow.camera.bottom = -100;
    light.shadow.camera.left = -120;
    light.shadow.camera.right = 120;

    //告诉平行光需要开启阴影投射
    light.castShadow = true;

    scene.add(light);
}


function initModel(){
    var loader = new GLTFLoader();

    loader.load( '../model/Bee.glb', function ( mesh ) {
        console.log(mesh)

        // X轴为红色。 Y轴为绿色。 Z轴为蓝色。
        var helper = new THREE.AxesHelper(1000)
        scene.add(helper)
        scene.add(mesh.scene)
        /*mesh.scale.set(1, 1, 1)
        let box = new THREE.Box3().setFromObject(mesh)
        let mdlen = box.max.x - box.min.x;
        let mdwid = box.max.z - box.min.z;
        let mdhei = box.max.y - box.min.y;
        let x1 = box.min.x + mdlen/2;
        let y1 = box.min.y + mdhei/2;
        let z1 = box.min.z + mdwid/2;
        mesh.position.set(-x1,-y1,-z1);*/
        //object.rotate.x = 90
        //object.angles = [90,0,0]

        //AnimationMixer是场景中特定对象的动画播放器。当场景中的多个对象独立动画时，可以为每个对象使用一个AnimationMixer
        mixer = mesh.mixer = new THREE.AnimationMixer(mesh.scene);

        //mixer.clipAction 返回一个可以控制动画的AnimationAction对象  参数需要一个AnimationClip 对象
        //AnimationAction.setDuration 设置一个循环所需要的时间，当前设置了一秒
        //告诉AnimationAction启动该动作
        //action = mixer.clipAction(mesh.animations[0]);
        //action.play();

        var actions = []; //所有的动画数组
        var animations = datGui.addFolder("animations");

        for(var i=0; i<mesh.animations.length; i++){
            createAction(i);
        }

        function createAction(i){
            actions[i] = mixer.clipAction(mesh.animations[i]);
            gui["action"+i] = function () {
                for(var j = 0; j < actions.length; j ++){
                    if(j === i){
                        actions[j].play();
                    }
                    else{
                        actions[j].stop();
                    }
                }
            };

            animations.add(gui, "action"+i);
        }

        //添加暂停所有动画的按键
        gui.stop = function(){
            for(var i=0; i<actions.length; i++){
                actions[i].stop();
            }
        };

        datGui.add(gui, "stop");

        //mesh.scene.position.y += 100;

        /*scene.add( gltf.scene );*/

    }, undefined, function ( error ) {

        console.error( error );

    } );
}

/*function initModel() {

    //辅助工具
    var helper = new THREE.AxesHelper(10);
    scene.add(helper);

    var s = 25;

    var cube = new THREE.CubeGeometry(s, s, s);

    for (var i = 0; i < 3000; i++) {

        var material = new THREE.MeshBasicMaterial({color:randomColor()});

        var mesh = new THREE.Mesh(cube, material);

        mesh.position.x = 800 * ( 2.0 * Math.random() - 1.0 );
        mesh.position.y = 800 * ( 2.0 * Math.random() - 1.0 );
        mesh.position.z = 800 * ( 2.0 * Math.random() - 1.0 );

        mesh.rotation.x = Math.random() * Math.PI;
        mesh.rotation.y = Math.random() * Math.PI;
        mesh.rotation.z = Math.random() * Math.PI;

        mesh.updateMatrix();

        scene.add(mesh);

    }

}*/

//随机生成颜色
function randomColor() {
    var arrHex = ["0","1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d","e","f"],
        strHex = "#",
        index;
    for(var i = 0; i < 6; i++) {
        index = Math.round(Math.random() * 15);
        strHex += arrHex[index];
    }
    return strHex;
}

//声明raycaster和mouse变量
/*var raycaster = new THREE.Raycaster();
var mouse = new THREE.Vector2();

function onMouseClick( event ) {

    //通过鼠标点击的位置计算出raycaster所需要的点的位置，以屏幕中心为原点，值的范围为-1到1.

    mouse.x = ( event.clientX / window.innerWidth ) * 2 - 1;
    mouse.y = - ( event.clientY / window.innerHeight ) * 2 + 1;

    // 通过鼠标点的位置和当前相机的矩阵计算出raycaster
    raycaster.setFromCamera( mouse, camera );

    // 获取raycaster直线和所有模型相交的数组集合
    var intersects = raycaster.intersectObjects( scene.children );

    console.log(intersects);

    //将所有的相交的模型的颜色设置为红色，如果只需要将第一个触发事件，那就数组的第一个模型改变颜色即可
    for ( var i = 0; i < intersects.length; i++ ) {

        intersects[ i ].object.material.color.set( 0xff0000 );

    }

}

window.addEventListener( 'click', onMouseClick, false );*/

//初始化dat.GUI简化试验流程
//var gui;

function initGui() {
    //声明一个保存需求修改的相关数据的对象
    //声明一个保存需求修改的相关数据的对象
    gui = {
        helper:true //模型辅助线
    };
    datGui = new GUI();
    //将设置属性添加到gui当中，gui.add(对象，属性，最小值，最大值）

    datGui.add(gui, "helper").onChange(function (e) {
        meshHelper.visible = e;
    })

}

//初始化性能插件

function initStats() {
    stats = new Stats();
    document.body.appendChild(stats.dom);
}

//用户交互插件 鼠标左键按住旋转，右键按住平移，滚轮缩放
var controls;

function initControls() {

    controls = new OrbitControls(camera, renderer.domElement);

    // 如果使用animate方法时，将此函数删除
    //controls.addEventListener( 'change', render );
    // 使动画循环使用时阻尼或自转 意思是否有惯性
    controls.enableDamping = true;
    //动态阻尼系数 就是鼠标拖拽旋转灵敏度
    controls.dampingFactor = 0.25;
    //是否可以缩放
    controls.enableZoom = true;

    //是否自动旋转
    controls.autoRotate = true;
    controls.autoRotateSpeed = 0.5;
    //上下旋转的角度范围，相等意味着不可上下转动
    controls.minPolarAngle = Math.PI / 4
    controls.maxPolarAngle = Math.PI / 4
    //设置相机距离原点的最远距离
    controls.minDistance = 0.1;
    //设置相机距离原点的最远距离
    controls.maxDistance = 10000;
    //是否开启右键拖拽
    controls.enablePan = true;
}

function render() {
    var time = clock.getDelta();
    if (mixer) {
        mixer.update(time);
    }

    controls.update();
}

//窗口变动触发的函数
function onWindowResize() {

    camera.aspect = window.innerWidth / window.innerHeight;
    camera.updateProjectionMatrix();
    render();
    renderer.setSize(window.innerWidth, window.innerHeight);

}

function animate() {
    //更新控制器
    render();

    //更新性能插件
    stats.update();

    renderer.render(scene, camera);

    requestAnimationFrame(animate);
}

function draw() {
    /*initRender();
    initScene();
    initCamera();
    initLight();
    initModel();
    initGui();
    initControls();
    initStats();

    animate();
    window.onresize = onWindowResize;*/
    //if (!Detector.webgl) Detector.addGetWebGLMessage();

    initGui();
    initRender();
    initScene();
    initCamera();
    initLight();
    initModel();
    initControls();
    initStats();

    animate();
    window.onresize = onWindowResize;
}