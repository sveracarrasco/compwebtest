/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.usuariosApp.controllers;

import cl.inacap.usuariosApp.beans.PersonaBeanLocal;
import cl.inacap.usuariosApp.model.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sarayar
 */
@WebServlet(name = "usuariosAppController", urlPatterns = {"/controller.do"})
public class UsuariosAppController extends HttpServlet {

    @EJB
    private PersonaBeanLocal personaBean;

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
        response.setContentType("text/html;charset=UTF-8");

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

        String editar = request.getParameter("editar");

        if (editar != null) {
            mostrarEditarPersona(editar, request, response);
        } else {
            String accion = request.getParameter("accion");
            switch (accion) {
                case "loguear":
                    if (request.getSession().getAttribute("usuario") != null) {
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    } else {
                        loguear(request, response);
                    }
                    break;
                case "registrar":
                    registrar(request, response);
                    break;
                case "actualizar":
                    actualizar(request, response);
                    break;
            }

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

    private void loguear(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String rut = request.getParameter("rut").trim();
        String clave = request.getParameter("clave").trim();
        List<String> errores = new ArrayList<>();
        Persona persona = null;
        if (rut.isEmpty()) {
            errores.add("Debe Ingresar un Rut");
        }

        if (clave.isEmpty()) {
            errores.add("Debe Ingresar una clave");
        }

        if (errores.isEmpty()) {
            persona = this.personaBean.loguear(rut, clave);

            if (persona == null) {
                errores.add("Usuario incorrecto");
            }
        }

        if (errores.isEmpty()) {
            request.getSession().setAttribute("usuario", persona);
            response.sendRedirect("index.jsp");
        } else {
            request.setAttribute("errores", errores);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

    }

    private void registrar(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        List<String> errores = new ArrayList<>();
        String nombre = null;
        String clave = null;
        String claveRep = null;
        String correo = null;
        String rut = request.getParameter("rut").trim();

        if (this.personaBean
                .buscar(rut) != null) {
            errores.add("Usuario ya existente");
        } else {
            nombre = request.getParameter("nombre").trim();
            clave = request.getParameter("clave").trim();
            claveRep = request.getParameter("claveRep").trim();
            correo = request.getParameter("correo").trim();

            if (nombre.isEmpty()) {
                errores.add("Debe ingresar un nombre");
            }
            if (clave.isEmpty()) {
                errores.add("Debe Ingresar una Clave");
            }
            if (claveRep.isEmpty()) {
                errores.add("Debe confirmar clave");
            }

            if (!claveRep.isEmpty() && !clave.isEmpty()
                    && !claveRep.equals(clave)) {
                errores.add("Las claves no coinciden");
            }

            if (correo.isEmpty()) {
                errores.add("Debe ingresar un correo");
            }

        }

        if (errores.isEmpty()) {

            Persona persona = new Persona();
            persona.setNombre(nombre);
            persona.setActivo(true);
            persona.setClave(clave);
            persona.setPerfil("Admin");
            persona.setRut(rut);
            persona.setMail(correo);

            String msg = this.personaBean.agregarPersona(persona);
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("registro.jsp").forward(request,
                    response);
        } else {
            request.setAttribute("errores", errores);
            request.getRequestDispatcher("registro.jsp").forward(request,
                    response);
        }

    }

    private void mostrarEditarPersona(String rut, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Persona persona = this.personaBean.buscar(rut);
        request.setAttribute("persona", persona);
        request.getRequestDispatcher("editarPersona.jsp")
                .forward(request, response);

    }

    private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> errores = new ArrayList<>();

        String rut = request.getParameter("rut").trim();

        String nombre = request.getParameter("nombre").trim();
        String clave = request.getParameter("clave").trim();
        String claveRep = request.getParameter("claveRep").trim();
        String correo = request.getParameter("correo").trim();
        boolean activo = request.getParameter("activo") != null;
        String perfil = request.getParameter("perfil").trim();
        if (nombre.isEmpty()) {
            errores.add("Debe ingresar un nombre");
        }
        if (clave.isEmpty()) {
            errores.add("Debe Ingresar una Clave");
        }
        if (claveRep.isEmpty()) {
            errores.add("Debe confirmar clave");
        }

        if (!claveRep.isEmpty() && !clave.isEmpty()
                && !claveRep.equals(clave)) {
            errores.add("Las claves no coinciden");
        }

        if (correo.isEmpty()) {
            errores.add("Debe ingresar un correo");
        }

        if (errores.isEmpty()) {
            Persona persona = this.personaBean.buscar(rut);
            persona.setActivo(activo);
            persona.setClave(clave);
            persona.setNombre(nombre);
            persona.setPerfil(perfil);
            persona.setMail(correo);
            response.sendRedirect("personas.jsp");

        } else {
            request.setAttribute("errores", errores);
            request.getRequestDispatcher("editarPersona.jsp")
                    .forward(request, response);
        }
    }

}
