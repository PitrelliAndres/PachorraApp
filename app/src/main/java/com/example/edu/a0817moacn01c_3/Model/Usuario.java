package com.example.edu.a0817moacn01c_3.Model;

/**
 * Created by ma on 12/12/17.
 */

public class Usuario {
    private String mail;
    private String uID;
    private String name;

    public Usuario(String mail, String uID,String name) {
        this.mail = mail;
        this.uID = uID;
    }

    public String getMail() {
        return mail;
    }

    public String getuID() {
        return uID;
    }

    public String getName() {
        return name;
    }
}
