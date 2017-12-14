package com.example.edu.a0817moacn01c_3.Model;

/**
 * Created by ma on 13/12/17.
 */

public class Trailer {
    private Integer tmdbVideoID;
    private String name;
    private String id;
    private String key;


    public Trailer(){
    }

    public Trailer(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public Trailer(Integer tmdbVideoID, String name, String id, String key) {
        this.tmdbVideoID = tmdbVideoID;
        this.name = name;
        this.id = id;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public Integer getTmdbVideoID() {
        return tmdbVideoID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setTmdbVideoID(Integer tmdbVideoID) {
        this.tmdbVideoID = tmdbVideoID;
    }
}
