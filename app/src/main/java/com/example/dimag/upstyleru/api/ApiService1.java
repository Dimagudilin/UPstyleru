package com.example.dimag.upstyleru.api;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dimag on 04.08.2017.
 */

public class ApiService1 extends Application {


        Retrofit client = new Retrofit.Builder()
                .baseUrl("https://makub.ru/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
