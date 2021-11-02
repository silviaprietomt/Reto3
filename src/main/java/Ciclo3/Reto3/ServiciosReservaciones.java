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
public class ServiciosReservaciones {
    @Autowired
    private RepositorioReservaciones metodosCrud;
    
    public List<Reservaciones> getAll() {
        return metodosCrud.getAll();
    }
    
    public Optional<Reservaciones> getReservation(int reservationId) {
        return metodosCrud.getReservation(reservationId);
    }
    
    public Reservaciones save(Reservaciones reservation) {
       if (reservation.getIdReservation()==null) {
           return metodosCrud.save(reservation);
       }else{
           Optional<Reservaciones> e=metodosCrud.getReservation(reservation.getIdReservation());
           if (e.isEmpty()){
               return metodosCrud.save(reservation);
           }else{
               return reservation;
           }
       }
    }
    
    public Reservaciones update(Reservaciones reservation){
        if(reservation.getIdReservation() !=null) {
            Optional<Reservaciones> e=metodosCrud.getReservation(reservation.getIdReservation());
            if (e.isEmpty()){
                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;            
        }        
    }

    boolean deleteReservaciones(int reservationId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
