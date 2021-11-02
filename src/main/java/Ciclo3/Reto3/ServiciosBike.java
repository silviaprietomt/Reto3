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
public class ServiciosBike {
    
    @Autowired
    private RepositorioBike metodosCrud;
    
    public List<Motorbikes> getAll() {
        return metodosCrud.getAll();
    }
    
    public Optional<Motorbikes> getBike(int bikeId) {
        return metodosCrud.getBike(bikeId);
    }
    
    public Motorbikes save(Motorbikes motorbike) {
       if (motorbike.getId()==null) {
           return metodosCrud.save(motorbike);
       }else{
           Optional<Motorbikes> e=metodosCrud.getBike(motorbike.getId());
           if (e.isEmpty()){
               return metodosCrud.save(motorbike);
           }else{
               return motorbike;
           }
       }
    }
    
    public Motorbikes update(Motorbikes motorbike){
        if(motorbike.getId()!=null) {
            Optional<Motorbikes> e=metodosCrud.getBike(motorbike.getId());
            if (e.isEmpty()){
                if(motorbike.getName()!=null){
                    e.get().setName(motorbike.getName());
                }
                if(motorbike.getBrand()!=null){
                    e.get().setBrand(motorbike.getBrand());                    
                }
                if(motorbike.getYear()!=null){
                    e.get().setYear(motorbike.getYear());  
                }
                if(motorbike.getDescription()!=null){
                    e.get().setDescription(motorbike.getDescription());  
                }
                if(motorbike.getCategory()!=null){
                    e.get().setCategory(motorbike.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return motorbike;
            }
        }else{
            return motorbike;            
        }        
    }
        
   // public boolean deleteBike(int bikeId) {
   //*   Boolean aBoolean = getBike(bikeId).map(bike -> {
   //        metodosCrud.delete(bike);
   //        return true;
   //    )}.orElse(false);
   //    return aBoolean;    
   //*

    boolean deleteMotorbike(int bikeId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
 
    
