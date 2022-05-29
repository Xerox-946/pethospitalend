var chartDom_1 = document.getElementById('circle');
var myChart_1 = echarts.init(chartDom_1);
var option;
var data;
var dataCake
layui.use('layer', function () {
    var element = layui.element;
    var $ = layui.jquery;

    $.ajax({
        url: '/statics/getPTypeCount',
        dataType:'json',
        type:'get',
        success:function (res) {
            data=res.data
            dataCake=[
                { value: data[0].counts, name: data[0].ptype,percentage:(data[0].counts/(data[0].counts+data[1].counts+data[2].counts+data[3].counts+data[4].counts)).toPrecision(2)*100+'%' },
                { value: data[1].counts, name: data[1].ptype,percentage:(data[1].counts/(data[0].counts+data[1].counts+data[2].counts+data[3].counts+data[4].counts)).toPrecision(2)*100+'%' },
                { value: data[2].counts, name: data[2].ptype,percentage:(data[2].counts/(data[0].counts+data[1].counts+data[2].counts+data[3].counts+data[4].counts)).toPrecision(2)*100+'%' },
                { value: data[3].counts, name: data[3].ptype,percentage:(data[3].counts/(data[0].counts+data[1].counts+data[2].counts+data[3].counts+data[4].counts)).toPrecision(2)*100+'%' },
                { value: data[4].counts, name: data[4].ptype,percentage:(data[4].counts/(data[0].counts+data[1].counts+data[2].counts+data[3].counts+data[4].counts)).toPrecision(2)*100+'%' }
            ]
            option = {
                title: {
                    text: data[0].counts+data[1].counts+data[2].counts+data[3].counts+data[4].counts+"只",
                    subtext: '  总数',
                    x: '15%',
                    y: '50%',
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
                    trigger:false
                },
                color: ['#4461FF','#FFDA4D','#2CDFB6','#FFA129','#FF2342'],
                legend: {
                    left: '50%',
                    itemHeight: 10,
                    itemWidth: 10,
                    itemGap: 20,
                    orient: 'vertical',
                    icon: "circle",
                    bottom: '20%',

                    formatter:function(name){
                        let target,percentage;
                        for(let i=0;i<dataCake.length;i++){
                            if(dataCake[i].name===name){
                                target=dataCake[i].value+"只"
                                percentage=dataCake[i].percentage
                            }
                        }
                        let arr=[name+' '," "+target+'',""+percentage]
                        return arr.join(" ")

                    },

                },
                series: [
                    {
                        type: 'pie',
                        center: ["20%", "60%"],
                        radius: ['45%', '65%'],
                        avoidLabelOverlap: false,
                        label: {
                            show:false
                            // normal: {
                            //     show: false,
                            //     position: 'center',
                            //     formatter:function (argument) {
                            //         var html;
                            //         html='1584\r\n\r\n'+'总数';
                            //         return html;
                            //     },
                            //     textStyle:{
                            //         fontSize: 15,
                            //         color:'#000'
                            //     }
                            // }
                        },
                        // emphasis: {
                        //     label: {
                        //         show: false,
                        //         fontSize: '40',
                        //         fontWeight: 'bold',
                        //         lineHeight: 30
                        //     }
                        // },

                        labelLine: {
                            show: false
                        },
                        data: dataCake,
                    }
                ]
            };

            option && myChart_1.setOption(option);
            myChart_1.off('click'),
                myChart_1.on('click', function (result) {
                    layui.layer.open({
                        type: 2,
                        title: false,
                        //skin: 'layui-layer-rim', //加上边框
                        area: ['80%', '80%'], //宽高
                        content: ['/pet?type='+result.name]  //跳到新增页面
                    });
                })

        }
    });
});
