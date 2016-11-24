<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%-- Created by IntelliJ IDEA.
 User: s_okhoda
 Date: 20.01.2016
 Time: 17:52
 To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="../../../js/taxi.js" type="text/javascript">    </script>
<script src="../../../js/angular.js"></script>
<script src="../../../js/registerAjax.js"></script>

<html>
    <head>
        <title>Registration Form</title>
        <style>
        <%--
            <%@include file='../css/addNotebook.css' %>
            --%>
        </style>
    </head>

    <body>
    <form >
        <label for="login">LOGIN: </label>
        <input  type="text" id="login" name="login"><br>

        <label for="password">PASSWORD: </label>
        <input  type="password" value="" name="password"><br>

        <br>
        <br>
        <footer style="text-align: center">&copy;Alex, Kyiv, 2016</footer>

        <p>
            Hello <b>${pageContext.request.remoteUser}</b>
        </p>
    </form>

    <c:url var="logoutUrl" value="/logout"/>
      <form class="form-inline" action="${logoutUrl}" method="post">
        <input type="submit" value="Log out" />
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
      </form>
    </body>
</html>
