package com.example.secondclass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Recadapter extends RecyclerView.Adapter<Recadapter.ViewHolder>{
    private ArrayList<Pokemon_> arraypro;
    private Context context;
    private View.OnClickListener itemListener;
    public Recadapter(ArrayList<Pokemon_> arraypro,Context context){
        this.arraypro=arraypro;
        this.context=context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view= LayoutInflater.from(parent.getContext()) .inflate(R.layout.recycleitem1,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Picasso.get().load(arraypro.get(position).getImage()).into(holder.pkimg);
        holder.pkname.setText(arraypro.get(position).getName());
    }

    @Override
    public int getItemCount() {

        return arraypro.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView pkimg;
        TextView pkname;
        public ViewHolder(View itemview){
           //adapter
            super(itemview);
            pkimg = itemview.findViewById(R.id.img_pk);
            pkname =itemview.findViewById(R.id.txt_pk);
            itemview.setTag(this);

        }


    }
}
