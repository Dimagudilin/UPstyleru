package com.example.dimag.upstyleru.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dimag on 08.08.2017.
 */

public class comments {
    @SerializedName("comments")
    @Expose
    private List<Commentlist> comments = null;
    @SerializedName("error")
    @Expose
    private Integer error;

    public List<Commentlist> getComments() {
        return comments;
    }

    public void setComments(List<Commentlist> comments) {
        this.comments = comments;
    }

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }
}
