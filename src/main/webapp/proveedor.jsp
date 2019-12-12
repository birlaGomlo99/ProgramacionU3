<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html lang="es">
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
</head>
<body>
    <ul class="text-white bg-dark nav nav-pills">
      <li class="nav-item">
        <a class="nav-link active" href="next">Sucursal</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/">Productos</a>
    </li>
    <li class="nav-item">
        <a class="nav-link disabled" href="trabajador">trabajador</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="venta">Ventas</a>
    </li>
    <li class="nav-item">
        <a class="nav-link disabled" href="proveedor">Proveedor</a>
    </li>
</ul>
<div class="container">

    <h1>Proveedor</h1>
    <h2>Lista de nuestros proveedores</h2>
    <br><br>
    <div class="starter-template">
        <table class="table table-striped table-hover table-condensed table-bordered">
            <tr>
               <th>Id</th>
               <th>Nombre</th>
               <th>Direccion</th>
               <th>Telefono</th>
           </tr>
           <c:forEach var="proveedor" items="${proveedor}">
           <tr>
              <td>${proveedor.id}</td>
              <td>${proveedor.nombre}</td>
              <td>${proveedor.direccion}</td>
              <td>${proveedor.telefono}</td>
          </tr>
      </c:forEach>
  </table>
</div>

<!-- -- >
    <h2>Empleando la rest Api</h2>
    <div class="starter-template">
        <table id="proveedorTable" class="display">
         <thead>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Direccion</th>
                <th>Telefono</th>
            </tr>
        </thead>
        <tfoot>
            <tr>
                <th>id</th>
                <th>nombre</th>
                <th>direccion</th>
                <th>telefono</th>
            </tr>
        </tfoot>
    </table>
</div>
-->

</div>
<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
<script src="${contextPath}/resources/js/datatable.js"></script>
</body>

</html>