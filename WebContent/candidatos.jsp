<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>                     


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aplicaci?n Gesti?n de Usuarios</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">

</head>
<body>

<header>
<nav class="navbar navbar-expand-md navbar-dark">

<div>
<a href="#" class="navbar-brand"> Gesti?n de Usuarios</a>

</div>

<ul class="navbar-nav">
<li><a href="<%=request.getContextPath()%>/list" class="nav-link">Usuarios</a></li>

</ul>


</nav>
</header>

<br/>

<div class="row">
    <div class="container">
        <h3 class="text-center">Listado de candidatos</h3>
        <hr>
        <div class="container text-left">
        <a href="<%=request.getContextPath() %>/new" class="btn btn-success">Agregar nuevo Cant</a>
        </div>
    <br>
    <table class="table table-bordered">
       <thead>
          <tr>
                  <th>ID</th>
                  <th>Documento</th>
                  <th>Nombre</th>
                  <th>Apellido</th>
                  <th>Eleccion</th>
                  <th>Numero</th>
    </tr>
    </thead>
    <tbody>
    <!-- for (todo todo: todos) {   -->
   <c:forEach var="usuario" items="${listUsuarios}">
       <tr>
          <td>
               <c:out value="${usuario.id}" />
          </td>
          
          <td>
               <c:out value="${usuario.nombre}" />
          </td>
          
          <td>
               <c:out value="${usuario.email}" />
          </td>
          
           <td>
               <c:out value="${usuario.pais}" />
          </td>
        
        <td><a href="edit?id=<c:out value="${usuario.id}" />">Editar</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value="${usuario.id}" />">Eliminar</a></td>
     </tr>
     </c:forEach>
    <!-- } -->
    
    </tbody>
    </table>
    </div>



</div>

</body>
</html>