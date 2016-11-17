<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%-- Created by IntelliJ IDEA.
 User: s_okhoda
 Date: 20.01.2016
 Time: 17:52
 To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <input  type="text" id="login" ng-model="login"><br>

        <label for="identifier">IDENTIFIER: </label>
        <input  type="text" id="identifier" ng-model="identifier"><br>

        <label for="pass">PASSWORD: </label>
        <input  type="password" value="" id="pass" ng-model="pass"><br>

        <label for="confirmPass">CONFIRM PASSWORD: </label>
        <input  type="password" value="" id="confirmPass"
                ng-model="confirmPass">
        <br>
        <br>
        <footer style="text-align: center">&copy;Alex, Kyiv, 2016</footer>
    </form>
    </body>
</html>
