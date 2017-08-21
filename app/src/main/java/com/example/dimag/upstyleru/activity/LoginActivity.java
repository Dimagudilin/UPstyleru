package com.example.dimag.upstyleru.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dimag.upstyleru.api.ApiInter;
import com.example.dimag.upstyleru.api.ApiService1;
import com.example.dimag.upstyleru.R;
import com.example.dimag.upstyleru.dto.Token;
import com.example.dimag.upstyleru.dto.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dimag on 03.08.2017.
 */

public class LoginActivity extends AppCompatActivity {
    Button login;
    EditText log, pass;
    private static ApiInter Apis;
    ApiService1 api;
    Integer id;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button login = (Button) findViewById(R.id.loginbutton);
        final EditText log = (EditText) findViewById(R.id.log);
        final EditText pass = (EditText) findViewById(R.id.pass);

        SharedPreferences settings = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        String token = settings.getString("token","0");
        Log.d("num", token+"Это ебучий токен");

        final Retrofit client = new Retrofit.Builder()
                .baseUrl("https://makub.ru/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        Log.d("Start","1");
        if (token != "0"){
            ConnectivityManager cn = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nf = cn.getActiveNetworkInfo();
            if (nf != null && nf.isConnected()) {

                ApiInter service = client.create(ApiInter.class);
                Call<User> call = service.getUserInfo(token);
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.isSuccessful()) {
                            if (response.body().getError().toString().equals("0")) {
                                SharedPreferences settings = getSharedPreferences("Settings", Context.MODE_PRIVATE);
                                SharedPreferences.Editor ed= settings.edit();
                                ed.putString("name",response.body().getName().toString());
                                ed.putString("surname",response.body().getSurname().toString());
                                ed.putString("email",response.body().getEmail().toString());
                                ed.apply();

                                Intent intent = new Intent(getApplication(), MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                            else {
                                Toast.makeText(getApplication(), "Пожалуйста, введите правильные данные", Toast.LENGTH_SHORT).show();}}
                        else{
                            Toast.makeText(getApplication(), "Пожалуйста, введите правильные данные", Toast.LENGTH_SHORT).show();
                        }
                    }


                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(getApplication(), "Что-то пошло не так", Toast.LENGTH_SHORT).show();
                        Log.d("num","12.2");
                    }
                });
            }
            else {
                Toast.makeText(getApplication(), "Подключитесь к интернету, ну пожалуйста", Toast.LENGTH_LONG).show();;
            }
        }








        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String login = log.getText().toString();
                String password = pass.getText().toString();


                ConnectivityManager cn = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo nf = cn.getActiveNetworkInfo();
                if (nf != null && nf.isConnected()) {

                    ApiInter service = client.create(ApiInter.class);
                    Call<Token> call = service.getUser(login,password);
                    call.enqueue(new Callback<Token>() {
                        @Override
                        public void onResponse(Call<Token> call, Response<Token> response) {
                            if (response.isSuccessful()) {
                                if (response.body().getError().toString().equals("0")) {
                                    Toast.makeText(getApplication(), "Ура!", Toast.LENGTH_SHORT).show();
                                    String newtoken = response.body().getToken().toString();


                                    ApiInter service2 = client.create(ApiInter.class);
                                    Call<User> call2 = service2.getUserInfo(newtoken);
                                    call2.enqueue(new Callback<User>() {
                                        @Override
                                        public void onResponse(Call<User> call, Response<User> response) {
                                            if (response.isSuccessful()) {
                                                if (response.body().getError().toString().equals("0")) {
                                                    SharedPreferences settings = getSharedPreferences("Settings", Context.MODE_PRIVATE);
                                                    SharedPreferences.Editor ed= settings.edit();
                                                    ed.putString("name",response.body().getName().toString());
                                                    ed.putString("surname",response.body().getSurname().toString());
                                                    ed.putString("email",response.body().getEmail().toString());
                                                    ed.apply();

                                                    Intent intent = new Intent(getApplication(), MainActivity.class);
                                                    startActivity(intent);
                                                    finish();
                                                }
                                                else {
                                                    Toast.makeText(getApplication(), "Пожалуйста, введите правильные данные", Toast.LENGTH_SHORT).show();}}
                                            else{
                                                Toast.makeText(getApplication(), "Пожалуйста, введите правильные данные", Toast.LENGTH_SHORT).show();
                                            }
                                        }


                                        @Override
                                        public void onFailure(Call<User> call, Throwable t) {
                                            Toast.makeText(getApplication(), "Что-то пошло не так", Toast.LENGTH_SHORT).show();
                                            Log.d("num","12.2");
                                        }
                                    });


                                    SharedPreferences settings = getSharedPreferences("Settings", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor ed= settings.edit();
                                    ed.putString("token",newtoken);
                                    ed.apply();

//                                    Intent intent = new Intent(getApplication(), MainActivity.class);
//                                    startActivity(intent);
//                                    finish();
                                }
                                else {
                                        Toast.makeText(getApplication(), "Повторите попытку", Toast.LENGTH_SHORT).show();}}
                            else{
                                        Toast.makeText(getApplication(), "Пожалуйста, введите правильные данные", Toast.LENGTH_SHORT).show();
                                    }
                                }


                        @Override
                        public void onFailure(Call<Token> call, Throwable t) {
                            Toast.makeText(getApplication(), "Что-то пошло не так", Toast.LENGTH_SHORT).show();
                            Log.d("num","12.2");
                        }
                    });


                }
                else {
                    Toast.makeText(getApplication(), "Подключитесь к интернету, ну пожалуйста", Toast.LENGTH_LONG).show();;
                }
            }

        });
    }
}

