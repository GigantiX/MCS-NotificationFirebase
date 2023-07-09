package com.example.mcsuas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static com.example.mcsuas.MyFirebaseMessagingService.store;

import java.util.ArrayList;


public class FragmentNotification extends Fragment {
    private RecyclerView notifRV;
    private AdapterNotif adapterNotif;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        // Inflate the layout for this fragment
        notifRV = view.findViewById(R.id.notif_RV);
        adapterNotif = new AdapterNotif(store,getContext());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        notifRV.setHasFixedSize(true);
        notifRV.setLayoutManager(manager);
        notifRV.setAdapter(adapterNotif);
        return view;
    }
}