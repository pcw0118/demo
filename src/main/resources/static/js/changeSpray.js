var MaxCount,MaxCount1;
var count=parseInt(0),count1=parseInt(0);
var preStatus=-1;

let clientWidth = document.documentElement.clientWidth || document.body.clientWidth;
let clientHeight = document.getElementsByClassName("wbox")[0].clientHeight;

//设计图参考宽度
let designW = 1920,designH = 943;
let fontsize = Math.min(Math.trunc(parseInt(clientWidth) / designW * 13), Math.trunc(parseInt(clientHeight) / designH * 13));

var box=document.getElementById("ulbox");
var ul=document.getElementById("ulreal");
var lines=0,lineHeight=0,lineHeight1;
var width=parseInt(box.clientWidth), height=parseInt(box.clientHeight),newHeight,newWidth,marginLeft,marginLeft1;
lineHeight = (Math.trunc(fontsize*1.4/5)+1)*5;
newHeight=(Math.trunc(height/lineHeight)-1)*lineHeight;

newWidth=Math.trunc(width/10)*10;
marginLeft=(width-newWidth)/2;

ul.style.width=newWidth.toString()+"px";
ul.style.height=newHeight.toString()+"px";

console.log("lineHieght:"+lineHeight);


MaxCount=Math.trunc(newHeight/lineHeight);

box=document.getElementById("ulbox1");
ul=document.getElementById("ulreal1");
lines=0;
width=parseInt(box.clientWidth), height=parseInt(box.clientHeight);
lineHeight1 = (Math.trunc(fontsize*1.4/5)+1)*5;
newHeight=(Math.trunc(height/lineHeight1)-1)*lineHeight1;
newWidth=Math.trunc(width/10)*10;
marginLeft1=(width-newWidth)/2;
MaxCount1=Math.trunc(newHeight/lineHeight1);
ul.style.width=newWidth.toString()+"px";
ul.style.height=newHeight.toString()+"px";
console.log("lineHieght1:"+lineHeight1);

document.getElementById("ulreal1").innerHTML = "<li style=height:"+lineHeight+"px;margin-left:"+marginLeft+"px;><p style='height:"+lineHeight+
    "px;text-align:left;margin-left:7%;width:50%;'>"+"</p><p style='height:"+lineHeight
    +"px;text-align:right; color:#7AB2FF;width:40%;'>"+"</p></li>";;
document.getElementById("ulreal").innerHTML = "<li style=height:"+lineHeight1+"px;margin-left:"+marginLeft1+"px;><p style='height:"+lineHeight1+
    "px;text-align:left;margin-left:7%;width:50%;'>"+"</p><p style='height:"+lineHeight1
    +"px;text-align:right; color:#7AB2FF;width:40%;'>"+"</p></li>";


function fontSize(res){
    let clientWidth = document.documentElement.clientWidth || document.body.clientWidth;
    let clientHeight = document.getElementsByClassName("wbox")[0].clientHeight;
    //设计图参考宽度
    let designW = 1920,designH = 943;
    let fontSize = Math.min(Math.trunc(parseInt(clientWidth) / designW * 13), Math.trunc(parseInt(clientHeight) / designH * 13));
    return res*fontSize;
}
//var data={"output":"59.321167","taktTime":"21.500000","rateOfStartup":"96.500000","rateOfUtilization":"94.500000","current":"11.500000",
//"vol":"215.000000","usefulPower":"2.101625","currentElectricEnergy":"333.017914","heartbeat":"1.000000","status":"3.000000"};
//日期格式化函数
function Format(now,mask)
{
    var d = now;
    var zeroize = function (value, length)
    {
        if (!length) length = 2;
        value = String(value);
        for (var i = 0, zeros = ''; i < (length - value.length); i++)
        {
            zeros += '0';
        }
        return zeros + value;
    };

    return mask.replace(/"[^"]*"|'[^']*'|\b(?:d{1,4}|m{1,4}|yy(?:yy)?|([hHMstT])\1?|[lLZ])\b/g, function ($0)
    {
        switch ($0)
        {
            case 'd': return d.getDate();
            case 'dd': return zeroize(d.getDate());
            case 'ddd': return ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat'][d.getDay()];
            case 'dddd': return ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'][d.getDay()];
            case 'M': return d.getMonth() + 1;
            case 'MM': return zeroize(d.getMonth() + 1);
            case 'MMM': return ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'][d.getMonth()];
            case 'MMMM': return ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'][d.getMonth()];
            case 'yy': return String(d.getFullYear()).substr(2);
            case 'yyyy': return d.getFullYear();
            case 'h': return d.getHours() % 12 || 12;
            case 'hh': return zeroize(d.getHours() % 12 || 12);
            case 'H': return d.getHours();
            case 'HH': return zeroize(d.getHours());
            case 'm': return d.getMinutes();
            case 'mm': return zeroize(d.getMinutes());
            case 's': return d.getSeconds();
            case 'ss': return zeroize(d.getSeconds());
            case 'l': return zeroize(d.getMilliseconds(), 3);
            case 'L': var m = d.getMilliseconds();
                if (m > 99) m = Math.round(m / 10);
                return zeroize(m);
            case 'tt': return d.getHours() < 12 ? 'am' : 'pm';
            case 'TT': return d.getHours() < 12 ? 'AM' : 'PM';
            case 'Z': return d.toUTCString().match(/[A-Z]+$/);
            // Return quoted strings with the surrounding quotes removed
            default: return $0.substr(1, $0.length - 2);
        }
    });
};

