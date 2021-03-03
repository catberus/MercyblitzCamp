<%@ page import="org.geektimes.projects.user.domain.User" %>
<%@ page import="java.util.Collection" %>
<head>
    <jsp:directive.include
            file="/WEB-INF/jsp/prelude/include-head-meta.jspf" />
    <title>My Home Page</title>
</head>
<body>
<div class="container-lg">
    注册成功
    <%
        Collection<User> userList = (Collection<User>)request.getAttribute("userList");
        for (User user: userList) {
    %>
    <%=user.getName()%>&nbsp;<%=user.getEmail()%>&nbsp;<%=user.getPhoneNumber()%><br>
    <%  } %>

</div>
</body>