package com.example.edu.a0817moacn01c_3.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrador on 14/12/2017.
 */

public class ContenedorDeTrailer {
    @SerializedName("results") private List<Trailer> trailers;
    @SerializedName("id") private Integer tmdbVideoID;

    public Trailer getTrailer() {
            Trailer elTrailer = null;
        if (trailers.size()>0) {
            elTrailer = trailers.get(0);
            elTrailer.setTmdbVideoID(tmdbVideoID);
        }
        return elTrailer;
    }
}
