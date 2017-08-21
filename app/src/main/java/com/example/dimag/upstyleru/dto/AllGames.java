package com.example.dimag.upstyleru.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dimag on 04.08.2017.
 */

public class AllGames {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("player1")
    @Expose
    private String player1;
    @SerializedName("player2")
    @Expose
    private String player2;
    @SerializedName("rating1")
    @Expose
    private String rating1;
    @SerializedName("rating2")
    @Expose
    private String rating2;
    @SerializedName("score1")
    @Expose
    private String score1;
    @SerializedName("score2")
    @Expose
    private String score2;
    @SerializedName("stage")
    @Expose
    private String stage;
    @SerializedName("surname1")
    @Expose
    private String surname1;
    @SerializedName("name1")
    @Expose
    private String name1;
    @SerializedName("surname2")
    @Expose
    private String surname2;
    @SerializedName("name2")
    @Expose
    private String name2;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getRating1() {
        return rating1;
    }

    public void setRating1(String rating1) {
        this.rating1 = rating1;
    }

    public String getRating2() {
        return rating2;
    }

    public void setRating2(String rating2) {
        this.rating2 = rating2;
    }

    public String getScore1() {
        return score1;
    }

    public void setScore1(String score1) {
        this.score1 = score1;
    }

    public String getScore2() {
        return score2;
    }

    public void setScore2(String score2) {
        this.score2 = score2;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getSurname1() {
        return surname1;
    }

    public void setSurname1(String surname1) {
        this.surname1 = surname1;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getSurname2() {
        return surname2;
    }

    public void setSurname2(String surname2) {
        this.surname2 = surname2;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

}
