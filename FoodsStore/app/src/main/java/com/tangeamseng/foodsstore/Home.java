package com.tangeamseng.foodsstore;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import com.tangeamseng.foodsstore.adapter.CategoriesAdapter;
import com.tangeamseng.foodsstore.adapter.ViewPageHeader;
import com.tangeamseng.foodsstore.model.CategoriesModel;
import com.tangeamseng.foodsstore.model.headmodel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Home extends Fragment{
    ViewPageHeader adaapter;
    ViewPager viewPager;
    RecyclerView recyclerView;
    ArrayList<CategoriesModel> arrayList;
    View v;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.home,container,false);
        recyclerView=v.findViewById(R.id.recyclerview);
        CategoriesAdapter adapter = new CategoriesAdapter(v.getContext(),arrayList);
        recyclerView.setLayoutManager(new GridLayoutManager(v.getContext(),3));
        recyclerView.setAdapter(adapter);
        List<headmodel> headmodels = new ArrayList<>();
        headmodels.add(new headmodel(R.drawable.steak,"Steak"));
        headmodels.add(new headmodel(R.drawable.ice,"ICE CREAM"));
        headmodels.add(new headmodel(R.drawable.icecream,"ICE CREAM"));
        adaapter= new ViewPageHeader(headmodels,viewPager);

        return v;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        arrayList = new ArrayList<>();
    }
    private RequestQueue mRequestQueue;
    @Override
    public void onResume() {
        super.onResume();
        mRequestQueue = Volley.newRequestQueue(getContext());
        jsonRequest("http://172.23.2.21:8000/api/categories/read");
}

    public void jsonRequest(String url) {
        final JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,url,null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject object = response.getJSONObject(i);
                        String name = object.getString("CategoriesName");
                        String thumb = object.getString("CategoriesThumb");
                        CategoriesModel categoriesModel = new CategoriesModel();
                        categoriesModel.setCatName(name);
                        categoriesModel.setThumb(thumb);
                        arrayList.add(categoriesModel);
                    }
                    CategoriesAdapter adapter = new CategoriesAdapter(v.getContext(),arrayList);
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        mRequestQueue.add(request);
        mRequestQueue = Volley.newRequestQueue(v.getContext());
    }
    @Override
    public void onPause() {
        super.onPause();
    }
}
