<%-- Document : detail Created on : 18 dic 2023, 14:45:26 Author : santi --%> <%@page contentType="text/html"
pageEncoding="UTF-8"%> <%@page import="com.demo.diciembre17.model.Orador"%>
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
    <% Orador orador = (Orador) request.getAttribute("orador"); %>

    <main class="pt-5">
      <section class="mt-5" id="SerOrador">
        <div class="text-center">
          <small class="text-uppercase">editar</small>
          <h2 class="text-uppercase">orador</h2>
        </div>
        <form
          class="row g-3 w-100 mx-auto"
          style="max-width: 48rem"
          action="<%= request.getContextPath() %>/Editar"
          method="POST"
        >
          <div class="col-md-6">
            <input
              type="text"
              class="form-control"
              name="nombre"
              id="nombre"
              placeholder="Nombre"
              value="<%= orador.getNombre() %>"
              required
            />
          </div>
          <div class="col-md-6">
            <input
              type="text"
              class="form-control"
              name="apellido"
              id="apellido"
              placeholder="Apellido"
              value="<%= orador.getApellido() %>"
              required
            />
          </div>
          <div class="col-12">
            <textarea
              name="tema"
              id="tema"
              class="form-control"
              rows="3"
              placeholder="De qué quieres hablar?"
              aria-describedby="charla"
              required
            >
<%= orador.getTema() %></textarea
            >
            <div id="charla" class="form-text">Recuerda indicar un título para tu charla</div>
          </div>
          <div class="col-12 d-flex">
            <a href="<%= request.getContextPath() %>/" class="btn btn-danger w-50">Cancelar</a>
            <button type="submit" class="btn btn-primary w-50">Editar</button>
          </div>
          <input type="hidden" name="id" value="<%= orador.getId() %>" />
        </form>
      </section>
    </main>
    <script src="./js/bootstrap.min.js"></script>
    <script src="./js/index.js"></script>
  </body>
</html>
