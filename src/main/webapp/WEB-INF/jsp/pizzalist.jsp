<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ page errorPage="../generalErrorPage.jsp" %>

<!DOCTYPE html>	
<html>
<head>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
   
  <style>
     <%@include file='../proj.css' %>
  </style>
    <script src="js/FillClick.js"></script>
</head> 

<body>

<form action="Controller" method="post" id="myForm">
<input class="hidden" id ="command" name="command" type="text" value="">
<input class="hidden" id ="Id" name="docId" type="text" value="" >

<div class="container-fluid bg-grey">
 	   <h2>
 	   		List of Pizzas
 	   </h2>
 	   
 	   <table class="table table-striped table-hover table-condensed " id="documenttab" style="width:95%;">
            <thead>
                <tr>
                    <th><h3>ID</h3></th>
                    <th><h3>Name</h3></th>
                    <th><h3>Price</h3></th>
                    <th><h3>Type</th>
                    <th><h3></h3></th>
                    <th><h3></h3></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="pizza" items="${pizzalist}" varStatus="count">
                     <tr>
                        <td>${pizza.pizzaId}</td>
                        <td align="left" id="row${pizza.pizzaId}">${pizza.name}</td>
                        <td align="left">${pizza.price}</td>
                        <td align="left">${pizza.type}</td>
                        <td>
                            <button type="button" class="btn btn-primary btn-xs" id="${pizza.pizzaId}"
                                    onclick="doUpdate(event,'ShDocumentUpdate')">Edit
                            </button>
                        </td>
                        <td>
                            <button  type="button" class="btn btn-warning btn-xs" id="${pizza.pizzaId}"
                               onclick="showDelete(event)">Delete
                            </button>
                        </td>
                    </tr>
                 </c:forEach>
            </tbody>
       </table>

        <div class="text-center">
            <a href="create">
               <div class="btn-group">
                  <button type="button" id="crtupd" class="btn1  btn-default btn-lg btn-success">
                            Create
                  </button>
               </div>
            </a>
        </div>
        <footer style="margin-top:10px; text-align: center">&copy;Alex, Kyiv, 2016</footer>
  
    </div>
 </form>
 </body>

<script type="text/javascript">
var name, latch = false;

function doDelete(comm) {
	$('#command').val(comm);
	$('#Id').val($('.modalDeleteBtn').attr('id'));
 	$('#myForm').submit();
};

function showDelete(event) {
	$('.modalDeleteBtn').attr('id', event.target.id);
	name = $('#documenttab #row' + event.target.id).text();
	if (!latch){
		$('#myModalLabel').text($('#myModalLabel').text() + ' \'' + name +'\'');
		latch = true;
	}
	$('#myModal').modal('show');
};
</script>
</html>