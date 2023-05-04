/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.entities.Activite;
import com.mycompany.entities.Cv;
import com.mycompany.utils.Statics;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Achref
 */
public class ServiceCv {
    
    public static ServiceCv instance = null;
    
    public static boolean resultOk = true;
    
    private ConnectionRequest req;
    
    
    public ServiceCv getInstance(){
        if (instance == null)
            instance = new ServiceCv();
        return instance;
    }
    
    public ServiceCv(){
        req = new ConnectionRequest();
    }
    
    public void ajoutCv(Cv cv){
       
        String url = Statics.BASE_URL+"api/cv/add?certification="
                +cv.getCertification()+"&description="
                +cv.getDescription()+"&tarif="
                +cv.getTarif()+"&duree_experience="
                +cv.getDuree_experience()+"&level="
                +cv.getLevel();
        req.setUrl(url);
        req.addResponseListener((e)->{
            String str = new String(req.getResponseData());
            System.out.println("data == "+str);
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
    }
    
    public ArrayList<Cv>affichageCvs() {
        ArrayList<Cv> result = new ArrayList<>();
        
        String url = Statics.BASE_URL+"api/cv/list";

        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp ;
                jsonp = new JSONParser();
                
                try {
                    Map<String,Object>mapCvs = jsonp.parseJSON(new CharArrayReader(
                            new String(req.getResponseData()).toCharArray()));
                    
                    List<Map<String,Object>> listOfMaps =  (List<Map<String,Object>>) mapCvs.get("root");
                    
                    for(Map<String, Object> obj : listOfMaps) {
                        Cv re = new Cv();
                        
                        float id = Float.parseFloat(obj.get("id").toString());
                        String certification = obj.get("certification").toString();
                        String description = obj.get("description").toString();
                        String duree_experience = obj.get("duree_experience").toString();
                        String level = obj.get("level").toString();
                        float tarif = Float.parseFloat(obj.get("tarif").toString());
                        
                        re.setId((int)id);
                        re.setCertification(certification);
                        re.setDescription(description);
                        re.setCertification(duree_experience);
                        re.setCertification(level);
                        re.setTarif((int)tarif);

                        //insert data into ArrayList result
                        result.add(re);
                        
                    }
                    
                }catch(Exception ex) {
                    
                    ex.printStackTrace();
                }
            }
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);

        return result;
    }
    
    public Cv DetailRecalamation( int id , Cv cv) {
        
        String url = Statics.BASE_URL+"api/cv/show?"+id;
        req.setUrl(url);
        
        String str  = new String(req.getResponseData());
        req.addResponseListener(((evt) -> {
        
            JSONParser jsonp = new JSONParser();
            try {
                
                Map<String,Object>obj = jsonp.parseJSON(new CharArrayReader(new String(str).toCharArray()));
                
                cv.setCertification(obj.get("certification").toString());
                cv.setDescription(obj.get("description").toString());
                cv.setCertification(obj.get("duree_experience").toString());
                cv.setCertification(obj.get("level").toString());
                cv.setTarif(Float.parseFloat(obj.get("tarif").toString()));
            }catch(IOException ex) {
                System.out.println("error related to sql :( "+ex.getMessage());
            }
            
            System.out.println("data === "+str);
            
        }));
        
        NetworkManager.getInstance().addToQueueAndWait(req);

        return cv;
    }
    public boolean deleteCv(int id ) {
        String url = Statics.BASE_URL +"/api/cv/delete?id="+id;
        
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                    
                    req.removeResponseCodeListener(this);
            }
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        return  resultOk;
    }
    
    public boolean modifierCv(Cv cv) {
        String url = Statics.BASE_URL+"api/cv/update?id="
                +cv.getId()+"&certification="
                +cv.getCertification()+"&description="
                +cv.getDescription()+"&tarif="
                +cv.getTarif()+"&duree_experience="
                +cv.getDuree_experience()+"&level="
                +cv.getLevel();
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOk = req.getResponseCode() == 200 ;
                req.removeResponseListener(this);
            }
        });
        
    NetworkManager.getInstance().addToQueueAndWait(req);
    return resultOk;
        
    }
    
    
}


















