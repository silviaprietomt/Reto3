/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo3.Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Admon
 */
@Repository
public class RepositorioBike {
    
    @Autowired
    private InterfaceBike crud;
    
    public List<Motorbike> getAll() {
        return (List<Motorbike>) crud.findAll();
    }
    
    public Optional<Motorbike> getBike(int id) {
        return crud.findById(id);
    }
    
    public Motorbike save(Motorbike bike) {
        return crud.save(bike);
    }
    
    public void delete(Motorbike bike) {
        crud.delete(bike);
    }
    
}
