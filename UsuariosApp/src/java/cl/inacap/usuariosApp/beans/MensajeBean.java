/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.usuariosApp.beans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author sarayar
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/Queue")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class MensajeBean implements MessageListener {
    
    public MensajeBean() {
    }
    
    @Override
    public void onMessage(Message message) {
        MapMessage msg = (MapMessage) message;
        System.out.println("-------------- Mensaje ----------");
        try {
            System.out.println(msg.getString("msg"));
        } catch (JMSException ex) {
            System.out.println("Error " + ex);
        }
    }
    
}
