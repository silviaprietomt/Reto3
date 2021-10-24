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
public class ServiciosCliente {
    @Autowired
    private RepositorioCliente metodosCrud;
    
    public List<Cliente> getAll() {
        return metodosCrud.getAll();
    }
    
    public Optional<Cliente> getCliente(int clientId) {
        return metodosCrud.getCliente(clientId);
    }
    
    public Cliente save(Cliente client) {
       if (client.getIdCliente()==null) {
           return metodosCrud.save(client);
       }else{
           Optional<Cliente> e=metodosCrud.getCliente(client.getIdCliente());
           if (e.isEmpty()){
               return metodosCrud.save(client);
           }else{
               return client;
           }
       }
    }
    
    public Cliente update(Cliente client){
        if(client.getIdCliente()!=null) {
            Optional<Cliente> e=metodosCrud.getCliente(client.getIdCliente());
            if (e.isEmpty()){
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    e.get().setAge(client.getAge());                    
                }
                if(client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());  
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return client;  
            }
        }else{
            return client;            
        }        
    }
    
    //*public boolean deleteCliente(int clientId) {
    //    Boolean aBoolean = getClient(clientId).map(client -> {
    //        metodosCrud.delete(client);
    //        return true;
    //    )}.orElse(false);
    //    return aBoolean;
    //}
   
}
