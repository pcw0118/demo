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



	//console.log(MaxCount);
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
		['0','设备待机状态'],
		['1','设备正在加工']
	])
	//let fileReader = new FileReader();
	//fileReader.readAsText("C:\Users\XIOS\Desktop\data.txt");//读成字符串
	var preTime=-1;
	var actualBeat = document.getElementById('actualBeat');//生产节拍
	var processingTimes= document.getElementById('processingTimes');//加工次数
	var cumulativeProcessingTime= document.getElementById('cumulativeProcessingTime');//累计加工时长
	var cumulativeStartupTime= document.getElementById('cumulativeStartupTime');//开机累计时长
	var utilizationRate= document.getElementById('utilizationRate');//利用率
	var throw1TotalTime=document.getElementById("throw1TotalTime");//抛1累计时间
	var throw2TotalTime=document.getElementById("throw2TotalTime");//抛2累计时间
	var throw3TotalTime=document.getElementById("throw3TotalTime");//抛3累计时间
	var throw4TotalTime=document.getElementById("throw4TotalTime");//抛4累计时间
	var throw5TotalTime=document.getElementById("throw5TotalTime");//抛5累计时间
	var throw6TotalTime=document.getElementById("throw6TotalTime");//抛6累计时间
	var throw7TotalTime=document.getElementById("throw7TotalTime");//抛7累计时间
	var throw8TotalTime=document.getElementById("throw8TotalTime");//抛8累计时间

	var fan1TotalTime = document.getElementById("fan1TotalTime");//风机1累计时间
	var fan2TotalTime = document.getElementById("fan2TotalTime");//风机2累计时间
	var separateTotalTime = document.getElementById("separateTotalTime");//分离累计时间
	var increaseTotalTime = document.getElementById("increaseTotalTime");//提升累计时间
	var transverseTotalTime = document.getElementById("transverseTotalTime");//横向累计时间
	var verticalTotalTime = document.getElementById("verticalTotalTime");//纵向累计时间
	var recoveryTotalTime = document.getElementById("recoveryTotalTime");//回收累计时间
	var blowback1TotalTime = document.getElementById("blowback1TotalTime");//反吹1累计时间
	var blowback2TotalTime = document.getElementById("blowback2TotalTime");//反吹2累计时间

	var maintainTime= document.getElementById('maintainTime');//设备维护时间
	var charts=echarts.init(document.getElementById("charts1"));

	var heartbeatStatus = document.getElementById("heartbeatStatus");
	var preHeart=1;
	var HeartBeat=0;
	var preHeartBeat=0;
	var preTime=-1;

	const mapOfAlarm = new Map([
		['0','无报警'],
		['1','设备报警']
	])




	function changeHearts(data){
		var date = new Date();
		var errorInfo=mapOfAlarm.get(data.statusAlarm.toString());
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

		if(data.startupTime==preTime){
			heartbeatStatus.innerHTML = strSigError;
		}else{
			heartbeatStatus.innerHTML = strNormal;
		}
		preTime=data.startupTime;
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

	//console.log(status);
	//console.log(state);
	function changeData(data) {
		//设置
		throw1TotalTime.innerText = second2time(data.throw1TotalTime);
		throw2TotalTime.innerText = second2time(data.throw2TotalTime);
		throw3TotalTime.innerText = second2time(data.throw3TotalTime);
		throw4TotalTime.innerText = second2time(data.throw4TotalTime);
		throw5TotalTime.innerText = second2time(data.throw5TotalTime);
		throw6TotalTime.innerText = second2time(data.throw6TotalTime);
		throw7TotalTime.innerText = second2time(data.throw7TotalTime);
		throw8TotalTime.innerText = second2time(data.throw8TotalTime);

		fan1TotalTime.innerText = second2time(data.fan1TotalTime);
		fan2TotalTime.innerText = second2time(data.fan2TotalTime);
		separateTotalTime.innerText = second2time(data.separateTotalTime);
		increaseTotalTime.innerText = second2time(data.increaseTotalTime);
		transverseTotalTime.innerText = second2time(data.transverseTotalTime);
		verticalTotalTime.innerText = second2time(data.verticalTotalTime);
		recoveryTotalTime.innerText = second2time(data.recoveryTotalTime);
		blowback1TotalTime.innerText = second2time(data.blowback1TotalTime);
		blowback2TotalTime.innerText = second2time(data.blowback2TotalTime);

		actualBeat.innerText = second2time2(data.heartBeat);
		processingTimes.innerText=(data.output).toString()+"pcs";
		cumulativeProcessingTime.innerText=second2time(parseInt(data.output*preHeartBeat));
		cumulativeStartupTime.innerText=second2time(parseInt(data.startupTime));
		utilizationRate.innerText=(parseFloat(data.output*preHeartBeat)/parseFloat(data.startupTime)*100).toFixed(2).toString()+"%";
		maintainTime.innerText=second2time(data.maintenanceTime);

		charts.setOption({
			title: {
				text: `检修剩余`,
				subtext: data.maintenanceRemainDay+'天',
				left: 'center',
				top: '40%', //top待调整
				textStyle: {
					color: '#fff',
					fontSize: 14,
					fontFamily: 'PingFangSC-Regular',
				},
				subtextStyle: {
					color: '#fff',
					fontSize: 14,
					fontFamily: 'PingFangSC-Regular',
					top: 'center'
				},
				itemGap: 5 //主副标题间距
			}
		});



		//output.innerText=parseFloat(data.output).toPrecision(4);
		//taktTime.innerText=parseFloat(data.taktTime).toPrecision(4);
		//rateOfStartup.innerText=parseFloat(data.rateOfStartup).toPrecision(4);
		//rateOfUtilization.innerText=parseFloat(data.rateOfUtilization).toPrecision(4);
		//current.innerText=parseFloat(data.current).toPrecision(5);
		//vol.innerText=parseFloat(data.vol).toPrecision(5);
		//usefulPower.innerText=parseFloat(data.usefulPower).toPrecision(5);
		//currentElectricEnergy.innerText=parseFloat(data.currentElectricEnergy).toPrecision(5);

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
				console.log(count);
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

	setInterval(function(){
		$.ajax({
		url:"/data/S17Data",
		type:"GET",
		success:(result)=>{
			console.log(result);
			changeData(result);
		}})
	},1000);

	setInterval(function(){
		$.ajax({
			url:"/data/S17Data",
			type:"GET",
			success:(result)=>{
				//console.log(result);
				changeHearts(result);
			}})
	},10000);