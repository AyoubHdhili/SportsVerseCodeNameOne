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
public class Cv {
    private int id,duree_experience;
    private String certification,description,level,image;
    private User user_id;
    private float tarif;
    private Collection<Activite> activities;

    public Cv() {
    }
    
    public Cv(int id, int duree_experience, String certification, String description, String level,
            String image, User user_id, float tarif, Collection<Activite> activities) {
        this.id = id;
        this.duree_experience = duree_experience;
        this.certification = certification;
        this.description = description;
        this.level = level;
        this.image = image;
        this.user_id = user_id;
        this.tarif = tarif;
        this.activities = activities;
    }

    public Cv(String description, String level, String image, int tarif) {
        
        this.description = description;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuree_experience() {
        return duree_experience;
    }

    public void setDuree_experience(int duree_experience) {
        this.duree_experience = duree_experience;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public float getTarif() {
        return tarif;
    }

    public void setTarif(float tarif) {
        this.tarif = tarif;
    }

    public Collection<Activite> getActivities() {
        return activities;
    }

    public void setActivities(Collection<Activite> activities) {
        this.activities = activities;
    }
    
    

       
}