/*const map = new Map([
    ['-1','未知状态'],
    ['0','待机状态'],
    ['1','检测有料信号'],
    ['2','位置长度确定完成'],
    ['3','到达加工位置，钻孔启动'],
    ['4','钻孔加工完成，铣孔启动'],
    ['5','位置切换中'],
    ['6','铣孔加工完成，清洗启动'],
    ['7','清洗完成'],
    ['8','加工完成，输送启动'],
    ['9','输送完成']
])*/

const map = new Map([
    ['-1','未知状态'],
    ['0','错误状态'],
    ['1','自动模式-自动模式-待机状态'],
    ['2','自动模式-自动模式-运行状态'],
    ['3','自动模式-自动模式-暂停状态'],
    ['4','暂停模式-手动模式-手动控制状态'],
    ['5','暂停模式-自动模式-手动控制状态'],
    ['6','手动模式-手动模式-待机状态'],
    ['7','手动模式-自动模式-运行状态'],
])
//let fileReader = new FileReader();
//fileReader.readAsText("C:\Users\XIOS\Desktop\data.txt");//读成字符串
var preTime=-1;
var length = document.getElementById("length");//型材长度
var height = document.getElementById("height");//型材高度
var dryElec = document.getElementById("dryElec");//烘干电量数据
var dryStartupTime = document.getElementById("dryStartupTime");//烘干开机时长
var dryProcessingTakt = document.getElementById("dryProcessingTakt");//烘干加工节拍
var dryProcessingTimes = document.getElementById("dryProcessingTimes");//烘干加工次数
var dryMaintainTime = document.getElementById("dryMaintainTime");//烘干维护时间
var dryRemainTime = document.getElementById("dryRemainTime");//烘干维护剩余时间
var dryUtilizeRate = document.getElementById("dryUtilizeRate");//烘干利用率
var sprayElec = document.getElementById("sprayElec");//喷涂电量数据
var sprayStartupTime = document.getElementById("sprayStartupTime");//喷涂开机时长
var sprayProcessingTakt = document.getElementById("sprayProcessingTakt");//喷涂加工节拍
var sprayProcessingTimes = document.getElementById("sprayProcessingTimes");//喷涂加工次数
var sprayMaintainTime = document.getElementById("sprayMaintainTime");//喷涂维护时间
var sprayRemainTime = document.getElementById("sprayRemainTime");//喷涂维护剩余时间
var sprayUtilizeRate = document.getElementById("sprayUtilizeRate");//喷涂利用率

var heartbeatStatus = document.getElementById("heartbeatStatus");
var HeartBeat=0;
var preHeartBeat=0;
var preStatus=-1;
var preDailyMax=500;
var preTotalMax=500;







//----------------------------------------------------------------------






