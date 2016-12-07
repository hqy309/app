<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="js/jquery-easyui-1.5/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.5/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.5/locale/easyui-lang-zh_CN.js"></script>
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.5/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.5/themes/icon.css">
</head>

<body>
<table id="dg" title="My Users" class="easyui-datagrid" style="width:550px;height:250px"
       url="user/userList"
       toolbar="#toolbar"
       rownumbers="true" fitColumns="true" singleSelect="true">

    <thead>
    <tr>
        <th field="firstname" width="50">First Name</th>
        <th field="lastname" width="50">Last Name</th>
        <th field="phone" width="50">Phone</th>
        <th field="email" width="50">Email</th>
    </tr>
    </thead>
</table>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">New User</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">Edit User</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">Remove User</a>
</div>
</body>
</html>