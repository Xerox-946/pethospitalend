var chartDom_3 = document.getElementById('ghqs');
var myChart_3 = echarts.init(chartDom_3);
var option;
var data="";
$.ajax({
    url: '/statics/lastforteenDayDiagnosis',
    dataType:'json',
    type:'post',
    async: false,
    success:function (res) {
        data = res.data;
        console.log(data);
        for (let i = 0; i <data.length; i++) {
            data[i].days=data[i].dates.substring(data[i].dates.indexOf("-")+1);
        }}})
option = {
    xAxis: {
        type: 'category',
        boundaryGap: false,
        data: [data[13].days, data[12].days, data[11].days, data[10].days, data[9].days, data[8].days, data[7].days,
            data[6].days,data[5].days, data[4].days, data[3].days, data[2].days,data[1].days, data[0].days]
    },
    yAxis: {
        type: 'value',
        name:'挂号次数/次',
    },
    grid:{

    },

    series: [
        {
            color:"#54FFF0",
            data: [data[13].counts, data[12].counts, data[11].counts, data[10].counts, data[9].counts,data[8].counts, data[7].counts,
                data[6].counts, data[5].counts, data[4].counts, data[3].counts,data[2].counts, data[1].counts,data[0].counts],
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

option && myChart_3.setOption(option);