function changeHearts(data){
    var date = new Date();
    var errorInfo="长度检测失败！长度检测失败！";
    var errorHtml="";
    if(getByteLen(errorInfo)>20){
        errorHtml="<marquee style='font-size: 2.4rem;'><font>"+errorInfo+"</font></marquee>";
    }else{
        errorHtml="<h2>"+errorInfo+"</h2>";
    }
    var strRunError = "<div style='width: 10%;height: 65%;margin-left: 11%;display: inline-block;'><div style='height:20%;width:100%;margin-bottom: 10%;margin-top:40%;'><h2 style='color: #7AB2FF;font-size: 1.6rem;'>通讯信号</h2></div>"+
        "<div style='height:25%;width:100%; font-size: 1.6rem; text-align: center;background : url(/images/blue.png);background-size: 100% 100%;background-repeat: no-repeat;background-position: top center;'>"+
        "<h2 style='font-size: 1.6rem;padding-top:3%;'>正常</h2></div></div><div style='width: 28%;height: 60%;margin-bottom:2%; display: inline-block;margin-left: 13%;background : url(/images/red.png);background-size: 100% 100%;background-repeat: no-repeat;background-position: top center;'>"+
        "<div style='margin-bottom:0%;font-size: 1.6rem;'><h2>运行状态异常</h2></div>"+
        "<div class='row' style='margin-top:0%; width:80%; margin-left:10%; font-weight: 100;'><hr class='new2'/></div>"+
        "<div id='info' style='font-size: 1.6rem;margin-bottom:2%; margin-top:-1%;'>"+errorHtml+"</div>"+
        "<div style='font-size: 1.2rem;'><h2>"+Format(date,"yyyy/MM/dd HH:mm:ss")+"</h2></div> </div>"+
        "<div style='height:10%;width:100%;margin-top:-2%;'>"+
        "<h2 class='point' style='display: inline-block;margin-bottom:-0.3vh;'></h2>"+
        "<h2 style='display: inline-block;margin-left: -1%;color: #7AB2FF;width:calc(32% - 4vh);margin-bottom: -0.3vh;'><hr class='new1'/></h2>"+
        "<h2 class='point' style='background-color: red;display: inline-block; margin-left: -1%; color: red;margin-bottom:-0.3vh;'></h2></div>";

    var strSigError="<div style='width: 10%;height: 65%;margin-left: 0%;display: inline-block;'>\n" +
        "                        <div style='height:20%;width:100%;margin-bottom: 10%;margin-top:40%;'><h2 style='color: red;font-size: 1.6rem;'>通讯信号</h2></div>\n" +
        "                        <div style='height:25%;width:100%; font-size: 1.6rem; text-align: center;background-color: red; background : url(/images/redSquare.png);background-size: 100% 100%;background-repeat: no-repeat;background-position: top center;'><h2 style='font-size: 1.6rem;padding-top:3%;'>异常</h2></div>\n" +
        "                    </div>\n" +
        "                    <div style='width: 10%;height: 65%;;display: inline-block;margin-left:20%;'>\n" +
        "                        <div style='height:20%;width:100%;margin-bottom: 10%;margin-top:40%;'><h2 style='color: #7AB2FF;font-size: 1.6rem;'>设备运行</h2></div>\n" +
        "                        <div style='height:25%;width:100%; font-size: 1.6rem; text-align: center;background : url(/images/blue.png);background-size: 100% 100%;background-repeat: no-repeat;background-position: top center;'><h2 style='font-size: 1.6rem;padding-top:3%;'>正常</h2></div>\n" +
        "                    </div>\n" +
        "                    <div style='height:10%;width:100%;margin-top:-2%;'>\n" +
        "                        <h2 class='point' style='display: inline-block;margin-bottom:-0.3vh;background-color:red;'></h2>\n" +
        "                        <div style='display: inline-block;margin-left: -1%;color: #7AB2FF;width:calc(32% - 4vh);'><hr class='new1'/></div>\n" +
        "                        <h2 class='point' style='background-color: #7AB2FF;display: inline-block; margin-left: -1%;margin-bottom:-0.3vh;'></h2>\n" +
        "                    </div>"

    var strNormal="<div style='width: 10%;height: 65%;margin-left: 0%;display: inline-block;'>\n" +
        "                        <div style='height:20%;width:100%;margin-bottom: 10%;margin-top:40%;'><h2 style='color: #7AB2FF;font-size: 1.6rem;'>通讯信号</h2></div>\n" +
        "                        <div style='height:25%;width:100%; font-size: 1.6rem; text-align: center;background : url(/images/blue.png);background-size: 100% 100%;background-repeat: no-repeat;background-position: top center;'><h2 style='font-size: 1.6rem;padding-top:3%;'>正常</h2></div>\n" +
        "                    </div>\n" +
        "                    <div style='width: 10%;height: 65%;;display: inline-block;margin-left:20%;'>\n" +
        "                        <div style='height:20%;width:100%;margin-bottom: 10%;margin-top:40%;'><h2 style='color: #7AB2FF;font-size: 1.6rem;'>设备运行</h2></div>\n" +
        "                        <div style='height:25%;width:100%; font-size: 1.6rem; text-align: center;background : url(/images/blue.png);background-size: 100% 100%;background-repeat: no-repeat;background-position: top center;'><h2 style='font-size: 1.6rem;padding-top:3%;'>正常</h2></div>\n" +
        "                    </div>\n" +
        "                    <div style='height:10%;width:100%;margin-top:-2%;'>\n" +
        "                        <h2 class='point' style='display: inline-block;margin-bottom:-0.3vh;'></h2>\n" +
        "                        <div style='display: inline-block;margin-left: -1%;color: #7AB2FF;width:calc(32% - 4vh);'><hr class='new1'/></div>\n" +
        "                        <h2 class='point' style='background-color: #7AB2FF;display: inline-block; margin-left: -1%;margin-bottom:-0.3vh;'></h2>\n" +
        "                    </div>"

    if(data.startUpTime==preTime){
        heartbeatStatus.innerHTML = strSigError;
    }else{
        heartbeatStatus.innerHTML = strNormal;
    }
    preTime=data.startUpTime;
}

