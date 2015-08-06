<%--
&lt;%&ndash;
  Created by IntelliJ IDEA.
  User: Home
  Date: 4/08/2015
  Time: 9:37 PM
  To change this template use File | Settings | File Templates.
&ndash;%&gt;
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" class="com.dzhao.exams.beans.UserBean" scope="session">
  <jsp:setProperty name="user" property="*"/>
</jsp:useBean>
<html>
<head>
    <title></title>
</head>
<body>
<c:if test="${user.valid()}">
  <jsp:forward page="register"/>
</c:if>
<form method="post" action="register.jsp">
  <br/><input type="text" name="username"/>
  <br/><input type="text" name="password"/>
  <br/><input type="text" name="emailAddress"/>
  <br/><input type="submit"/>
</form>
</body>
</html>
--%>
