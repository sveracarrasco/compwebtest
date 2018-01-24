/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.usuariosApp.web;

import cl.inacap.usuariosApp.model.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author sarayar
 */
@WebListener
public class ContextListener implements ServletContextListener{

    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        List<Persona> personas = new ArrayList<>();
        for(int i=1; i <= 5; ++i){
            personas.add(new Persona("Nomb " + i, "1-"+i, "Admin", "per"+i
                    , "1"+i, true));
        }
        sce.getServletContext().setAttribute("personas", personas);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
     
    }
    
}
