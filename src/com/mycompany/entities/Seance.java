/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entities;

import java.util.Date;

/**
 *
 * @author user
 */
public class Seance {
    private int id;
    private Date date;
    private String etat;
    private String duree;
    private String addresse_client;
    private String Message;

    public Seance(Date date, String etat, String duree, String addresse_client, String Message) {
        this.date = date;
        this.etat = etat;
        this.duree = duree;
        this.addresse_client = addresse_client;
        this.Message = Message;
    }

    public Seance(int id, Date date, String etat, String duree, String addresse_client, String Message) {
        this.id = id;
        this.date = date;
        this.etat = etat;
        this.duree = duree;
        this.addresse_client = addresse_client;
        this.Message = Message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getAddresse_client() {
        return addresse_client;
    }

    public void setAddresse_client(String addresse_client) {
        this.addresse_client = addresse_client;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }
    
    
}
