package com.example.dimag.upstyleru.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dimag.upstyleru.R;
import com.example.dimag.upstyleru.activity.CommentsActivity;
import com.example.dimag.upstyleru.dto.AllGames;

import java.util.ArrayList;

/**
 * Created by dimag on 04.08.2017.
 */

    public class Recyclerallgames extends RecyclerView.Adapter<Recyclerallgames.ViewHolder> {
        private ArrayList<AllGames> android;
    public Context context;
        public Recyclerallgames(Context context, ArrayList<AllGames> android) {
            this.android = android;
            this.context = context;
        }



//aqweqweqwe
    @Override
        public Recyclerallgames.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_games_all, viewGroup, false);
        Log.d("num","20.2");
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final Recyclerallgames.ViewHolder viewHolder, final int i) {

            viewHolder.fp.setText(android.get(i).getName1()+' '+android.get(i).getSurname1());
            viewHolder.sp.setText(android.get(i).getName2()+' '+android.get(i).getSurname2());
            viewHolder.sc.setText(android.get(i).getScore1()+':'+android.get(i).getScore2());
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPreferences settings = context.getSharedPreferences("Settings", Context.MODE_PRIVATE);
                    SharedPreferences.Editor ed= settings.edit();
                    String idgame = android.get(i).getId();
                    String player1tool1 = android.get(i).getName1();
                    String player1tool2 = android.get(i).getName2();
                    ed.putString("id_game", idgame);
                    ed.putString("player1tool1", player1tool1);
                    ed.putString("player1tool2", player1tool2);
                    ed.apply();
                    Intent intent = new Intent(context, CommentsActivity.class);
                    context.startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return android.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
            private TextView fp,sp,sc;
            public ViewHolder(View view) {
                super(view);
                Log.d("num","20.0");
                fp = (TextView)view.findViewById(R.id.fp);
                sp = (TextView)view.findViewById(R.id.sp);
                sc = (TextView)view.findViewById(R.id.sc);

            }
        }


    }
