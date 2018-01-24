/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.demo01.controllers;

import cl.inacap.demo01.modelo.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sarayar
 */
@WebServlet(name = "servletDemo3", urlPatterns = {"/procesar2.do"})
public class ServletDemo3 extends HttpServlet {

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
        String sEdad = request.getParameter("edad");
        String errores ="";
        if(nombre.isEmpty()){
            errores = errores.concat("Falta nombre <br />");
        }
        int edad = 0;
        try{
            edad = Integer.parseInt(sEdad);
            if(edad< 18 || edad > 100){
                errores = errores.concat("Edad No permitida <br />");
            }
        }catch(Exception ex){
            errores = errores.concat("Edad inválida <br />");
        }
        
        if(errores.isEmpty()){
            Persona persona = new Persona(nombre,edad, "123");
            List<Persona> personas = (List<Persona>)this.getServletContext().getAttribute("data");
            personas.add(persona);
           // this.getServletContext().setAttribute("data", personas);
            request.setAttribute("msg", "Persona Ingresada");
        }else {
            request.setAttribute("msg", errores);
        }
        request.getRequestDispatcher("demo3.jsp").forward(request, response);
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
