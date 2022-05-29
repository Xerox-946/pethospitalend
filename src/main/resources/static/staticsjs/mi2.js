var chartDom_6 = document.getElementById('mi2');
var myChart_6 = echarts.init(chartDom_6);
var option;


$.ajax({
    url: '/statics/getRoleCounts',
    dataType: 'json',
    type: 'get',
    success: function (res) {
        $("#m2").html(parseInt(res.data.用户/(res.data.医生+res.data.用户+res.data.职工)*100)+"%")
        option = {
            title: {
                text: "用户",
                subtext: res.data.用户+'个',
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
                show: false,
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
                    let p = (v / total) * 100 //占比
                    return `${name}     ${v}    ${p}%`
                },
            },
            color: ['#D7DDE7', '#2CDFB6'],
            series: [
                {
                    type: 'pie',
                    smooth: true,
                    center: ["75%", "70%"],
                    radius: ['30%', '40%'],
                    avoidLabelOverlap: false,
                    label: {

                        normal: {
                            show: false,
                            position: 'center',
                            // top:'10%',
                            formatter: function (argument) {
                                var html;
                                html = '25%';
                                return html;
                            },
                            textStyle: {
                                fontSize: 15,
                                color: '#333333'
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
                        {value: res.data.医生+res.data.职工, name: ''},
                        {value: res.data.用户, name: ''},
                    ]
                }
            ]
        };

        option && myChart_6.setOption(option);
        myChart_6.off('click'),
            myChart_6.on('click', function (result) {
                layui.layer.open({
                    type: 2,
                    title: false,
                    //skin: 'layui-layer-rim', //加上边框
                    area: ['80%', '80%'], //宽高
                    content: ['/owner']  //跳到新增页面
                });
            })
    }
})