function getByteLen(val) {
    var len = 0;
    for (var i = 0; i < val.length; i++) {
        var a = val.charAt(i);
        if (a.match(/[^\x00-\xff]/ig) != null) {//\x00-\xff→GBK双字节编码范围

            len += 2;
        }
        else {
            len += 1;
        }
    }
    return len;
}

function second2time(data){
    //console.log("data:"+data.toString());
    var res="";
    var step=3600;
    if(data==0){
        res="00:00:00";
        return res;
    }
    for(var i=0;i<3;i++){
        var temp = Math.floor(data/step).toString();
        if(temp < 10) res=res+"0"+temp.toString();
        else res=res+Math.floor(data/step).toString();
        data=data%step;
        step=step/60;
        if(i!=2){
            res=res+":";
        }
    }
    //console.log("res:"+res);
    return res;
}

function second2time2(data){
    //console.log("data:"+data.toString());
    var res="";
    var step=60;
    if(data==0){
        res="00:00";
        return res;
    }
    for(var i=0;i<2;i++){
        var temp = Math.floor(data/step).toString();
        if(temp < 10) res=res+"0"+temp.toString();
        else res=res+Math.floor(data/step).toString();
        data=data%step;
        step=step/60;
        if(i!=1){
            res=res+":";
        }
    }
    //console.log(res);
    return res;
}

function time2second(data){
    var strs=data.split(":");
    var step=3600;
    var res=0;
    for(var i=0;i<3;i++){
        res=res+step*parseInt(strs[i]);
        step=step/60;
    }
    return res;
}

//console.log(status);
function changeLH(data){
    length.innerText=(parseFloat(data.length).toFixed(2)).toString()+" mm";
    height.innerText=(parseFloat(data.height).toFixed(2)).toString()+" mm";
}
//console.log(state);
function changePrimerDryData(data) {
    //设置
    dryElec.innerText=(parseFloat(data.primerDryElec).toFixed(2)).toString()+"kW·h";
    dryStartupTime.innerText=second2time(parseInt(data.primerDryStartupTime));
    dryProcessingTakt.innerText=((parseInt(data.primerDryTakt)/60).toFixed(2)).toString()+" min";
    dryProcessingTimes.innerText=(parseInt(data.primerDryProcessTimes)).toString()+" pcs";

    dryMaintainTime.innerText=data.primerDryMaintainTime;
    dryRemainTime.innerText=data.primerDryRemainTime.toString()+" 天";
    dryUtilizeRate.innerText=parseFloat(data.primerDryUtilize).toFixed(2).toString()+"%";




    var allStatus = data.prePrimerDryStatus;
    if(!allStatus && typeof(allStatus)!="undefined" && allStatus!=0){
        allStatus.reverse();
        //console.log(allStatus);
        var i=0;
        var len = allStatus.length;
        var templateStr1 = "<li style=height:"+lineHeight1+"px;margin-left:"+marginLeft1+"px;><p style='height:"+lineHeight1+
            "px;text-align:left;margin-left:7%;width:40%;'></p><p style='height:"+lineHeight1+"px;text-align:right; color:#7AB2FF;width:40%;'></p></li>";
        var str="";
        for(;i<len;i++){
            var array = allStatus[i].split("|");
            str += "<li style=height:"+lineHeight1+"px;margin-left:"+marginLeft1+"px;><p style='height:"+lineHeight1+
                "px;text-align:left;margin-left:7%;width:50%;'>"+array[0]+"</p><p style='height:"+lineHeight1
                +"px;text-align:right; color:#7AB2FF;width:40%;'>"+array[1]+"</p></li>";
        }
    }else str="";
    document.getElementById("ulreal1").innerHTML = str;
}

