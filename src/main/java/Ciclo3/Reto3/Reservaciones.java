/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo3.Reto3;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Admon
 */
@Entity
@Table(name = "reservations")
public class Reservaciones implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY   )
    private Integer idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status="created";
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id")
    @JsonIgnoreProperties("reservations")
    private Motorbikes motorbike;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idclient")
    @JsonIgnoreProperties({"reservations", "messages"})
    private Cliente client;
    
    private String score;   

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Motorbikes getBike() {
        return motorbike;
    }

    public void setBike(Motorbikes bike) {
        this.motorbike = motorbike;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
    
       
}
