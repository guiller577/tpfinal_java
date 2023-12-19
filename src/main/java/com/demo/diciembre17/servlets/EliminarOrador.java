package com.demo.diciembre17.servlets;

import com.demo.diciembre17.DAO.OradorDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "EliminarOrador", urlPatterns = { "/Eliminar" })
public class EliminarOrador extends HttpServlet {
    private OradorDAO oradorDAO = new OradorDAO();

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
        oradorDAO.eliminarOrador(idOrador);

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
