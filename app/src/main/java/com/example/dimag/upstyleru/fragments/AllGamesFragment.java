package com.example.dimag.upstyleru.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dimag.upstyleru.activity.LoginActivity;
import com.example.dimag.upstyleru.api.ApiInter;
import com.example.dimag.upstyleru.api.ApiService1;
import com.example.dimag.upstyleru.dto.AllGames;
import com.example.dimag.upstyleru.R;
import com.example.dimag.upstyleru.dto.Allgame_firstreq;
import com.example.dimag.upstyleru.recyclerview.Recyclerallgames;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dimag on 03.08.2017.
 */

public class AllGamesFragment extends Fragment {
    RecyclerView recyclerView;
    List<AllGames> allgames;
    ApiService1 api;
    public AllGamesFragment() {
    }

    public static AllGamesFragment newInstance() {
        AllGamesFragment fragment = new AllGamesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_allgames, container, false);
        Retrofit client = new Retrofit.Builder()
                .baseUrl("https://makub.ru/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        allgames = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recycle_allgames);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        Recyclerallgames adapter = new Recyclerallgames(getContext(), (ArrayList<AllGames>) allgames);
        recyclerView.setAdapter(adapter);

        SharedPreferences settings = this.getActivity().getSharedPreferences("Settings", Context.MODE_PRIVATE);
       String token = settings.getString("token","0");
        Log.d("num", token+"Это ебучий токен");
        if (token != "0") {
            ApiInter service = client.create(ApiInter.class);
            Log.d("num","Хотя бы работает");
            Call<Allgame_firstreq> call = service.getAllGames(token, "20", "0");
            call.enqueue(new Callback<Allgame_firstreq>() {
                @Override
                public void onResponse(Call<Allgame_firstreq> call, Response<Allgame_firstreq> response) {
                    if (response.isSuccessful()) {
                        Log.d("num", response.toString());
                        allgames.addAll(response.body().getGames());
                        Log.d("num", "resp");
                        recyclerView.getAdapter().notifyDataSetChanged();
                    }

                }
                @Override
                public void onFailure(Call<Allgame_firstreq> call, Throwable t) {
                    Log.d("num", "12.2");
                }
            });
        }
        else {Intent intent = new Intent(this.getActivity().getApplication(), LoginActivity.class);
        startActivity(intent);
        getActivity().finish();}
        return view;
    }
}
