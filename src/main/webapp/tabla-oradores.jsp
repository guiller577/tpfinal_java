<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Tabla de Oradores</title>
  </head>
  <body>
    <h1>Tabla de oradores</h1>
    <table>
      <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Apellido</th>
      </tr>
      <!-- imprimir los oradores -->
      <c:forEach var="orador" items="${requestScope.oradores}">
        <tr>
          <td>${orador.id}</td>
          <td>${orador.nombre}</td>
          <td>${orador.apellido}</td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
