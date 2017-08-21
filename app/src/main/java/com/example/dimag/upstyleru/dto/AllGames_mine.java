package com.example.dimag.upstyleru.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dimag on 06.08.2017.
 */

public class AllGames_mine {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("id_player")
    @Expose
    private String idPlayer;
    @SerializedName("surname")
    @Expose
    private String surname;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("our_score")
    @Expose
    private String ourScore;
    @SerializedName("his_score")
    @Expose
    private String hisScore;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(String idPlayer) {
        this.idPlayer = idPlayer;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOurScore() {
        return ourScore;
    }

    public void setOurScore(String ourScore) {
        this.ourScore = ourScore;
    }

    public String getHisScore() {
        return hisScore;
    }

    public void setHisScore(String hisScore) {
        this.hisScore = hisScore;
    }


        }
