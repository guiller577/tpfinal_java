package com.demo.diciembre17.servlets;

import java.io.IOException;

import com.demo.diciembre17.DAO.OradorDAO;
import com.demo.diciembre17.model.Orador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "EditarOrador", urlPatterns = { "/Editar" })
public class EditarOrador extends HttpServlet {
    private OradorDAO oradorDAO = new OradorDAO();

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    // + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * href="<%= request.getContextPath() %>/Editar?id=<%= orador.getId() %>"
     * 
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);

        int id = Integer.parseInt(request.getParameter("id"));
        Orador orador = oradorDAO.obtenerOradorPorId(id);

        request.setAttribute("orador", orador);

        request.getRequestDispatcher("detail.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idOrador = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String tema = request.getParameter("tema");

        Orador orador = new Orador(idOrador, nombre, apellido, tema);
        oradorDAO.actualizarOrador(orador);

        response.sendRedirect(request.getContextPath() + "/");

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
