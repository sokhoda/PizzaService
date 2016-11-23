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
  <%--
    <script src="js/FillClick.js"></script>
    --%>
</head> 

<body>

<form action="addnew" method="post" id="myForm">
<input class="hidden" id ="command" name="command" type="text" value="">
<input class="hidden" id ="Id" name="docId" type="text" value="" >

<div class="container-fluid bg-grey">
 	   <h2>
 	   		Pizzas
 	   </h2>
 	   
       		<div class="form-group ">
       			<label for="reg1" class="lb-lg">ID</label>
       			<input class="form-control input-lg" id="reg1" type="text"
       				value="${pizza.pizzaId}" name="pizzaId" >
       		</div>

       		<div class="form-group ">
       			<label for="reg1" class="lb-lg">Name</label>
       			<input class="form-control input-lg" id="reg1" type="text"
       				value="${pizza.name}" name="name">
       		</div>
       		<div class="form-group ">
                <label for="reg1" class="lb-lg">Price</label>
                <input class="form-control input-lg" id="reg1" type="text"
                    value="${pizza.price}" name="price">
            </div>
            <div class="form-group ">
       			<label for="reg1" class="lb-lg">Type</label>
       			<input class="form-control input-lg" id="reg1" type="text"
       				value="${pizza.type}" name="type">
       		</div>

        <div class="text-center">
           <div class="btn-group">
              <button type="button" id="crtupd" class="btn1  btn-default btn-lg btn-success"
                    onclick="$('#myForm').submit()">
                        Create
              </button>
           </div>
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