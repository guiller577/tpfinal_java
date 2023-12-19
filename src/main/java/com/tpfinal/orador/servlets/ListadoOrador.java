
package com.tpfinal.orador.servlets;

import java.io.IOException;
import java.util.List;

import com.tpfinal.orador.DAO.OradorDAO;
import com.tpfinal.orador.model.Orador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ListadoOrador", urlPatterns = { "" })
public class ListadoOrador extends HttpServlet {
    private OradorDAO oradorDAO = new OradorDAO();

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    // + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Orador> oradores = oradorDAO.obtenerOradores();

        request.setAttribute("oradores", oradores);
        request.setAttribute("titulo", "Dashboard");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);

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

        Orador orador = new Orador();
        orador.setNombre(request.getParameter("nombre"));
        orador.setApellido(request.getParameter("apellido"));
        orador.setTema(request.getParameter("tema"));

        oradorDAO.insertarOrador(orador);

        List<Orador> oradores = oradorDAO.obtenerOradores();

        request.setAttribute("oradores", oradores);

        request.getRequestDispatcher("/index.jsp")
                .forward(request, response);
    }

}
