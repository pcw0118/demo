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
var webWidth = document.getElementById('webWidth');//腹板宽度
var flangWidth = document.getElementById('flangWidth');//翼板宽度
var webThick = document.getElementById('webThick');//腹板厚度
var flangThick = document.getElementById('flangThick');//翼板厚度
var webLength = document.getElementById("webLength");//腹板长度
var flangLength = document.getElementById('flangLength');//翼板长度
var tTakt = document.getElementById('tTakt');//理论节拍
var realTakt = document.getElementById('realTakt');//生产节拍
var processingTimes= document.getElementById('processingTimes');//加工次数
var output= document.getElementById('output');//累计产量
var processingTime= document.getElementById('processingTime');//累计加工时长
var startupTime= document.getElementById('startupTime');//开机累计时长
var utilizeRate= document.getElementById('utilizeRate');//利用率
var weldGas = document.getElementById("weldGas");//焊接气体
var weldWire = document.getElementById("weldWire");//焊丝
var deviceCode = document.getElementById("deviceCode");//设备型号

var heartbeatStatus = document.getElementById("heartbeatStatus");
var HeartBeat=0;
var preHeartBeat=0;
var preStatus=-1;
var preDailyMax=500;
var preTotalMax=500;

//----------------------------------------------------------------------
//电池效果图
var optionOfCurrent = {
    //backgroundColor: 'black',
    tooltip: {
        textStyle: { // 提示框浮层的文本样式。
            fontStyle: 'normal',
            fontWeight: 'normal',
            fontFamily: 'sans-serif',
            fontSize: fontSize(1.2),
        }
        /*formatter: function (params) {
            //console.log(params);

            return params.seriesName+"电能消耗:"+params.value.toString()+"kW·h";
        }*/
    },
    xAxis: {
        max: 200,
        splitLine: {
            show: false
        },
        offset: 10,
        axisTick: {
            show: false
        },
        axisLine: {
            show: false
        },
        axisLabel: {
            show: false
        }
    },
    yAxis: [{
        data: ['电能消耗'],
        inverse: true,
        axisTick: {
            show: false
        },
        axisLine: {
            show: false
        },
        axisLabel: {
            margin: fontSize(1),
            textStyle: {
                color: '#00FFFF',
                fontSize: fontSize(1.2)
            }
        }
    },{
        data: [188],
        inverse: true,
        axisTick: {
            show: false
        },
        axisLine: {
            show: false
        },
        axisLabel: {
            margin: fontSize(1),
            textStyle: {
                color: '#FFF',
                fontSize: fontSize(1.2)
            },formatter: function(value){
                console.log("电能消耗"+value.toString());
                return value.toString()+" kW·h"
            }
        }
    }],
    grid: {
        top: 'center',
        height: '80%',
        left: '20%',
        right: '20%'
    },
    series: [{
        // current data
        type: 'pictorialBar',
        symbol: 'rect',
        itemStyle: {
            normal: {
                barBorderRadius: 5,
                color: '#00FFFF',

            }
        },
        symbolRepeat: 'fixed',
        symbolMargin: '50%',
        symbolClip: true,
        symbolSize: [fontSize(0.5),fontSize(1.8)],
        symbolBoundingData: 188,
        data: [188],
        z: 99999999,
        animationEasing: 'elasticOut',
        animationDelay: function(dataIndex, params) {
            return params.index * 30;
        }
    }, {
        // full data
        type: 'pictorialBar',
        itemStyle: {
            normal: {
                color: 'rgba(54,215,182,0.27)'
            }
        },
        label: {
            normal: {
                show: true,
                formatter: function(params) {
                    return ""
                },
                position: 'right',
                offset: [10, 0],
                textStyle: {
                    color: '#FFF',
                    fontSize: 18
                }
            }
        },
        animationDuration: 0,
        symbolRepeat: 'fixed',
        symbolMargin: '50%',
        symbol: 'rect',
        symbolSize: [fontSize(0.5),fontSize(1.8)],
        symbolBoundingData: 200,
        data: [188],
        z: 99999,
        animationEasing: 'elasticOut',
        animationDelay: function(idx) {
            return idx * 30;
        }
    }
    ]
};

var current = echarts.init(document.getElementById("current"));
current.setOption(optionOfCurrent);


function updateCurrentData(data){
    // console.log("Current"+data);
    var maxValue = optionOfCurrent.xAxis.max;
    if(data>=maxValue) maxValue = (Math.ceil(maxValue/100)*100)*2;
    if(data == 0) maxValue = 100;
    //console.log(maxValue);
    optionOfCurrent.xAxis.max = maxValue;
    optionOfCurrent.yAxis[1].data = data.toString();
    optionOfCurrent.series[0].symbolBoundingData = data;
    optionOfCurrent.series[0].data = data.toString();
    optionOfCurrent.series[1].symbolBoundingData = maxValue;
    optionOfCurrent.series[1].data = maxValue.toString();
    current.setOption(optionOfCurrent);
}


