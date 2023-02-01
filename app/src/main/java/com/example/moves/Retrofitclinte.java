package com.example.moves;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofitclinte {
    private static Retrofitclinte instance=null;
    private API api;
    private Retrofitclinte(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api=retrofit.create(API.class);

    }
    public static synchronized Retrofitclinte getInstance(){
        if(instance==null){
            instance=new Retrofitclinte();
        }
        return instance;


    }
    public API getApi(){
        return api;
    }
}
