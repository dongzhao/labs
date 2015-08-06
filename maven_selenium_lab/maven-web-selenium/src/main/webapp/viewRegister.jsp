<%--
&lt;%&ndash;
  Created by IntelliJ IDEA.
  User: Home
  Date: 4/08/2015
  Time: 10:12 PM
  To change this template use File | Settings | File Templates.
&ndash;%&gt;
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
&lt;%&ndash;<jsp:useBean id="user" class="com.dzhao.exams.beans.UserBean" scope="request">
  <jsp:setProperty name="user" property="*"/>
</jsp:useBean>&ndash;%&gt;
<html>
<head>
    <title></title>
</head>
<body>
<div>
  <table>
    <tr>
      <td width="30%">username</td>
      <td width="30%">password</td>
      <td width="40%">email</td>
    </tr>
    <c:forEach items="${users}" var="user">
      <tr>
        <td>${user.username}</td>
        <td>${user.password} </td>
        <td>${user.emailAddress} </td>
      </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>
--%>
