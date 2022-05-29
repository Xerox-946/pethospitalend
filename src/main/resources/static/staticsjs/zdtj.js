var chartDom_2 = document.getElementById('zdtj');
var myChart_2 = echarts.init(chartDom_2);
var option;
const colors = ['#FFA176','#FFCB76', '#5BEBB8', '#4EE6FF', '#57A7FF'];

$.ajax({
    url: '/statics/getdAppointment',
    dataType:'json',
    type:'get',
    success:function (res) {
        console.log(res.data)

option = {
    title: {

    },
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'shadow'
        }
    },
    color: colors,
    // legend: {},
    grid: {
        left: '3%',
        right: '4%',
        bottom: '20%',
        containLabel: true
    },
    axisTick:{//坐标轴刻度相关设置
        show:false,//是否显示坐标轴刻度
        // alignWithLabel:true,//可以保证刻度线和标签对齐
    },
    xAxis: {
        type: 'value',
        boundaryGap: [0, 0.01],

    },
    yAxis: {
        type: 'category',
        data: [res.data[0].dName, res.data[1].dName, res.data[2].dName],

    },

    series: [
        {
            name: '挂诊人数',
            type: 'bar',
            data: [res.data[0].counts, res.data[1].counts, res.data[2].counts],
            itemStyle: {
                normal:{
                    color: function(params){
                        return colors[params.dataIndex];
                        // 取每条数据的 index 对应 colors 中的 index 返回这个颜色
                    }
                }
            },
        }
    ]
};

option && myChart_2.setOption(option);
        myChart_2.off('click'),
            myChart_2.on('click', function (result) {
                layui.layer.open({
                    type: 2,
                    title: false,
                    //skin: 'layui-layer-rim', //加上边框
                    area: ['80%', '80%'], //宽高
                    content: ['/appointment?dName='+result.name]  //跳到新增页面
                });
            })
    }})