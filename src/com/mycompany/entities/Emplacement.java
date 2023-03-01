/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entities;

/**
 *
 * @author user
 */
public class Emplacement {
    private int id;
    private String governorat;
    private String delegation;
    private String type;
    private String adresse;
    private String localite;

    public Emplacement(String governorat, String delegation, String type, String adresse, String localite) {
        this.governorat = governorat;
        this.delegation = delegation;
        this.type = type;
        this.adresse = adresse;
        this.localite = localite;
    }

    public Emplacement(int id, String governorat, String delegation, String type, String adresse, String localite) {
        this.id = id;
        this.governorat = governorat;
        this.delegation = delegation;
        this.type = type;
        this.adresse = adresse;
        this.localite = localite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGovernorat() {
        return governorat;
    }

    public void setGovernorat(String governorat) {
        this.governorat = governorat;
    }

    public String getDelegation() {
        return delegation;
    }

    public void setDelegation(String delegation) {
        this.delegation = delegation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getLocalite() {
        return localite;
    }

    public void setLocalite(String localite) {
        this.localite = localite;
    }
    
}
