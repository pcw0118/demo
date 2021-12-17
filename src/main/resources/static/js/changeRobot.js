var MaxCount;
var count=parseInt(0);
var preStatus=-1;

let clientWidth = document.documentElement.clientWidth || document.body.clientWidth;
let clientHeight = document.getElementsByClassName("wbox")[0].clientHeight;

//设计图参考宽度
let designW = 1920,designH = 943;
let fontsize = Math.min(Math.trunc(parseInt(clientWidth) / designW * 13), Math.trunc(parseInt(clientHeight) / designH * 13));

var box=document.getElementById("ulbox");
var ul=document.getElementById("scrollDiv");
var lines=0,lineHeight=0;
var width=parseInt(box.clientWidth), height=parseInt(box.clientHeight),newHeight,newWidth,marginLeft;
lineHeight = (Math.trunc(fontsize*1.4/5)+1)*5;
newHeight=(Math.trunc(height/lineHeight)-1)*lineHeight;

//console.log("lineHieght:"+lineHeight);
//console.log("newHeight:"+newHeight);

MaxCount=Math.trunc(newHeight/lineHeight);


console.log(MaxCount);

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
    ['1','准备'],
    ['2','运行'],
    ['3','报警'],
])
//let fileReader = new FileReader();
//fileReader.readAsText("C:\Users\XIOS\Desktop\data.txt");//读成字符串
var preTime=-1;

var dailyBaseMetalNum = document.getElementById("dailyBaseMetalNum");//本日切割母材数
var dailyPartNum = document.getElementById("dailyPartNum");//本日切割零件数
var monthlyBaseMetalNum = document.getElementById("monthlyBaseMetalNum");//月切割母材数
var monthlyPartNum = document.getElementById("monthlyPartNum");//月切割零件数
var yearlyBaseMetalNum = document.getElementById("yearlyBaseMetalNum");//年切割母材数
var yearlyPartNum = document.getElementById("yearlyPartNum");//年切割零件数
var systemStartDate = document.getElementById("systemStartDate");//系统启动日期
var systemStartTime = document.getElementById("systemStartTime");//系统启动时间
var systemPreCloseDate = document.getElementById("systemPreCloseDate");//系统上次关闭日期
var systemPreCloseTime = document.getElementById("systemPreCloseTime");//系统上次关闭时间
var systemLastCloseDate = document.getElementById("systemLastCloseDate");//系统末次关闭日期
var systemLastCloseTime = document.getElementById("systemLastCloseTime");//系统末次关闭时间
var cumulateRunTime = document.getElementById("cumulateRunTime");//累计运行时间
var vulnerPartUpDate = document.getElementById("vulnerPartUpDate");//易损件更新日期
var vulnerPartUpTime = document.getElementById("vulnerPartUpTime");//易损件更新时间
var dailyFailureTime = document.getElementById("dailyFailureTime");//当日设备故障时间
var dailyStandbyTime = document.getElementById("dailyStandbyTime");//当日设备待机时间
var dailyRunTime = document.getElementById("dailyRunTime");//当日设备运行时间

var heartbeatStatus = document.getElementById("heartbeatStatus");
var HeartBeat=0;
var preHeartBeat=0;
var preStatus=-1;
var preDailyMax=500;
var preTotalMax=500;

//----------------------------------------------------------------------
var colors = ['#00FFFF','#F2CB0A','#7AB2FF'];
var img = '/images/robotPieInner.png';
var option={
    title: [{
        text: '当日信息的日期',
        x: '50%',
        y: '90%',
        textAlign: 'center',
        textStyle: {
            fontSize: fontSize(1.6),
            fontWeight: '500',
            color: '#00FFFF',
            textAlign: 'center',
        },
    }, {
        text: 'YYYY.MM.dd',
        left: '50%',
        top: '45%',
        textAlign: 'center',
        textStyle: {
            fontSize: fontSize(1.2),
            fontWeight: '400',
            color: '#FFFFFF',
            textAlign: 'center',
        },
    }],
    tooltip: {
    show: true
    },
    color:colors,
    graphic: {
        elements: [
            {
            type: "image",
            z: 3,
            style: {
                image: img,
                width: fontSize(10),
                height: fontSize(10)
            },
            left: 'center',
            top:  'center',
            position: [100, 100]
        }
        ]
    },
    series: [
    {
        type: "pie",
        radius: ["70%", "90%"],
        center: ["50%", "50%"],
        hoverAnimation: true,
        z: 10,
        itemStyle: {
            normal: {
                borderWidth:0,
                borderColor: "#003359"
            }
        },
        label: {
            show: false
        },
        data: [100,23,43],
        labelLine: {
            show: false
        }
    }
    ]
}

var charts = echarts.init(document.getElementById("pieCharts"));
charts.setOption(option);



