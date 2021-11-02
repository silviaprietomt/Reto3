/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo3.Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admon
 */
@Service
public class ServiciosMensaje {
    @Autowired
    private RepositorioMensaje metodosCrud;
    
    public List<Mensaje> getAll() {
        return metodosCrud.getAll();
    }
    
    public Optional<Mensaje> getMessage(int messageId) {
        return metodosCrud.getMessage(messageId);
    }
    
    public Mensaje save(Mensaje message) {
       if (message.getIdMessage()==null) {
           return metodosCrud.save(message);
       }else{
           Optional<Mensaje> e=metodosCrud.getMessage(message.getIdMessage());
           if (e.isEmpty()){
               return metodosCrud.save(message);
           }else{
               return message;
           }
       }
    }
    
    public Mensaje update(Mensaje message){
        if(message.getIdMessage() !=null) {
            Optional<Mensaje> e=metodosCrud.getMessage(message.getIdMessage());
            if (e.isEmpty()){
                if(message.getMessageText()!=null){
                    e.get().setMessageText(message.getMessageText());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return message;
            }
        }else{
            return message;            
        }        
    }

    boolean deleteMensaje(int messageId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
