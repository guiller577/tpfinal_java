<%-- 
    Document   : nueva
    Created on : 18 dic 2023, 00:10:54
    Author     : santi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<%@page import="com.demo.diciembre17.model.Orador"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>SV ~ Trabajo Integrador Front cambios</title>
    <link rel="stylesheet" href="./css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css" />
  </head>
  <body
    data-bs-spy="scroll"
    data-bs-target="#navbar"
    data-bs-root-margin="0px 0px -40%"
    data-bs-smooth-scroll="true"
    data-bs-theme="dark"
  >
    <nav id="navbar" class="navbar navbar-expand-xl fixed-top">
      <div class="container">
        <a class="navbar-brand me-0" href="#">
          <img src="./assets/codoacodo.png" alt="logo de codo a codo" width="120" />
          <span> Conf Bs As 2023 </span>
        </a>
        <div class="justify-content-end" id="navbarNav">
          <button onclick="cambiarTema()" class="btn rounded-fill"><i id="icon" class="bi bi-moon-fill"></i></button>
        </div>
      </div>
    </nav>
    <main class="pt-5">
      <section class="mt-5" id="SerOrador">
        <div class="text-center">
          <small class="text-uppercase">conviértete en</small>
          <h2 class="text-uppercase">orador</h2>
          <p>Anótate como orador para dar una <u>charla ignite.</u> Cuéntanos de qué quieres hablar!</p>
        </div>
        <form 
        
        action="<%= request.getContextPath() %>/" 
        method="POST" class="row g-3 w-100 mx-auto" style="max-width: 48rem">
          <div class="col-md-6">
            <input type="text" class="form-control" name="nombre" id="nombre" placeholder="Nombre" required/>
          </div>
          <div class="col-md-6">
            <input type="text" class="form-control" name="apellido" id="apellido" placeholder="Apellido" required/>
          </div>
          <div class="col-12">
            <textarea
              id="tema"
              name="tema"
              class="form-control"
              rows="3"
              placeholder="De qué quieres hablar?"
              aria-describedby="charla"
              required
            ></textarea>
            <div id="charla" class="form-text">Recuerda indicar un título para tu charla</div>
          </div>
          <div class="col-12">
            <button type="submit" class="btn btn-success w-100">Enviar</button>
          </div>
        </form>
      </section>
      <section class="mt-5">
        <table class="table table-hover mx-auto" style="max-width: 48rem">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">Nombre</th>
              <th scope="col">Apellido</th>
              <th scope="col">Tema</th>
              <th scope="col">Accion</th>
            </tr>
          </thead>
          <tbody>
            <% 
                List<Orador> oradores = (List<Orador>) request.getAttribute("oradores");
                for (Orador orador : oradores) {
            %>
            <tr>
              <th scope="row"><%= orador.getId() %></th>
              <td><%= orador.getNombre() %></td>
              <td><%= orador.getApellido() %></td>
              <td><%= orador.getTema() %></td>
              <td>
<!--                 
                <button class="btn btn-danger" onclick="eliminar(this)">
                  <i class="bi bi-trash"></i>
                </button> -->
                <form action="<%= request.getContextPath() %>/Eliminar" method="POST">
                  <input type="hidden" name="id" value="<%= orador.getId() %>">
                  <button class="btn btn-danger">
                    <i class="bi bi-trash"></i>
                  </button>
                </form>
              <!--   <a href="detail.html" class="btn btn-primary">
                  <i class="bi bi-pencil"></i>
                </a> -->
                <a href="<%= request.getContextPath() %>/Editar?id=<%= orador.getId() %>" class="btn btn-primary">
                  <i class="bi bi-pencil"></i>
                </a>
              </td>
            </tr>
            <% } %>
          </tbody>
        </table>
      </section>
    </main>
    <script src="./js/bootstrap.min.js"></script>
    <script src="./js/index.js"></script>
  </body>
</html>