function updatePie(time,failure,standby,run) {
    /*console.log(failure);
    console.log(standby);
    console.log(run);*/
    let data = [];
    data.push(failure);
    data.push(standby);
    data.push(run);
    option.title[1].text = time;
    option.series[0].data = data;
    charts.setOption(option);
}

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

    if(data.heartBeat === 0){
        heartbeatStatus.innerHTML = strSigError;
    }else{
        heartbeatStatus.innerHTML = strNormal;
    }
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

function hour2time(data){
    //console.log("data:"+data.toString());
    var res="";
    var step;
    if(data==0){
        res="00:00";
        return res;
    }
    for(var i=0;i<2;i++){
        if(i === 0) step = 24;
        else step = 60;
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
//console.log(state);
function changeData(data) {
    //console.log(data);
    //设置
    dailyBaseMetalNum.innerText = data.todayBaseMetalNum.toString()+"pcs";//本日切割母材数
    dailyPartNum.innerText = data.todayPartNum.toString()+"pcs";//本日切割零件数
    monthlyBaseMetalNum.innerText = data.monthlyBaseMetalNum.toString()+"pcs";//月切割母材数
    monthlyPartNum.innerText = data.monthlyPartNum.toString()+"pcs";//月切割零件数
    yearlyBaseMetalNum.innerText = data.yearlyBaseMetalNum.toString()+"pcs";//年切割母材数
    yearlyPartNum.innerText = data.yearlyPartNum.toString()+"pcs";//年切割零件数
    systemStartDate.innerText = data.systemStartDate;//系统启动日期
    systemStartTime.innerText = data.systemStartTime;//系统启动时间
    systemPreCloseDate.innerText = data.systemPreCloseDate;//系统上次关闭日期
    systemPreCloseTime.innerText = data.systemPreCloseTime;//系统上次关闭时间
    systemLastCloseDate.innerText = data.systemLastCloseDate;//系统末次关闭日期
    systemLastCloseTime.innerText = data.systemLastCloseTime;//系统末次关闭时间
    cumulateRunTime.innerText = hour2time(parseInt(data.cumulateRunTime));//累计运行时间
    vulnerPartUpDate.innerText = data.vulnerPartUpDate;//易损件更新日期
    vulnerPartUpTime.innerText = data.vulnerPartUpTime;//易损件更新时间
    dailyFailureTime.innerText = data.dailyFailureTime.toFixed(2).toString()+"min";//当日设备故障时间
    dailyStandbyTime.innerText = data.dailyStandbyTime.toFixed(2).toString()+"min";//当日设备待机时间
    dailyRunTime.innerText = data.dailyRunTime.toFixed(2).toString()+"min";//当日设备运行时间

    updatePie(data.currentDate,parseFloat(data.dailyFailureTime),parseFloat(data.dailyStandbyTime),parseFloat(data.dailyRunTime));

    var status=parseInt(data.currentStatus);

    var state=map.get(status.toString());

    if(count == 0){//第一次加载时
        var allStatus = data.preStatus;
        allStatus.reverse();
        //console.log(allStatus);
        var i=0;
        var len = Math.min(allStatus.length,MaxCount);
        for(;i<len;i++){
            var element = $('#scrollDiv').find('ul').children('li').eq(i);//找到第count个元素
            //console.log(element);
            var p1 = element.find("p:first")[0];
            var p2 = element.find("p:last")[0];
            var array = allStatus[i].split("|");
            p1.innerText = map.get(array[0]);
            p2.innerText = array[1];
            preStatus = parseInt(array[0]);
        }
        count=i;
    }else{
        if (status != preStatus) {
            //count=parseInt(20);
            var element = $('#scrollDiv').find('ul').children('li').eq(count);//找到第count个元素
            //console.log(element);
            var p1 = element.find("p:first")[0];
            var p2 = element.find("p:last")[0];
            //console.log(p1);
            //console.log(p2);
            p1.innerText = state;
            var time = new Date();
            p2.innerText = Format(time, "yyyy-MM-dd HH:mm:ss");
            preStatus=status;
            //console.log(count);
            if (count < MaxCount) {
                count++;
            } else {
                console.log();
                $('#scrollDiv').myScroll({
                    speed: 40, //数值越大，速度越慢
                    rowHeight: lineHeight //li的高度
                });
            }

        }
    }
}


var text = localStorage.getItem("token");

setInterval(function(){
    $.ajax({
        url:"/data/S16Data?access_token="+text,
        type:"GET",
        success:(result)=>{
            changeData(result);
            // changeTick(result);
        }})
},1000);

setInterval(function(){
    $.ajax({
        url:"/data/S16Data?access_token="+text,
        type:"GET",
        success:(result)=>{
            changeHearts(result);
        }})
},10000);