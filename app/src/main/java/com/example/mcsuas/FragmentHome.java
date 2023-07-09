package com.example.mcsuas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import java.util.ArrayList;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FragmentHome extends Fragment {
    private RecyclerView homeRV;
    private AdapterHome adapter;
    private ArrayList<ObjectHome> homeArrayList;
    String url ="https://jsonplaceholder.typicode.com/posts";
    private ProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        progressBar = (ProgressBar) view.findViewById(R.id.home_loading);
        homeRV = view.findViewById(R.id.home_RV);
        homeArrayList = new ArrayList<>();
        buildRV();

        return view;
    }

    private void getData(){
        RequestQueue queue = Volley.newRequestQueue(requireActivity());

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url,null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                progressBar.setVisibility(View.GONE);
                homeRV.setVisibility(View.VISIBLE);
                try {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject jsonObject = response.getJSONObject(i);
                        String userId = jsonObject.getString("userId");
                        String id = jsonObject.getString("id");
                        String title = jsonObject.getString("title");
                        String desc = jsonObject.getString("body");
                        homeArrayList.add(new ObjectHome(userId, id, title, desc));
                        buildRV();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error.toString());
            }
        });
        queue.add(request);
    }
    private void buildRV(){
        adapter =new AdapterHome(homeArrayList, getActivity());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        homeRV.setHasFixedSize(true);
        homeRV.setLayoutManager(manager);
        homeRV.setAdapter(adapter);
    }
}