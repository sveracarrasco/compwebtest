/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.demo01.controllers;

import cl.inacap.demo01.modelo.IUtilidad;
import cl.inacap.demo01.modelo.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sarayar
 */
@WebServlet(name = "servletDemo4", urlPatterns = {"/procesar4.do"})
public class ServletDemo4 extends HttpServlet {
    
    @Inject
    private IUtilidad utilidad;
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        request.getRequestDispatcher("demo4.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String nombre = request.getParameter("nombre");
        String pass = request.getParameter("clave");
        List<Persona> personas = (List<Persona>) this.getServletContext()
                .getAttribute("data");
        Persona persona = this.utilidad.loguear(nombre, pass, personas);
        
       if(persona == null){
           request.setAttribute("msg","Persona no Encontrada :'(");
           request.getRequestDispatcher("demo4.jsp").forward(request, response);
       } else {
           request.getSession().setAttribute("persona", persona);
           Cookie cookie = new Cookie("username", persona.getNombre());
           cookie.setMaxAge(60 * 5);
           response.addCookie(cookie);
           response.sendRedirect("panel.jsp");
       }
        
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
