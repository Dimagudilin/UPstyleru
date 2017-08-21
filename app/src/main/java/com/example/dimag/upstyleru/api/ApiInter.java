package com.example.dimag.upstyleru.api;

import com.example.dimag.upstyleru.dto.Add_comments;
import com.example.dimag.upstyleru.dto.AllGame_my_first;
import com.example.dimag.upstyleru.dto.Allgame_firstreq;
import com.example.dimag.upstyleru.dto.Token;
import com.example.dimag.upstyleru.dto.User;
import com.example.dimag.upstyleru.dto.comments;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by dimag on 04.08.2017.
 */

public interface ApiInter {


    @FormUrlEncoded
    @POST("all_games")
    Call<Allgame_firstreq> getAllGames(@Field("token") String token, @Field("to") String to, @Field("from") String from);
    @FormUrlEncoded
    @POST("my_games")
    Call<AllGame_my_first> getMyGames(@Field("token") String token, @Field("to") String to, @Field("from") String from);
    @FormUrlEncoded
    @POST("login")
    Call<Token> getUser(@Field("login") String login, @Field("pass") String pass);
    @FormUrlEncoded
    @POST("checktoken")
    Call<User> getUserInfo(@Field("token") String token);

    @FormUrlEncoded
    @POST("get_comments")
    Call<comments> getCommends(@Field("token") String token, @Field("game_id") String game_id);
    @FormUrlEncoded
    @POST("add_comment")
    Call<Add_comments> addCommends(@Field("token") String token, @Field("game_id") String game_id,@Field("comment") String comment);

}

