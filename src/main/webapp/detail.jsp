<%-- Document : detail Created on : 18 dic 2023, 14:45:26 Author : santi --%> <%@page contentType="text/html"
pageEncoding="UTF-8"%> <%@page import="com.tpfinal.orador.model.Orador"%>
<!DOCTYPE html>
<html lang="en">
  <jsp:include page="head.jsp" />
  <body
    data-bs-spy="scroll"
    data-bs-target="#navbar"
    data-bs-root-margin="0px 0px -40%"
    data-bs-smooth-scroll="true"
    data-bs-theme="dark"
  >
    <jsp:include page="navbar.jsp" />

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
