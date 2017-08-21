package com.example.dimag.upstyleru.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dimag on 06.08.2017.
 */

public class User {
    @SerializedName("pl_id")
    @Expose
    private String plId;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("club_id")
    @Expose
    private String clubId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("surname")
    @Expose
    private String surname;
    @SerializedName("rating_of_player")
    @Expose
    private String ratingOfPlayer;
    @SerializedName("rating_of_judge")
    @Expose
    private String ratingOfJudge;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("login")
    @Expose
    private String login;
    @SerializedName("pass")
    @Expose
    private String pass;
    @SerializedName("club")
    @Expose
    private String club;
    @SerializedName("region")
    @Expose
    private String region;
    @SerializedName("error")
    @Expose
    private Integer error;

    public String getPlId() {
        return plId;
    }

    public void setPlId(String plId) {
        this.plId = plId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClubId() {
        return clubId;
    }

    public void setClubId(String clubId) {
        this.clubId = clubId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRatingOfPlayer() {
        return ratingOfPlayer;
    }

    public void setRatingOfPlayer(String ratingOfPlayer) {
        this.ratingOfPlayer = ratingOfPlayer;
    }

    public String getRatingOfJudge() {
        return ratingOfJudge;
    }

    public void setRatingOfJudge(String ratingOfJudge) {
        this.ratingOfJudge = ratingOfJudge;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }
}
