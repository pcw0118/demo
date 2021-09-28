var MaxCount;
var count=parseInt(0);
var preStatus=-1;
var box=document.getElementById("ulbox");
var height=parseInt(box.clientHeight);
MaxCount=Math.trunc(height/25)-1;



console.log(MaxCount);
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
var actualBeat = document.getElementById('actualBeat');//生产节拍
var webWidth = document.getElementById('webWidth');//腹板宽度
var flangWidth = document.getElementById('flangWidth');//翼板宽度
var webThick = document.getElementById('webThick');//腹板厚度
var flangThick = document.getElementById('flangThick');//翼板厚度
var length = document.getElementById("length");
var processingTimes= document.getElementById('processingTimes');//加工次数
var cumulativeOutput= document.getElementById('cumulativeOutput');//累计产量
var cumulativeProcessingTime= document.getElementById('cumulativeProcessingTime');//累计加工时长
var cumulativeStartupTime= document.getElementById('cumulativeStartupTime');//开机累计时长
var utilizationRate= document.getElementById('utilizationRate');//利用率

var heartbeatStatus = document.getElementById("heartbeatStatus");
var tick1 = document.getElementById("tick1");
var tick2 = document.getElementById("tick2");
var bar1 = $("#bar1");
var bar2 = $("#bar2");
var num1 = document.getElementById("num1");
var num2 = document.getElementById("num2");
var HeartBeat=0;
var preHeartBeat=0;
var preStatus=-1;
var preDailyMax=500;
var preTotalMax=500;

function convertToValue(percent,min,max,step) {
    var min_decimals = min.toString().split(".")[1],
        max_decimals = max.toString().split(".")[1],
        min_length, max_length,
        avg_decimals = 0,
        abs = 0;

    if (percent === 0) {
        return min;
    }
    if (percent === 100) {
        return max;
    }


    if (min_decimals) {
        min_length = min_decimals.length;
        avg_decimals = min_length;
    }
    if (max_decimals) {
        max_length = max_decimals.length;
        avg_decimals = max_length;
    }
    if (min_length && max_length) {
        avg_decimals = (min_length >= max_length) ? min_length : max_length;
    }

    if (min < 0) {
        abs = Math.abs(min);
        min = +(min + abs).toFixed(avg_decimals);
        max = +(max + abs).toFixed(avg_decimals);
    }

    var number = ((max - min) / 100 * percent) + min,
        string = step.toString().split(".")[1],
        result;

    if (string) {
        number = +number.toFixed(string.length);
    } else {
        number = number / step;
        number = number * step;

        number = +number.toFixed(0);
    }

    if (abs) {
        number -= abs;
    }

    if (string) {
        result = +number.toFixed(string.length);
    } else {
        result = +(number).toFixed(20);
    }

    if (result < min) {
        result = min;
    } else if (result > max) {
        result = max;
    }

    return result;
}

function appendGrid(max,min,step){
    var total = max - min,
        html = '',
        i,
        big_w=0,
        big_p = 0,
        result,
        big_num;

    big_num = total / step;

    big_p = +(100 / big_num).toFixed(20);

    for (i = 0; i < big_num + 1; i++) {
        big_w = +(big_p * i).toFixed(20);

        if (big_w > 100) {
            big_w = 100;
        }

        result = convertToValue(big_w,min,max,step);

        html += '<span class="irs-grid-text js-grid-text-' + i + '" style="left: ' + big_w + '%;color:#00FFFF;">' + result + '</span>';
    }
    return html;
}


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

    if(data.totalStartupTime==preTime){
        heartbeatStatus.innerHTML = strSigError;
    }else{
        heartbeatStatus.innerHTML = strNormal;
    }
    preTime=data.totalStartupTime;
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
//console.log(state);
function changeData(data) {
    //设置
    webWidth.innerText=(parseFloat(data.webWidth).toFixed(2)).toString()+"mm";
    flangWidth.innerText=(parseFloat(data.flangeWidth).toFixed(2)).toString()+"mm";
    webThick.innerText=(parseFloat(data.webThick).toFixed(2)).toString()+"mm";
    flangThick.innerText=(parseFloat(data.flangeThick).toFixed(2)).toString()+"mm";
    length.innerText=(parseFloat(data.length).toFixed(2)).toString()+"mm";
    processingTimes.innerText=data.completeTasks.toString()+"pcs";
    cumulativeOutput.innerText=((parseFloat(data.flangeThick)*parseFloat(data.flangeWidth)*parseFloat(data.length)*2*7.82/1000+parseFloat(data.webThick)*parseFloat(data.webWidth)*parseFloat(data.length)*7.82/1000)*parseFloat(data.completeTasks)/1000000).toFixed(2).toString()+"t";
    actualBeat.innerText=second2time2(data.heartBeat);

    cumulativeProcessingTime.innerText=data.totalProcessTime;
    cumulativeStartupTime.innerText=data.totalStartupTime;
    utilizationRate.innerText=(parseFloat(time2second(data.totalProcessTime))/parseFloat(time2second(data.totalStartupTime))*100).toFixed(2).toString()+"%";
    //maintainTime="2021.08.12";




    //output.innerText=parseFloat(data.output).toPrecision(4);
    //taktTime.innerText=parseFloat(data.taktTime).toPrecision(4);
    //rateOfStartup.innerText=parseFloat(data.rateOfStartup).toPrecision(4);
    //rateOfUtilization.innerText=parseFloat(data.rateOfUtilization).toPrecision(4);
    //current.innerText=parseFloat(data.current).toPrecision(5);
    //vol.innerText=parseFloat(data.vol).toPrecision(5);
    //usefulPower.innerText=parseFloat(data.usefulPower).toPrecision(5);
    //currentElectricEnergy.innerText=parseFloat(data.currentElectricEnergy).toPrecision(5);

    var status=parseInt(data.sysStatus);

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
                    rowHeight: 25 //li的高度
                });
            }

        }
    }
}

function changeTick(data){
    num1.innerText=data.dailyDrillNum.toString()+"pcs";
    num2.innerText=data.totalDrillNum.toString()+"pcs";
    if(data.dailyDrillNum>preDailyMax){
        preDailyMax=Math.trunc(data.dailyDrillNum*2/100)*100*2;
        tick1.innerHTML=appendGrid(preDailyMax,0,preDailyMax/10);
    }
    if(data.totalDrillNum>preTotalMax){
        preTotalMax=Math.trunc(data.totalDrillNum*2/100)*100*2;
        tick2.innerHTML=appendGrid(preTotalMax,0,preTotalMax/10);
    }
    var dailyWidth = +(data.dailyDrillNum/preDailyMax).toFixed(20);
    var totalWidth = +(data.totalDrillNum/preTotalMax).toFixed(20);
    bar1.css("width",(dailyWidth*99).toString()+"%");//总长度为百分之99
    bar2.css("width",(totalWidth*99).toString()+"%");
}


setInterval(function(){
    $.ajax({
        url:"/data/S15Data",
        type:"GET",
        success:(result)=>{
            changeData(result);
            changeTick(result);
        }})
},1000);

setInterval(function(){
    $.ajax({
        url:"/data/S15Data",
        type:"GET",
        success:(result)=>{
            changeHearts(result);
        }})
},10000);