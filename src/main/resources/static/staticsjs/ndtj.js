var chartDom_4 = document.getElementById('ndtj');
var myChart_4 = echarts.init(chartDom_4);
var option;

$.ajax({
    url: '/statics/getNDstatics',
    dataType:'json',
    type:'post',
    success:function (res) {
        console.log(res.data)
        var respend =res.data
        var years = new Array();
        var covert=new Array();
        for(let i = 0; i < respend.length; i++){
            years[i]=2012+i;
            covert[i]=respend[respend.length-i-1];
        }
        option = {
            xAxis: {
                type: 'category',
                boundaryGap: false,
                data: years
            },
            yAxis: {
                type: 'value',

            },
            grid: {},

            series: [
                {
                    color: "#54FFF0",
                    symbolSize: 5, // 设置折线上圆点大小
                    symbol: 'circle', // 设置拐点为实心圆
                    data: covert,
                    type: 'line',

                    areaStyle: {
                        normal: {//自定义颜色，渐变色填充折线图区域
                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1,//变化度
                                //渐变色
                                [{
                                    offset: 0,
                                    color: 'rgba(62, 222, 255, 1)'
                                }, {
                                    offset: 1,
                                    color: 'rgba(255, 255, 255, 0)'
                                }]),
                        },
                    },
                }
            ]
        };

        option && myChart_4.setOption(option)
    }})
