package com.example.mcsuas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterNotif extends RecyclerView.Adapter<AdapterNotif.ViewHolder> {
    private ArrayList<ObjectNotif> notifArrayList;
    private Context context;

    public AdapterNotif(ArrayList<ObjectNotif> notifArrayList, Context context) {
        this.notifArrayList = notifArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterNotif.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_notif,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterNotif.ViewHolder holder, int position) {
        ObjectNotif object = notifArrayList.get(position);
        holder.titleTV.setText(object.getTitle());
        holder.bodyTV.setText(object.getBody());

    }

    @Override
    public int getItemCount() {
        return notifArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTV, bodyTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.notif_title);
            bodyTV = itemView.findViewById(R.id.notif_desc);
        }
    }
}
