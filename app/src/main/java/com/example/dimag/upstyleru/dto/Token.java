package com.example.dimag.upstyleru.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dimag on 04.08.2017.
 */

public class Token {
    @SerializedName("error")
    @Expose
    private Integer error;
    @SerializedName("token")
    @Expose
    private String token;

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}

