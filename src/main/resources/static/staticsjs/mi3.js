var chartDom_7 = document.getElementById('mi3');
var myChart_7 = echarts.init(chartDom_7);
var option;

$.ajax({
    url: '/statics/getRoleCounts',
    dataType: 'json',
    type: 'get',
    success: function (res) {
        $("#m3").html(parseInt(res.data.职工/(res.data.医生+res.data.用户+res.data.职工)*100)+"%")
option = {
    title: {
        text: "职工",
        subtext:res.data.职工 +'个',
        x: '10%',
        y: '10%',
        subtextStyle: {
            color: "#333333",
            fontSize: 16,
            fontWeight: 'bold'
        },
        textStyle: {
            color: "#333333",
            fontSize: 16,
            fontWeight: 'normal'
        }
    },
    tooltip: {
        trigger: 'item'
    },
    legend: {
        show:false,
        formatter: function (name) {
            let data = option.series[0].data
            // console.log(data, 'data')
            let total = 0
            let tarValue
            for (let i = 0; i < data.length; i++) {
                total += data[i].value
                if (data[i].name == name) {
                    tarValue = data[i].value
                }
            }
            let v = tarValue
            let p = (v/total)*100 //占比
            return `${name}     ${v}    ${p}%`
        },
    },
    color:['#D7DDE7', '#4461FF'],
    series: [
        {
            type: 'pie',
            smooth:true,
            center: ["75%", "70%"],
            radius: ['30%', '40%'],
            avoidLabelOverlap: false,
            label: {

                normal: {
                    show: false,
                    position: 'center',
                    // top:'10%',
                    formatter:function (argument) {
                        var html;
                        html='15%';
                        return html;
                    },
                    textStyle:{
                        fontSize: 15,
                        color:'#333333'
                    }
                }
            },
            emphasis: {
                label: {
                    show: false,
                    fontSize: '40',
                    fontWeight: 'bold',
                    lineHeight: 30
                }
            },

            labelLine: {
                show: false
            },
            data: [
                {value: res.data.医生+res.data.用户, name: ''},
                {value: res.data.职工, name: ''},
            ]
        }
    ]
};

option && myChart_7.setOption(option);
        myChart_7.off('click'),
            myChart_7.on('click', function (result) {
                layui.layer.open({
                    type: 2,
                    title: false,
                    //skin: 'layui-layer-rim', //加上边框
                    area: ['80%', '80%'], //宽高
                    content: ['/staff']  //跳到新增页面
                });
            })
    }
})
