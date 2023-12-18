/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.demo.diciembre17.servlets;

import java.io.IOException;
import java.util.List;

import com.demo.diciembre17.DAO.OradorDAO;
import com.demo.diciembre17.model.Orador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author santi
 */
@WebServlet(name = "MiServlet", urlPatterns = { "" })
public class MiServlet extends HttpServlet {
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

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

}
