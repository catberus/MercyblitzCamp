<%--
  Created by IntelliJ IDEA.
  User: catberus
  Date: 2021-03-03
  Time: 1:19
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <jsp:directive.include file="/WEB-INF/jsp/prelude/include-head-meta.jspf"/>
    <title>Title</title>
</head>
<body>
<form action="register" method="post">
    用户名<input type="text" name="name"/><br>
    密码<input type="password" name="password"/><br>
    邮箱<input type="password" name="email"/><br>
    手机<input type="password" name="phoneNumber"/><br>
    <input type="submit" value="提交"/>

</form>

</body>
</html>
