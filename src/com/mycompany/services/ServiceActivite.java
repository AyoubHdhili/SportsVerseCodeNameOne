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
import com.mycompany.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Achref
 */
public class ServiceActivite {
    
  
    
    public static ServiceActivite instance = null;
    
    public static boolean resultOk = true;
    
    private ConnectionRequest req;
    
    
    public ServiceActivite getInstance(){
        if (instance == null)
            instance = new ServiceActivite();
        return instance;
    }
    
    public ServiceActivite(){
        req = new ConnectionRequest();
    }
    
    public void ajoutActivite(Activite activite){
       
        String url = Statics.BASE_URL+"api/activite/add?nom="
                +activite.getNom()+"&description="
                +activite.getDescription()+"&type="
                +activite.getType();
        req.setUrl(url);
        req.addResponseListener((e)->{
            String str = new String(req.getResponseData());
            System.out.println("data == "+str);
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
    }
    
    public ArrayList<Activite>affichageActivites() {
        ArrayList<Activite> result = new ArrayList<>();
        
        String url = Statics.BASE_URL+"api/activite/list";

        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp ;
                jsonp = new JSONParser();
                
                try {
                    Map<String,Object>mapActivites = jsonp.parseJSON(new CharArrayReader(
                            new String(req.getResponseData()).toCharArray()));
                    
                    List<Map<String,Object>> listOfMaps =  (List<Map<String,Object>>) mapActivites.get("root");
                    
                    for(Map<String, Object> obj : listOfMaps) {
                        Activite re = new Activite();
                        
                        float id = Float.parseFloat(obj.get("id").toString());
                        String nom = obj.get("nom").toString();
                        String description = obj.get("description").toString();
                        String type = obj.get("type").toString();
                        
                        re.setId((int)id);
                        re.setNom(nom);
                        re.setDescription(description);
                        re.setType(type);

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
    
    public Activite DetailRecalamation( int id , Activite activite) {
        
        String url = Statics.BASE_URL+"api/activite/show?"+id;
        req.setUrl(url);
        
        String str  = new String(req.getResponseData());
        req.addResponseListener(((evt) -> {
        
            JSONParser jsonp = new JSONParser();
            try {
                
                Map<String,Object>obj = jsonp.parseJSON(new CharArrayReader(new String(str).toCharArray()));
                
                activite.setNom(obj.get("nom").toString());
                activite.setDescription(obj.get("description").toString());
                activite.setType(obj.get("type").toString());
            }catch(IOException ex) {
                System.out.println("error related to sql :( "+ex.getMessage());
            }
            
            System.out.println("data === "+str);
            
        }));
        
        NetworkManager.getInstance().addToQueueAndWait(req);

        return activite;
    }
    public boolean deleteActivite(int id ) {
        String url = Statics.BASE_URL +"/api/activite/delete?id="+id;
        
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
    
    public boolean modifierActivite(Activite activite) {
        String url = Statics.BASE_URL+"api/activite/update?id="
                +activite.getId()+"&nom="
                +activite.getNom()+"&description="
                +activite.getDescription()+"&type="
                +activite.getType();
        
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

