/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo3.Reto3;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Admon
 * Se hereda de los metodos CRUD
 */
public interface InterfaceBike extends CrudRepository<Motorbikes, Integer> {
    
}
