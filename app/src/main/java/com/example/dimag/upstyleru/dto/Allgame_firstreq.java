package com.example.dimag.upstyleru.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dimag on 04.08.2017.
 */

public class Allgame_firstreq {
    @SerializedName("games")
    @Expose
    private List<AllGames> games = null;
    @SerializedName("error")
    @Expose
    private Integer error;

    public List<AllGames> getGames() {
        return games;
    }

    public void setGames(List<AllGames> games) {
        this.games = games;
    }

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

}
