/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import java.util.Collection;

/**
 *
 * @author Achref
 */
public class Activite {
    private int id;
    private String nom,description,type;
    private Collection<Cv> cvs;

    public Activite() {
    }
    
    public Activite(int id, String nom, String description, String type, Collection<Cv> cvs) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.type = type;
        this.cvs = cvs;
    }

    public Activite(String nom, String description, String type, Collection<Cv> cvs) {
        this.nom = nom;
        this.description = description;
        this.type = type;
        this.cvs = cvs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Collection<Cv> getCvs() {
        return cvs;
    }

    public void setCvs(Collection<Cv> cvs) {
        this.cvs = cvs;
    }
    
    
}
