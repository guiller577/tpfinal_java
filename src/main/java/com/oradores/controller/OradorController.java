package com.oradores.controller;

import com.oradores.model.Orador;
import com.oradores.service.OradorService;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "orador", urlPatterns = "/api/oradores")
public class OradorController extends HttpServlet {

    private OradorService oradorService = new OradorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // En vez de hacer esto hay que convertir la respuesta a json y enviarla al
        // front.
        // Despues reviso como se hace si les cuesta esto.
        try {

            List<Orador> oradores = oradorService.getOradores();
            resp.setContentType("text/html;charset=UTF-8");
            ServletOutputStream out = resp.getOutputStream();
            out.print("<html>" +
                    "<head><title>Pagina del servlet</title></head>" +
                    "<body>" +
                    "<h2>Titulo de la pagina</h2>" +
                    "<span>" + oradores.get(0).getNombre() + "</span>" +
                    "<span>" + oradores.get(0).getApellido() + "</span>" +
                    "<span>" + oradores.get(0).getTema() + "</span>" +
                    "</body>" +
                    "</html>");
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("tabla-oradores.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Agregar Logica para crear un orador
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Agregar logica para actualizar un orador
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Agregar logica para eliminar un orador
    }
}
