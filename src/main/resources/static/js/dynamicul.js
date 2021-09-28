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
	 var str="";
	 for(var i=0;i<=lines;i++){
			//str+="<li class='item'><p>"+parkName[i]+"</p><div class='text'><span class='in'>"+numberOfEntrance[i]+"</span><span class='out''>"+numberOfExit[i]+"</span></div></li>";
			str+="<li style=height:"+lineHeight+"px;margin-left:"+marginLeft+"px;><p style='text-align:left;margin-left:7%;width:50%;'></p><p style='text-align:right; color:#7AB2FF;width:40%;'></p></li>"
			document.getElementById("ulreal").innerHTML = str;
	  };
						
});