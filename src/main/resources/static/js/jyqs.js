var chartDom = document.getElementById('jyqs');
var myChart = echarts.init(chartDom);
var option;

option = {
    xAxis: {
        type: 'category',
        boundaryGap: false,
        data: ['2.08', '2.09', '2.10', '2.11', '2.12', '2.13', '2.14', '2.15', '2.16', '2.17', '2.18', '2.19', '2.20', '2.21']
    },
    yAxis: {
        type: 'value',
        name:'借阅数量/件次',
    },
    grid:{

    },

    series: [
        {
            color:"#54FFF0",
            data: [0,0,0,0,56, 5,0,0,0, 36, 10, 20, 0, 0],
            type: 'line',
            smooth:true,
            symbol: "none",
            areaStyle: {
                normal: {//自定义颜色，渐变色填充折线图区域
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1,//变化度
                        //渐变色
                        [{
                            offset: 0,
                            color: 'rgba(141, 253, 217, 1)'
                        }, {
                            offset: 1,
                            color: 'rgba(130, 253, 210, 0)'
                        }]),
                },
            },
        }
    ]
};

option && myChart.setOption(option);