//----------------------------------------------------------------------

//----------------------------------------------------------------------
//随时间轴变化的折线图
var dataOfTime = ['0:00','1:00','2:00','3:00','4:00','5:00','6:00','7:00','8:00','9:00','10:00','11:00','12:00',
    '13:00','14:00','15:00','16:00','17:00','18:00', '19:00', '20:00','21:00','22:00','23:00'];
var data = [100,150,175];
var data1 = [100,150,175];
/*
var now = new Date();
if(now.getMinutes()>30) now.setMinutes(30);
else now.setMinutes(0);
now.setSeconds(0);
var oneHour = 3600 * 1000;
var oneDay = 24 * 3600 * 1000;
var value = Math.random() * 1000;
var minValue=100000,maxValue=-1;

now = new Date(+now - oneDay);
for (var i = 0; i < 48; i++) {
    var ret = randomData();
    data.push(ret);
    data1.push(ret);
}

function randomData() {
    now = new Date(+now + 30*60*1000);
    value = value + Math.random() * 21 - 10;
    minValue = Math.min(minValue,value);
    maxValue = Math.max(maxValue,value);

    var len = Math.floor(maxValue - minValue).toString().length;//整数部分占的位数

    /!*console.log("maxvalue:"+maxValue.toString());
    console.log("minvalue:"+minValue.toString());
    console.log("len:"+len.toString());*!/

    minValue = Math.floor(minValue/Math.pow(10,len-1))*Math.pow(10,len-1)<0?0:Math.floor(minValue/Math.pow(10,len-1))*Math.pow(10,len-1);
    maxValue = Math.ceil(maxValue/Math.pow(10,len-1))*Math.pow(10,len-1);
    return {
        name: now.toString(),
        symbol: '',
        value: [
            now,
            Math.round(value)
        ]
    };
}
*/
var minValue=0,maxValue1=200,maxValue2=200;
minValue = 0;


//console.log(data);

var optionTemplete =  {
    title: {
        text: ''
    },
    grid:{
        left: 0,
        top :10,
        bottom: 0,
        containLabel:true
    },
    tooltip: {
        trigger: 'axis',
        formatter: function (params) {
            //console.log(params);
            return  params[0].name+":"+params[0].value+"Nm³";
        },
        axisPointer: {
            animation: false
        }
    },
    xAxis: {
        type: 'category',
        axisTick: {
            show: false
        },
        axisLine: {
            show: true,
            lineStyle: {
                color: '#DCE2E8'
            }
        },
        axisLabel: {
            interval:3,
            formatter: function (value) {
                return value;
            },
            rotate:0,
            textStyle: {
                fontSize: 8,
                color: '#f9f9fa'
            }
        },
        splitLine: {
            show: false
        },
        data: dataOfTime
    },
    yAxis: {
        type: 'value',
        boundaryGap: [0, '98%'],
        axisTick: {
            show: false
        },
        axisLabel: {
            interval:(maxValue1 - minValue)/5,
            textStyle: {
                fontSize: 8,
                color: '#f9f9fa',
            },
            margin:4
        },
        min:minValue,
        max:maxValue1
    },
    series: [{
        name: '',
        type: 'line',
        radius: '100%',
        showSymbol: false,
        hoverAnimation: false,
        lineStyle:{
            width: 1,
            color: '#00FFFF'
        },
        smooth: true,
        //itemStyle : { normal: {label : {show: true}}},
        data: data
    }]
};

var optionTemplete1 =  {
    title: {
        text: ''
    },
    grid:{
        left: 0,
        top :10,
        bottom: 0,
        containLabel:true
    },
    tooltip: {
        trigger: 'axis',
        formatter: function (params) {
            //console.log(params);
            return  params[0].name+":"+params[0].value+"kg";
        },
        axisPointer: {
            animation: false
        }
    },
    xAxis: {
        type: 'category',
        axisTick: {
            show: false
        },
        axisLine: {
            show: true,
            lineStyle: {
                color: '#DCE2E8'
            }
        },
        axisLabel: {
            interval:3,
            formatter: function (value) {
                return value;
            },
            rotate:0,
            textStyle: {
                fontSize: 8,
                color: '#f9f9fa'
            }
        },
        splitLine: {
            show: false
        },
        data:dataOfTime
    },
    yAxis: {
        type: 'value',
        boundaryGap: [0, '100%'],
        axisTick: {
            show: false
        },
        axisLabel: {
            interval:(maxValue2 - minValue)/5,
            textStyle: {
                fontSize: 8,
                color: '#f9f9fa',
            },
            margin:4
        },
        min:minValue,
        max:maxValue2
    },
    series: [{
        name: '',
        type: 'line',
        radius: '100%',
        showSymbol: false,
        hoverAnimation: false,
        lineStyle:{
            width: 1,
            color: '#00FFFF'
        },
        smooth: true,
        //itemStyle : { normal: {label : {show: true}}},
        data: data1
    }]
};


