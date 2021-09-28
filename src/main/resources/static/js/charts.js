	var myChart1 = echarts.init(document.getElementById('charts1'));
	//var myChart2 = echarts.init(document.getElementById('charts2'));
		 
	// 指定图表的配置项和数据
	var value = 23;
	var option;

    function fontSize(res){
        let clientWidth = document.documentElement.clientWidth || document.body.clientWidth;
        let clientHeight = document.getElementsByClassName("wbox")[0].clientHeight;
        //设计图参考宽度
        let designW = 1920,designH = 943;
        let fontSize = Math.min(Math.trunc(parseInt(clientWidth) / designW * 13), Math.trunc(parseInt(clientHeight) / designH * 13));
        return res*fontSize;
    }
	
	option = {
            backgroundColor: 'transparent',
            title: {
				text: `检修剩余`,
				subtext: '23天',
				left: 'center',
				top: '40%', //top待调整
				textStyle: {
					color: '#fff',
                    fontWeight: 'normal',
					fontSize: fontSize(1.4),
					fontFamily: 'PingFangSC-Regular',
				},
				subtextStyle: {
					color: '#fff',
					fontSize: fontSize(1.4),
					fontFamily: 'PingFangSC-Regular',
					top: 'center'
				},
				itemGap: fontSize(0.5) //主副标题间距
			},
            angleAxis: {
                show: false,
				clockwise: false,//逆时针
                max: 100, //-45度到225度，二者偏移值是270度除360度
                type: 'value',
                startAngle: 180, //极坐标初始角度
                splitLine: {
                    show: false
                }
            },
            barMaxWidth: fontSize(1.4), //圆环宽度
            radiusAxis: {
                show: false,
                type: 'category',
            },
            //圆环位置和大小
            polar: {
                center: ['50%', '50%'],
                radius: '120%'
            },
            series: [{
                type: 'bar',
                data: [{ //上层圆环，显示数据
                    value: 75,
                    itemStyle: {
                        color: { //图形渐变颜色方法，四个数字分别代表，右，下，左，上，offset表示0%到100%
                            type: 'linear',
                            x: 0,
                            y: 0,
                            x2: 1, //从左到右 0-1
                            y2: 0,
                            colorStops: [{
                                offset: 0,
                                color: '#00FFFF'
                            }, {
                                offset: 1,
                                color: '#00FFFF'
                            }],
                        },
                    },
                }],
                barGap: '-100%', //柱间距离,上下两层圆环重合
                coordinateSystem: 'polar', 
                roundCap: false, //顶端圆角从 v4.5.0 开始支持
                z: 2 //圆环层级，同zindex
            },
            { //下层圆环，显示最大值
                type: 'bar',
                data: [{
                    value: 100,
                    itemStyle: {
                        color: 'transparent'
                    }
                }],
                barGap: '-100%',
                coordinateSystem: 'polar',
                roundCap: true,
                z: 1
            },
            //仪表盘
            {
                name: 'AQI',
                type: 'gauge',
                startAngle: 180, //起始角度，同极坐标
                endAngle: -90, //终止角度，同极坐标
                axisLine: {
                    show: false,
                },
                splitLine: {
                    show: false
                },
                axisTick: {
                    show: false
                },
                axisLabel: {
                    show: false
                },
                splitLabel: {
                    show: false
                },
                pointer: {
                    show: false
                },
                title: {
                    show:false,
                },
                detail: {
                    show:false,
                },
                data: [{
                    value: 23,
                    name: '剩余天数'
                }]
            }
            ]
        };
				
	// 使用刚指定的配置项和数据显示图表。
	var option1=JSON.parse(JSON.stringify(option));//深拷贝
    option1.title.textStyle.fontSize=fontSize(1.4);
    option1.title.subtextStyle.fontSize=fontSize(1.4);
    option1.title.itemGap=fontSize(0.5);
    option1.barMaxWidth=fontSize(1.4);
	//option1.graphic.style.text="进料皮带转速";
	//var option2=JSON.parse(JSON.stringify(option));
	myChart1.setOption(option1);
   /* window.addEventListener('resize', function() {
        myChart1.resize();
        option1.title.textStyle.fontSize=fontSize(1.4);
        option1.title.subtextStyle.fontSize=fontSize(1.4);
        option1.title.itemGap=fontSize(0.5);
        option1.barMaxWidth=fontSize(1.4);
        myChart1.setOption(option1);
    })
	console.log(myChart1);*/
	//myChart2.setOption(option2);