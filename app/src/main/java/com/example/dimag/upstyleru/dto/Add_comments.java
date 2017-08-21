package com.example.dimag.upstyleru.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dimag on 08.08.2017.
 */

public class Add_comments {
    @SerializedName("error")
    @Expose
    private Integer error;

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

}