//var lineOfGas = echarts.init(document.getElementById('lineOfGas'));//焊接气体折线图
//var lineOfSteel = echarts.init(document.getElementById('lineOfSteel'));//焊丝折线图

/*var optionOfGas =JSON.parse(JSON.stringify(optionTemplete));
var optionOfSteel =JSON.parse(JSON.stringify(optionTemplete));
console.log(optionOfGas);
console.log(optionOfSteel);*/
data1=[];
//lineOfGas.setOption(optionTemplete);
//lineOfSteel.setOption(optionTemplete1);
var startHour = 0;

function updateLineData(data2){
    var cur = new Date();
    if(cur.getHours()==0&&cur.getMinutes()==0&&cur.getSeconds()==0){
        maxValue1 = 200;
        maxValue2 = 200;
        data = [];
    }
    if(startHour == 0){
        minValue = 0;
        maxValue2 = Math.max(maxValue2, data2[data2.length-1]);

        optionTemplete1.series[0].data = data2;
        optionTemplete1.yAxis.min = minValue;
        optionTemplete1.yAxis.max = maxValue2;
        optionTemplete1.yAxis.axisLabel.interval = (maxValue2-minValue)/5;

        //lineOfGas.setOption(optionTemplete);
        lineOfSteel.setOption(optionTemplete1);

        startHour = 1;
    } else if(cur.getMinutes()==0&&cur.getSeconds()==0) {
        /*var ret = randomData();
        data.shift();
        data.push(ret);
        data1.shift();
        data1.push(ret);*/

        minValue = 0;
        maxValue2 = Math.max(maxValue2, data2[data2.length-1]);

        optionTemplete1.series[0].data = data2;
        optionTemplete1.yAxis.min = minValue;
        optionTemplete1.yAxis.max = maxValue2;
        optionTemplete1.yAxis.axisLabel.interval = (maxValue2-minValue)/5;

        //lineOfGas.setOption(optionTemplete);
        lineOfSteel.setOption(optionTemplete1);
    }
}






//----------------------------------------------------------------------



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
//console.log(state);
function changeData(data) {
    //console.log(data);
    //设置
    webWidth.innerText=(parseFloat(data.webWidth).toFixed(2)).toString()+"mm";
    flangWidth.innerText=(parseFloat(data.flangWidth).toFixed(2)).toString()+"mm";
    webThick.innerText=(parseFloat(data.webThick).toFixed(2)).toString()+"mm";
    flangThick.innerText=(parseFloat(data.flangThick).toFixed(2)).toString()+"mm";
    webLength.innerText=(parseFloat(data.webLength).toFixed(2)).toString()+"mm";
    flangLength.innerText=(parseFloat(data.flangLength).toFixed(2)).toString()+"mm";
    //length.innerText=(parseFloat(data.length).toFixed(2)).toString()+"mm";
    tTakt.innerText=parseFloat(data.tTakt).toFixed(2).toString()+"min";
    realTakt.innerText=parseFloat(data.realTakt).toFixed(2).toString()+"min";
    //processingTimes.innerText=data.completeTasks.toString()+"pcs";
    output.innerText=parseInt(data.output).toString()+"件";
    deviceCode.innerText=data.deviceCode;

    processingTime.innerText=second2time(data.processingTime);
    startupTime.innerText=second2time(data.startUpTime);
    var uData = ((parseFloat(data.processingTime)/parseFloat(data.startUpTime))*100).toFixed(2).toString()+"%";
    //console.log(parseFloat(data.processingTime));
   // console.log(parseFloat(data.startUpTime));
   // console.log(uData);
    if(data.processingTime==0&&data.startUpTime==0) utilizeRate.innerText="100%";
    else if(data.startUpTime!=0)utilizeRate.innerText= uData;





    //output.innerText=parseFloat(data.output).toPrecision(4);
    //taktTime.innerText=parseFloat(data.taktTime).toPrecision(4);
    //rateOfStartup.innerText=parseFloat(data.rateOfStartup).toPrecision(4);
    //rateOfUtilization.innerText=parseFloat(data.rateOfUtilization).toPrecision(4);
    //current.innerText=parseFloat(data.current).toPrecision(5);
    //vol.innerText=parseFloat(data.vol).toPrecision(5);
    //usefulPower.innerText=parseFloat(data.usefulPower).toPrecision(5);
    //currentElectricEnergy.innerText=parseFloat(data.currentElectricEnergy).toPrecision(5);
    updateCurrentData(data.eleEnergy);

    var status=parseInt(data.runStatus);

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
        url:"/data/S11Data?access_token="+text,
        type:"GET",
        success:(result)=>{
            changeData(result);
           // changeTick(result);
        }})
},1000);

setInterval(function(){
    $.ajax({
        url:"/data/S11Data?access_token="+text,
        type:"GET",
        success:(result)=>{
            changeHearts(result);
        }})
},10000);