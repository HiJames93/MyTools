layui.use(['form','layer','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;



    //用户列表
    var tableIns = table.render({
        elem: '#deptList',
        url : '/dept/loadAlldept',
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limits : [10,15,20,25],
        limit : 20,
        id : "deptTable",
        cols : [[
            ,{field:'id', title:'id', align:'center'}
            ,{field:'pid', title:'父级部门ID', align:'center'}
            ,{field:'title', title:'部门名称', align:'center'}
            ,{field:'address', title:'部门地址', align:'center'}
            ,{field:'remark', title:'部门备注', align:'center'}
            ,{field:'createtime', title:'创建时间', align:'center'}
            ,{title: '操作', minWidth:175, templet:'#deptListBar',fixed:"right",align:"center"}
        ]]
    });

    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
    $(".search_btn").on("click",function(){
        if($(".searchVal").val() != ''){
            table.reload("deptsListTable",{
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: {
                    realname: $(".searchVal").val()  //搜索的关键字
                }
            })
        }else{
            layer.msg("请输入搜索的内容");
        }
    });

    $(".addNews_btn").click(function(){
        adddept();
    })

    //批量删除
    $(".delAll_btn").click(function(){
        var checkStatus = table.checkStatus('deptTable');
        var data = checkStatus.data;
        var uIds = [];
        if (data.length > 0) {
            layer.confirm('你确定要删除这些数据吗？',{icon:3, title:'提示'},function (index) {
                var data=checkStatus.data;
                var ids="";
                $.each(data, function (index,item) {
                    if (index==0){
                        ids+="ids="+item.id;
                    }else {
                        ids+="&ids="+item.id;
                    }
                })
                $.post("/logInfo/batchDeleteLoginfo",ids,function (res) {
                    if (res.code == 200){
                        tableIns.reload();
                    }
                    layer.msg(res.msg);
                });
            })
        }else {
            layer.msg("请选择需要删除的数据");
        }
    })

    //列表操作
    table.on('tool(deptList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){ //编辑
            adddept(data);
        }else if(layEvent === 'usable'){ //启用禁用
            var _this = $(this),
                usableText = "是否确定禁用此用户？",
                btnText = "已禁用";
            if(_this.text()=="已禁用"){
                usableText = "是否确定启用此用户？",
                btnText = "已启用";
            }
            layer.confirm(usableText,{
                icon: 3,
                title:'系统提示',
                cancel : function(index){
                    layer.close(index);
                }
            },function(index){
                _this.text(btnText);
                layer.close(index);
            },function(index){
                layer.close(index);
            });
        }else if(layEvent === 'del'){ //删除
            layer.confirm('确定删除此用户？',{icon:3, title:'提示信息'},function(index){
                $.post("/logInfo/deleteLoginfo",{id:data.id},function (res) {
                    if (res.code == 200){
                        tableIns.reload();
                    }
                    layer.msg(res.msg);
                });
                layer.close(index);
            });
        }else if(layEvent === 'show'){ //删除
            layer.confirm('确定删除此用户？',{icon:3, title:'提示信息'},function(index){
                $.post("/logInfo/deleteLoginfo",{id:data.id},function (res) {
                    if (res.code == 200){
                        tableIns.reload();
                    }
                    layer.msg(res.msg);
                });
                layer.close(index);
            });
        }
    });

})
