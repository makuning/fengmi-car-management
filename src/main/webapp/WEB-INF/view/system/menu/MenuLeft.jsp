    <%--
    Created by IntelliJ IDEA.
    User: Administrator
    Date: 2020/2/15
    Time: 15:10
    To change this template use File | Settings | File Templates.
    --%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
    <meta charset="utf-8">
    <title>菜单树</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="icon" href="favicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/public.css" media="all"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui_ext/dtree/dtree.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui_ext/dtree/font/dtreefont.css">
    </head>
    <body class="main_body">

    <ul id="menuTree" class="dtree" data-id="0"></ul>

    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
    <script type="text/javascript">
        var menuTree;
        layui.extend({
        dtree: '${pageContext.request.contextPath}/resources/layui_ext/dist/dtree'
        }).use(['jquery','layer','form','dtree'],function() {
            var $ = layui.query;
            var layer = layui.layer;
            var form = layui.form;
            var dtree = layui.dtree;
            menuTree =  dtree.render({
                elem: "#menuTree",
                url: "${pageContext.request.contextPath}/menu/loadMenuManagerLeftTreeJson.action?spread=1",
                dataFormat: "list",  //配置data的风格为list
                dataStyle:"layuiStyle",
                response:{message:"msg",statusCode:0}
        });

        // 点击节点名称获取选中节点值
        dtree.on("node('menuTree')" ,function(obj){
            //点击数,刷新右侧的表格数据
            var id = obj.param.nodeId;
            window.parent.right.reloadTable(id);
        });
        })
    </script>
    </body>
    </html>
