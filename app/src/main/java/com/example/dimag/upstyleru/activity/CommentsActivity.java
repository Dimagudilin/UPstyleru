package com.example.dimag.upstyleru.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dimag.upstyleru.R;
import com.example.dimag.upstyleru.api.ApiInter;
import com.example.dimag.upstyleru.dto.Add_comments;
import com.example.dimag.upstyleru.dto.Commentlist;
import com.example.dimag.upstyleru.dto.comments;
import com.example.dimag.upstyleru.recyclerview.Recyclercommends;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dimag on 06.08.2017.
 */

public class CommentsActivity extends AppCompatActivity {
    Toolbar toolbar;
    EditText edit;
    Button addcom;
    RecyclerView recyclerView;
    List<Commentlist> Commendlist;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        final Retrofit client = new Retrofit.Builder()
                .baseUrl("https://makub.ru/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        edit = (EditText) findViewById(R.id.commentadd);
        addcom = (Button) findViewById(R.id.sendcom);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        SharedPreferences settings = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        final String token = settings.getString("token", "0");
        final String id_game = settings.getString("id_game", "0");
       // String vs = settings.getString("player1tool1","")+" vs "+settings.getString("","");
        String vs = settings.getString("player1tool1","")+" vs "+settings.getString("player1tool2","");

        getSupportActionBar().setTitle(vs);

        Commendlist = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recycle_commends);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        Recyclercommends adapter = new Recyclercommends(getApplicationContext(), (ArrayList<Commentlist>) Commendlist);
        recyclerView.setAdapter(adapter);



        if (token != "0") {
            ApiInter service = client.create(ApiInter.class);
            Log.d("num", "Хотя бы работает");
            Call<comments> call = service.getCommends(token, id_game);
            call.enqueue(new Callback<comments>() {
                @Override
                public void onResponse(Call<comments> call, Response<comments> response) {
                    if (response.isSuccessful()) {
                        if (response.body().getError().toString().equals("0")) {
                            Commendlist.addAll(response.body().getComments());

                            recyclerView.getAdapter().notifyDataSetChanged();
                        } else if (response.body().getError().toString().equals("3")) {
                            Toast.makeText(getApplication(), "В данной игре пока что нет комментариев", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplication(), "А ваша игра точно существует?", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<comments> call, Throwable t) {
                    Log.d("num", "12.2");
                }
            });
        } else {
            Intent intent = new Intent(getApplication(), LoginActivity.class);
            startActivity(intent);
            finish();
        }


        addcom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("comments","1");
                String num = edit.getText().toString();
                if (num != "") {
                    Log.d("comments",num);
                    if (token != "0")
                    {
                        Log.d("comments","2");
                        ApiInter service2 = client.create(ApiInter.class);
                        Log.d("comments",id_game);
                        Call<Add_comments> call2 = service2.addCommends(token, id_game, num);
                        Log.d("comments","3");
                        call2.enqueue(new Callback<Add_comments>() {
                            @Override
                            public void onResponse(Call<Add_comments> call, Response<Add_comments> response) {
                                Log.d("comments",response.toString());
                                if (response.isSuccessful()) {
                                    Log.d("comments","4");
                                    if (response.body().getError().toString().equals("0")) {
                                        Log.d("comments","5");
                                        Intent intent = new Intent(getApplication(), CommentsActivity.class);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        Toast.makeText(getApplication(), "Произошла ошибка", Toast.LENGTH_SHORT).show();
                                    }

                                }
                                else{ Log.d("comments", "error1");}
                            }

                            @Override
                            public void onFailure(Call<Add_comments> call, Throwable t) {
                                Log.d("comments", "error2");
                            }
                        });
                    } else

                    {
                        Intent intent = new Intent(getApplication(), LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                } else { Toast.makeText(getApplication(), "Напишите комментарий", Toast.LENGTH_SHORT).show();}
            }

        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
