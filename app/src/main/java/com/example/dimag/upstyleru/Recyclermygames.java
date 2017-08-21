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
import com.example.dimag.upstyleru.dto.AllGames_mine;

import java.util.ArrayList;

/**
 * Created by dimag on 06.08.2017.
 */

    public class Recyclermygames extends RecyclerView.Adapter<Recyclermygames.ViewHolder> {
    public Context context;
    public ArrayList<AllGames_mine> android;

        public Recyclermygames(Context context, ArrayList<AllGames_mine> android) {
            this.android = android;
            this.context = context;

        }




        @Override
        public Recyclermygames.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_games_all, viewGroup, false);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });
            Log.d("num","20.2");
            return new Recyclermygames.ViewHolder(view);
        }


    public interface OnItemClickListener{
        void onItemClick(View itemView, int position, View view);

    }

        @Override
        public void onBindViewHolder(Recyclermygames.ViewHolder viewHolder, final int i) {

            SharedPreferences settings = context.getSharedPreferences("Settings", Context.MODE_PRIVATE);
            final String name = settings.getString("name","0");
            String surname = settings.getString("surname","0");
            viewHolder.sp.setText(android.get(i).getName()+" "+android.get(i).getSurname());
            viewHolder.fp.setText(name+" "+surname);
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPreferences settings = context.getSharedPreferences("Settings", Context.MODE_PRIVATE);
                    SharedPreferences.Editor ed= settings.edit();
                    String idgame = android.get(i).getId();
                    String player1tool2 = android.get(i).getName();
                    ed.putString("player1tool1", name);
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
                fp = (TextView)view.findViewById(R.id.fp);
                sp = (TextView)view.findViewById(R.id.sp);
                sc = (TextView)view.findViewById(R.id.sc);

            }
        }


    }
