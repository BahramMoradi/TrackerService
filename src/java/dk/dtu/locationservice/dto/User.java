/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.dtu.locationservice.dto;

import com.google.gson.Gson;
import java.io.Serializable;

/**
 *
 * @author Bahram Moradi
 */

public class User implements Serializable{
private long uid;
    private long phone;
    private String name;
    private String mail;
    private String description;
    public User(){}
    public User(long uid,long phone,String name,String mail,String description){
        this.uid=uid;
        this.phone=phone;
        this.name=name;
        this.mail=mail;
        this.description=description;
    }
    public User(long phone,String name ,String mail,String description){
        this.phone=phone;
        this.name=name;
        this.mail=mail;
        this.description=description;
    }
    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
       public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    public String toString(){
        Gson gson=new Gson();
       return gson.toJson(this, User.class);
    }
    
    
}
