package com.richard.myapplication4;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import java.util.ArrayList;
import java.util.List;

public class LearningLeaders extends Fragment {
    private static final String URL_DATA = "https://gadsapi.herokuapp.com/api/hours";
    List<LearningItem> learningItems;

    private  RecyclerView.Adapter mAdapter;
    private RecyclerView mRecyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.learningleaders_layout, container, false);
        learningItems = new ArrayList<>();
        loadRecyclerViewData();
        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);



        return view;
    }

    private void loadRecyclerViewData() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,
                URL_DATA, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); ++i) {
                    try {
                        JSONObject LearningObject = response.getJSONObject(i);

                        LearningItem learningItem = new LearningItem();
                        learningItem.setName(LearningObject.getString("name").toString());
                        learningItem.setLearningHours(LearningObject.getString("hours").toString());
                        learningItem.setCountry(LearningObject.getString("country").toString());
                        learningItem.setImageResource(LearningObject.getString("badgeUrl"));

                        learningItems.add(learningItem);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                mAdapter = new LearningAdapter((ArrayList<LearningItem>) learningItems);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                mRecyclerView.setAdapter(mAdapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("tag", "onErrorResponse:" + error.getMessage());
            }
        });
        requestQueue.add(jsonArrayRequest);
    }
}
