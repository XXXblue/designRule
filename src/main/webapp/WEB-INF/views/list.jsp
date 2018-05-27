<%--
  Created by IntelliJ IDEA.
  User: xiaojianyu
  Date: 2018/5/27
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <c:set var="baseurl" value="${pageContext.request.contextPath}/"/>
    <link rel="stylesheet" href="${baseurl}assert/plugins/layui/css/layui.css" media="all">
    <script src="${baseurl}assert/plugins/layui/layui.js"></script>
</head>
<body>
<%--查询模块start--%>
<fieldset class="layui-elem-field site-demo-button"style="padding-left: 20px;margin-left: 20px;margin-right: 20px">
    <legend>查询订单信息</legend>
    <blockquote class="layui-elem-quote">
        <form class="layui-form layui-form-pane " action="" accept-charset="UTF-8">
            <div class="layui-inline">
                <div class="layui-form-item" style="width: 300px">
                    <label class="layui-form-label">用户id</label>
                    <div class="layui-input-block">
                        <input type="text" name="sysuserCustom.id"  placeholder="请输入用id" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item" style="width: 300px">
                    <label class="layui-form-label">用户组别</label>
                    <div class="layui-input-block">
                        <select name="sysuserCustom.groupid"  lay-verify="">
                            <option value="">全部</option>
                            <option value="0">超级管理员</option>
                            <option value="1">设计组</option>
                            <option value="2">资源组</option>
                            <option value="3">测试组</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="layui-inline">
                <div class="layui-form-item" style="width: 300px">
                    <label class="layui-form-label">用户名</label>
                    <div class="layui-input-block">
                        <input type="text" name="sysuserCustom.username"  placeholder="请输入用户名" autocomplete="off" class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-inline">
                <div class="layui-form-item " style="width: 200px">
                    <div class="layui-input-block">
                        <button id="search" class="layui-btn" style="width: 190px"  lay-submit lay-filter="search"><i class="layui-icon">&#xe615;</i>查询</button>
                    </div>
                </div>
            </div>
        </form>
    </blockquote>
</fieldset>
    <table id="manageTimeTable" class="layui-table"  lay-filter="manageTimeTable" ></table>
</body>
<script>
    layui.use(['jquery','layer','form','table','laydate'], function() {
        var $ = layui.$;
        var layer = layui.layer;
        var table = layui.table;
        var form = layui.form;
        var laydate = layui.laydate;
        //表格展示模块start
        table.render({
            id:'manageTimeTable',
            elem: '#manageTimeTable',
            url: '${baseurl}querySysuser.json',
            cols:  [[ //标题栏
                {checkbox: true, LAY_CHECKED: false}
                ,{field: 'id', align:'center',title: '用户id', width: 150}
                ,{field: 'userid', align:'center',title: '用户姓名缩写英文', width: 150}
                ,{field: 'username', align:'center',title: '用户名', width: 150}
                ,{field: 'groupid', align:'center',title: '组别', width: 150}
                ,{field: 'pwd',align:'center', title: '密码', width: 150}
                ,{field: 'sysid', align:'center',title: '所属组的id', width: 150}
                ,{field: 'mc', align:'center',title: '所属组的名称', width: 150}
            ]],
            page:true,
            limits: [10,2,3],
            limit:10,
            height:800
        });

        //      查询start
        $('#search').on('click',function () {
            form.on('submit(search)', function(data){
                console.log(data.field);
                table.reload('manageTimeTable', {
                    method:'post',
                    url: '${baseurl}querySysuser.json'
                    ,where: data.field
                });
                return false;
            });
        });
    });
</script>
</html>
