package com.example.dimag.upstyleru.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.dimag.upstyleru.R;
import com.example.dimag.upstyleru.fragments.AllGamesFragment;
import com.example.dimag.upstyleru.fragments.GamesFragment;
import com.example.dimag.upstyleru.fragments.SettingsFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public TextView name,email;
    public Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Все игры");

        switchFragment(R.id.nav_allgames);
//        toolbar.setTitle("Все игры");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View headerView = navigationView.getHeaderView(0);
        name=(TextView) headerView.findViewById(R.id.nameandsurname);
        email=(TextView) headerView.findViewById(R.id.usermailx);
        SharedPreferences settings = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        String email1 = settings.getString("email","@mail.ru");
        String name1 = settings.getString("name","Ivan");
        String surname1 = settings.getString("surname","Ivanov");
        name.setText(name1+" "+surname1);
        email.setText(email1);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switchFragment(id);
        return true;
    }

    public void switchFragment(int id) {
        final android.support.v4.app.FragmentTransaction transaction
                = getSupportFragmentManager().beginTransaction();
        switch (id) {
            // Handle the camera action
            case (R.id.nav_games):
                transaction.replace(R.id.container, new GamesFragment());
                getSupportActionBar().setTitle("Мои игры");
//                toolbar.setTitle("Мои игры");
                break;
            case (R.id.nav_allgames):
                transaction.replace(R.id.container, new AllGamesFragment());
                getSupportActionBar().setTitle("Все игры");
//                toolbar.setTitle("Все игры");
                break;
            case (R.id.nav_settings):
                transaction.replace(R.id.container, new SettingsFragment());
                getSupportActionBar().setTitle("Настройки");
//                toolbar.setTitle("Настройки");
        }

                transaction.commit();
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
        }
    }