function changeTopcoatDryData(data) {
    //设置
    dryElec.innerText=(parseFloat(data.topcoatDryElec).toFixed(2)).toString()+"kW·h";
    dryStartupTime.innerText=second2time(parseInt(data.topcoatDryStartupTime));
    dryProcessingTakt.innerText=((parseInt(data.topcoatDryTakt)/60).toFixed(2)).toString()+" min";
    dryProcessingTimes.innerText=(parseInt(data.topcoatDryProcessTimes)).toString()+" pcs";

    dryMaintainTime.innerText=data.topcoatDryMaintainTime;
    dryRemainTime.innerText=data.topcoatDryRemainTime.toString()+" 天";
    dryUtilizeRate.innerText=parseFloat(data.topcoatDryUtilize).toFixed(2).toString()+"%";




    var allStatus = data.preTopCoatDryStatus;
    if(!allStatus && typeof(allStatus)!="undefined" && allStatus!=0) {
        allStatus.reverse();
        //console.log(allStatus);
        var i = 0;
        var len = allStatus.length;
        var templateStr1 = "<li style=height:" + lineHeight1 + "px;margin-left:" + marginLeft1 + "px;><p style='height:" + lineHeight1 +
            "px;text-align:left;margin-left:7%;width:40%;'></p><p style='height:" + lineHeight1 + "px;text-align:right; color:#7AB2FF;width:40%;'></p></li>";
        var str = "";
        for (; i < len; i++) {
            var array = allStatus[i].split("|");
            str += "<li style=height:" + lineHeight1 + "px;margin-left:" + marginLeft1 + "px;><p style='height:" + lineHeight1 +
                "px;text-align:left;margin-left:7%;width:50%;'>" + array[0] + "</p><p style='height:" + lineHeight1
                + "px;text-align:right; color:#7AB2FF;width:40%;'>" + array[1] + "</p></li>";
        }
    } else str="";
    document.getElementById("ulreal1").innerHTML = str;
}

function changePrimerSprayData(data) {
    //设置
    sprayElec.innerText=(parseFloat(data.primerSprayElec).toFixed(2)).toString()+"kW·h";
    sprayStartupTime.innerText=second2time(parseInt(data.primerSprayStartupTime));
    sprayProcessingTakt.innerText=((parseInt(data.primerSprayTakt)/60).toFixed(2)).toString()+" min";
    sprayProcessingTimes.innerText=(parseInt(data.primerSprayProcessTimes)).toString()+" pcs";

    sprayMaintainTime.innerText=data.primerSprayMaintainTime;
    sprayRemainTime.innerText=data.primerSprayRemainTime.toString()+" 天";
    sprayUtilizeRate.innerText=parseFloat(data.primerSprayUtilize).toFixed(2).toString()+"%";




    var allStatus = data.prePrimerSprayStatus;
    if(!allStatus && typeof(allStatus)!="undefined" && allStatus!=0) {
        allStatus.reverse();
        //console.log(allStatus);
        var i = 0;
        var len = allStatus.length;
        var templateStr1 = "<li style=height:" + lineHeight + "px;margin-left:" + marginLeft + "px;><p style='height:" + lineHeight
            + "px;text-align:left;margin-left:7%;width:50%;'></p><p style='height:" + lineHeight + "px;text-align:right; color:#7AB2FF;width:40%;'></p></li>";
        var str = "";
        for (; i < len; i++) {
            var array = allStatus[i].split("|");
            str += "<li style=height:" + lineHeight + "px;margin-left:" + marginLeft + "px;><p style='height:" + lineHeight +
                "px;text-align:left;margin-left:7%;width:50%;'>" + array[0] + "</p><p style='height:" + lineHeight
                + "px;text-align:right; color:#7AB2FF;width:40%;'>" + array[1] + "</p></li>";
        }
    } else str="";
    document.getElementById("ulreal").innerHTML = str;
}

