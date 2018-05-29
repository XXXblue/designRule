<%--
  Created by IntelliJ IDEA.
  User: xiaojianyu
  Date: 2018/5/29
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <c:set var="baseurl" value="${pageContext.request.contextPath}/"/>
</head>
<body>
    <form action="${baseurl}uploadfile" method="POST" enctype="multipart/form-data">
        文件1: <input type="file" name="myfiles"/><br/>
        文件2: <input type="file" name="myfiles"/><br/>
        文件3: <input type="file" name="myfiles"/><br/>
        <input type="submit" value="上传"/>
    </form>
</body>
</html>
