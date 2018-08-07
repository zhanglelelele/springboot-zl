<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/31 0031
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet"
          href="<%=request.getContextPath() %>/EasyUI/themes/default/easyui.css" type="text/css"/>
    <!-- 引入EasyUI的图标样式文件-->
    <link rel="stylesheet"
          href="<%=request.getContextPath() %>/EasyUI/themes/icon.css" type="text/css"/>
</head>
<body>

<div id="cc" class="easyui-layout" data-options="fit:true">

    <div data-options="region:'east',iconCls:'icon-reload',title:'East',split:true" style="width:300px;">
        <ul id="tt1"></ul>
        <input type="button"  value="用户角色"  onclick="addUserRole()">
    </div>
    <div data-options="region:'west',split:true" style="width:300px;">
        <ul id="tt2"></ul>

    </div>
    <div data-options="region:'center'" style="padding:5px;background:#eee;">

        <ul id="tt3"></ul>
        <input type="button"  value="角色权限"  onclick="addRolePermiss()">
    </div>
</div>










<!-- 引入JQuery -->
<script type="text/javascript"
        src="<%=request.getContextPath() %>/EasyUI/jquery.min.js"></script>

<!-- 引入EasyUI -->
<script type="text/javascript"
        src="<%=request.getContextPath() %>/EasyUI/jquery.easyui.min.js"></script>

<!-- 引入EasyUI的中文国际化js，让EasyUI支持中文 -->
<script type="text/javascript"
        src="<%=request.getContextPath() %>/EasyUI/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"
        src="<%=request.getContextPath() %>/EasyUI/util-js.js"></script>
<script>
    $('#tt2').tree({
        url:'<%=request.getContextPath() %>/con/queryusers',
        checkbox:true,
        onlyLeafCheck:true,
        parentField:'pid',onClick: function(node){
            quertusert(node.id)
        }
    });
    $('#tt1').tree({
        url:'<%=request.getContextPath() %>/con/queryrole',
        checkbox:true,
        onlyLeafCheck:true,
        parentField:'pid',
    });
    $('#tt3').tree({
        url:'<%=request.getContextPath() %>/con/querypermiss',
        checkbox:true,
        onlyLeafCheck:true,
        parentField:'pid',
    });
    function addUserRole(){
        var nodes = $('#tt1').tree('getChecked');
        var role = $('#tt2').tree('getChecked');
        var str=''
        for (var i = 0; i < nodes.length; i++) {
            str +=','+ nodes[i].id;
        }
        var roleid=''
        for (var i = 0; i < role.length; i++) {
            roleid += ','+role[i].id;
        }
        str= str.substring(1)
        roleid=roleid.substring(1)
        $.ajax({
            url:"<%=request.getContextPath() %>/con/addUserRole",
            type:"post",
            data:{userid:roleid,roleid:str},
            success:function (result){
                if(result==1){
                    alert("成功")
                }
            }
        })
    }
    function addRolePermiss(){
        var role = $('#tt1').tree('getChecked');
        var Permiss = $('#tt3').tree('getChecked');
        var Permissid=''
        for (var i = 0; i < Permiss.length; i++) {
            Permissid +=','+ Permiss[i].id;
        }
        var roleid=''
        for (var i = 0; i < role.length; i++) {
            roleid += ','+role[i].id;
        }
        Permissid= Permissid.substring(1)
        roleid=roleid.substring(1)
        $.ajax({
            url:"<%=request.getContextPath() %>/con/addRolePermiss",
            type:"post",
            data:{Permissid:Permissid,roleid:roleid},
            success:function (result){
                if(result==1){
                    alert("成功")
                }
            }
        })
    }
    function   quertusert(id) {
        $('#tt1').tree({
            url:'<%=request.getContextPath() %>/con/queryroless?id='+id,
            checkbox:true,
            onlyLeafCheck:true,
            parentField:'pid',
        });
        $('#tt3').tree({
            url:'<%=request.getContextPath() %>/con/queryroless?id='+id,
            checkbox:true,
            onlyLeafCheck:true,
            parentField:'pid',
        });
    }




</script>
</body>
</html>