function changeTopcoatSprayData(data) {
    //设置
    sprayElec.innerText=(parseFloat(data.topcoatSprayElec).toFixed(2)).toString()+"kW·h";
    sprayStartupTime.innerText=second2time(parseInt(data.topcoatSprayStartupTime));
    sprayProcessingTakt.innerText=((parseInt(data.topcoatSprayTakt)/60).toFixed(2)).toString()+" min";
    sprayProcessingTimes.innerText=(parseInt(data.topcoatSprayProcessTimes)).toString()+" pcs";

    sprayMaintainTime.innerText=data.topcoatSprayMaintainTime;
    sprayRemainTime.innerText=data.topcoatSprayRemainTime.toString()+" 天";
    sprayUtilizeRate.innerText=parseFloat(data.topcoatSprayUtilize).toFixed(2).toString()+"%";




    var allStatus = data.preTopCoatSprayStatus;
    if(!allStatus && typeof(allStatus)!="undefined" && allStatus!=0) {
        allStatus.reverse();
        //console.log(allStatus);
        var i = 0;
        var len = allStatus.length;
        var templateStr1 = "<li style=height:" + lineHeight + "px;margin-left:" + marginLeft +
            "px;><p style='height:" + lineHeight + "px;text-align:left;margin-left:7%;width:50%;'></p><p style='height:" + lineHeight + "px;text-align:right; color:#7AB2FF;width:40%;'></p></li>";
        var str = "";
        for (; i < len; i++) {
            var array = allStatus[i].split("|");
            str += "<li style=height:" + lineHeight + "px;margin-left:" + marginLeft + "px;><p style='height:" + lineHeight +
                "px;text-align:left;margin-left:7%;width:50%;'>" + array[0] + "</p><p style='height:" + lineHeight
                + "px;text-align:right; color:#7AB2FF;width:40%;'>" + array[1] + "</p></li>";
        }
    } else str="";
    document.getElementById("ulreal").innerHTML = str;
}



var text = localStorage.getItem("token");


setInterval(function(){
    $.ajax({
        url:"/data/S18Data?access_token="+text,
        type:"GET",
        success:(result)=>{
            changeLH(result);
           // changeTick(result);
        }})
},1000);

var sprayInt,dryInt;

sprayInt = setInterval(function(){
    $.ajax({
        url:"/data/S18Data?access_token="+text,
        type:"GET",
        success:(result)=>{
            changePrimerSprayData(result);
        }})
},1000);

dryInt = setInterval(function(){
    $.ajax({
        url:"/data/S18Data?access_token="+text,
        type:"GET",
        success:(result)=>{
            changePrimerDryData(result);
        }})
},1000);




$('#switchbar').click( function() {
    $bar1 = $('#tab1');
    $bar2 = $('#tab2');
    if( $bar1.hasClass('active') ) {
        //console.log("switch to 2");
        $bar1.removeClass('active');
        $bar2.addClass('active');
        clearInterval(dryInt);
        dryInt = setInterval(function(){
            $.ajax({
                url:"/data/S18Data?access_token="+text,
                type:"GET",
                success:(result)=>{
                    changeTopcoatDryData(result);
                }})
        },1000);
    }
    else {
       // console.log("switch to 1");
        $bar2.removeClass('active');
        $bar1.addClass('active');
        clearInterval(dryInt);
        dryInt = setInterval(function(){
            $.ajax({
                url:"/data/S18Data?access_token="+text,
                type:"GET",
                success:(result)=>{
                    changePrimerDryData(result);
                }})
        },1000);
    }
});
$('#switchbar2').click( function() {
    $bar1 = $('#tab3');
    $bar2 = $('#tab4');
    if( $bar1.hasClass('active') ) {
        $bar1.removeClass('active');
        $bar2.addClass('active');
        clearInterval(sprayInt);
        sprayInt = setInterval(function(){
            $.ajax({
                url:"/data/S18Data?access_token="+text,
                type:"GET",
                success:(result)=>{
                    changeTopcoatSprayData(result);
                }})
        },1000);
    }
    else {
        $bar2.removeClass('active');
        $bar1.addClass('active');
        clearInterval(sprayInt);
        sprayInt = setInterval(function(){
            $.ajax({
                url:"/data/S18Data?access_token="+text,
                type:"GET",
                success:(result)=>{
                    changePrimerSprayData(result);
                }})
        },1000);
    }
});

setInterval(function(){
    $.ajax({
        url:"/data/S18Data?access_token="+text,
        type:"GET",
        success:(result)=>{
            changeHearts(result);
        }})
},10000);