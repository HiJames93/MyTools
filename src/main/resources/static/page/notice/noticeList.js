layui.use(['form','layer','table','laytpl','layedit'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        layedit = layui.layedit,
        table = layui.table;

    //初始化富文本
    var editIndex = layedit.build('content');


    //用户列表
    var tableIns = table.render({
        elem: '#userList',
        url : '/notice/loadAllNotice',
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limits : [10,15,20,25],
        limit : 20,
        id : "noticeTable",
        cols : [[
            {type: 'checkbox', fixed: 'left'}
            ,{field:'id', title:'id', align:'center'}
            ,{field:'title', title:'标题', align:'center'}
            ,{field:'opername', title:'发布者', align:'center'}
            ,{field:'createtime', title:'发布时间', align:'center'}
            ,{title: '操作', minWidth:175, templet:'#userListBar',fixed:"right",align:"center"}
        ]]
    });

    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
    $(".search_btn").on("click",function(){
        if($(".searchVal").val() != ''){
            table.reload("usersListTable",{
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

    var mainIndex;
    //打开弹出层
    function addUser(){
        //示范一个公告层
        mainIndex=layer.open({
            type: 1
            ,title: false //不显示标题栏
            ,closeBtn: false
            ,area: '300px;'
            ,shade: 0.8
            ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
            ,btn: ['知道了', '关闭']
            ,btnAlign: 'c'
            ,moveType: 1 //拖拽模式，0或者1
            ,content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">添加修改功能已经实现，只是笔记本带小不便于调试，占用弹窗代替！望广大网友理解！！</div>'
            ,success: function(layero){
                var btn = layero.find('.layui-layer-btn');
                btn.find('.layui-layer-btn0').attr({
                    href: '/main'
                    ,target: '_blank'
                });
            }
        });
    }
    $(".addNews_btn").click(function(){
        addUser();
    })

    //批量删除
    $(".delAll_btn").click(function(){
        var checkStatus = table.checkStatus('noticeTable');
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
    table.on('tool(userList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){ //编辑
            addUser(data);
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
