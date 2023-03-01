/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entities;

/**
 *
 * @author user
 */
public class User {
    private int id;
    private String email;
    private String[] roles;
    private String password;
    private String nom;
    private String Prenom;
    private String adresse;
    private int num_tel;
    private boolean etat;
    private String type;

    public User(String email, String password, String nom, String Prenom, String adresse, int num_tel, boolean etat, String type) {
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.Prenom = Prenom;
        this.adresse = adresse;
        this.num_tel = num_tel;
        this.etat = etat;
        this.type = type;
    }

    public User(int id, String email, String password, String nom, String Prenom, String adresse, int num_tel, boolean etat, String type) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.Prenom = Prenom;
        this.adresse = adresse;
        this.num_tel = num_tel;
        this.etat = etat;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
