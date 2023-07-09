package com.example.mcsuas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterHome extends RecyclerView.Adapter<AdapterHome.ViewHolder> {

    private ArrayList<ObjectHome> homeArrayList;
    private Context context;

    public AdapterHome(ArrayList<ObjectHome> homeArrayList, Context context){
        this.homeArrayList = homeArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterHome.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_home, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHome.ViewHolder holder, int position) {
        ObjectHome object = homeArrayList.get(position);
        holder.useridTV.setText(object.getUserID());
        holder.idTV.setText(object.getId());
        holder.titleTV.setText(object.getTitle());
        holder.descTV.setText(object.getBody());

    }

    @Override
    public int getItemCount() {
        return homeArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView useridTV,idTV, titleTV, descTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            useridTV = itemView.findViewById(R.id.IHome_userID);
            idTV = itemView.findViewById(R.id.IHome_ID);
            titleTV = itemView.findViewById(R.id.IHome_title);
            descTV = itemView.findViewById(R.id.IHome_desc);
        }
    }
}
