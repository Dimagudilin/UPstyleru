package com.example.dimag.upstyleru.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dimag.upstyleru.R;
import com.example.dimag.upstyleru.dto.Commentlist;

import java.util.ArrayList;

/**
 * Created by dimag on 06.08.2017.
 */

public class Recyclercommends extends RecyclerView.Adapter<Recyclercommends.ViewHolder> {
    private ArrayList<Commentlist> android;
    public Context context;
    public Recyclercommends(Context context, ArrayList<Commentlist> android) {
        this.android = android;
        this.context = context;
    }




    @Override
    public Recyclercommends.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_comments, viewGroup, false);
        Log.d("num","20.2");
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final Recyclercommends.ViewHolder viewHolder, final int i) {

        viewHolder.author.setText(android.get(i).getSurname()+" "+android.get(i).getName());
        viewHolder.comment.setText(android.get(i).getComment());
    }

    @Override
    public int getItemCount() {
        return android.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView author,comment;
        public ViewHolder(View view) {
            super(view);
            Log.d("num","20.0");
            author = (TextView)view.findViewById(R.id.author);
            comment = (TextView)view.findViewById(R.id.comment);


        }
    }


}
