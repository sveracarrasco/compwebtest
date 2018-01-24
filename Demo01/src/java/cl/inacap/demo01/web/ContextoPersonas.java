/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.demo01.web;

import cl.inacap.demo01.modelo.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author sarayar
 */
@WebListener()
public class ContextoPersonas implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        List<Persona> lista = new ArrayList<>();
        lista.add(new Persona("Juan", 23, "123"));
        lista.add(new Persona("Pedro", 24, "1234"));
        lista.add(new Persona("María", 27, "12345"));
        sce.getServletContext().setAttribute("data", lista);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    
    }
    
}
