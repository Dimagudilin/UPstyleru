package com.example.dimag.upstyleru.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dimag on 06.08.2017.
 */

public class AllGame_my_first {
    @SerializedName("games")
    @Expose
    private List<AllGames_mine> games = null;
    @SerializedName("error")
    @Expose
    private Integer error;

    public List<AllGames_mine> getGames() {
        return games;
    }

    public void setGames(List<AllGames_mine> games) {
        this.games = games;
    }

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }
}
