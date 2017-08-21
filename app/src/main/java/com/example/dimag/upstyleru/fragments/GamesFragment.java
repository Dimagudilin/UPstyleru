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

import com.example.dimag.upstyleru.R;
import com.example.dimag.upstyleru.activity.LoginActivity;
import com.example.dimag.upstyleru.api.ApiInter;
import com.example.dimag.upstyleru.api.ApiService1;
import com.example.dimag.upstyleru.dto.AllGame_my_first;
import com.example.dimag.upstyleru.dto.AllGames_mine;
import com.example.dimag.upstyleru.recyclerview.Recyclermygames;

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

public class GamesFragment extends Fragment{
    RecyclerView recyclerView;
    List<AllGames_mine> allgames;
    ApiService1 api;
    public GamesFragment() {
    }

    public static GamesFragment newInstance() {
        GamesFragment fragment = new GamesFragment();
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


        Recyclermygames adapter = new Recyclermygames(getContext(), (ArrayList<AllGames_mine>) allgames);
        recyclerView.setAdapter(adapter);

        SharedPreferences settings = this.getActivity().getSharedPreferences("Settings", Context.MODE_PRIVATE);
        String token = settings.getString("token","0");
        if (token != "0") {
            ApiInter service = client.create(ApiInter.class);
            Log.d("num","Хотя бы работает");
            Call<AllGame_my_first> call = service.getMyGames(token, "20", "0");
            call.enqueue(new Callback<AllGame_my_first>() {
                @Override
                public void onResponse(Call<AllGame_my_first> call, Response<AllGame_my_first> response) {
                    if (response.isSuccessful()) {
                        Log.d("num", response.toString());
                        allgames.addAll(response.body().getGames());
                        Log.d("num", "resp");
                        recyclerView.getAdapter().notifyDataSetChanged();
                    }

                }
                @Override
                public void onFailure(Call<AllGame_my_first> call, Throwable t) {
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
