$(function(){
	var box=document.getElementById("ulbox");
	var ul=document.getElementById("scrollDiv");
	var width=parseInt(box.clientWidth), height=parseInt(box.clientHeight),newHeight,newWidth,marginLeft;
	newHeight=(Math.trunc(height/25)-1)*25;
	newWidth=Math.trunc(width/10)*10;
	marginLeft=(width-newWidth)/2;
	
	/*console.log(height);
	console.log(newHeight);
	console.log(width);
	console.log(newWidth);
	console.log(marginLeft);
	console.log((height-newHeight)/2);*/
	let clientWidth = document.documentElement.clientWidth || document.body.clientWidth;
	let clientHeight = document.getElementsByClassName("wbox")[0].clientHeight;
	//设计图参考宽度
	let designW = 1920,designH = 943;
	let fontSize = Math.min(Math.trunc(parseInt(clientWidth) / designW * 13), Math.trunc(parseInt(clientHeight) / designH * 13));

	
	//设置ul样式
	ul.style.width=newWidth.toString()+"px";
	ul.style.height=newHeight.toString()+"px";
	ul.style.marginTop=((height-newHeight)/2).toString()+"px";
	
	var lines=0,lineHeight=0;
	var lineHeights=[25,30,35];
	for(var i=0;i<lineHeights.length;i++){
		if(newHeight%lineHeights[i]==0){
			lines=newHeight/lineHeights[i];
			lineHeight=lineHeights[i];
			break;
		}
	}

	
	ul.style.lineHeight=lineHeight.toString()+"px";
	ul.style.fontSize=lineHeight.toString()+"px";
	
	/*console.log(lines);
	console.log(lineHeight);*/
	
	
	
	
	//动态添加li 同时动态添加数据
	 var templateStr1 = "<li style=height:"+lineHeight+"px;margin-left:"+marginLeft+"px;><p style='height:"+lineHeight+"px;text-align:left;margin-left:7%;width:50%;'></p><p style='height:"+lineHeight+"px;text-align:right; color:#7AB2FF;width:40%;'></p></li>";
	 var templateStr2 = "<li style=height:"+lineHeight+"px;margin-left:"+marginLeft+"px;><p style='height:"+lineHeight+"px;font-size:25px;text-align:left;margin-left:7%;width:50%;'></p><p style='font-size:25px;height:"+lineHeight+"px;text-align:right; color:#7AB2FF;width:40%;'></p></li>";
	 var templateStr;
	 if(fontSize*1.2 > 25) templateStr = templateStr2;
	 else templateStr = templateStr1;
	 var str="";
	 for(var i=0;i<=lines;i++){
			//str+="<li class='item'><p>"+parkName[i]+"</p><div class='text'><span class='in'>"+numberOfEntrance[i]+"</span><span class='out''>"+numberOfExit[i]+"</span></div></li>";

			str+=templateStr;
			document.getElementById("ulreal").innerHTML = str;
	  };
						
});