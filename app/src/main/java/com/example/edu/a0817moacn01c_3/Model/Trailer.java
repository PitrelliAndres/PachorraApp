package com.example.edu.a0817moacn01c_3.Model;

/**
 * Created by ma on 13/12/17.
 */

public class Trailer {
    private String name;
    private String id;

    public Trailer(){

    }
    public Trailer(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }
}
