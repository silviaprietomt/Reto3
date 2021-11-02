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
    
    public List<Motorbikes> getAll() {
        return (List<Motorbikes>) crud.findAll();
    }
    
    public Optional<Motorbikes> getBike(int id) {
        return crud.findById(id);
    }
    
    public Motorbikes save(Motorbikes motorbike) {
        return crud.save(motorbike);
    }
    
    public void delete(Motorbikes motorbike) {
        crud.delete(motorbike);
    }
    
}
