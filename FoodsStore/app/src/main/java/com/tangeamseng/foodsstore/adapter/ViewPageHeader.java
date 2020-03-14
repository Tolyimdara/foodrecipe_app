package com.tangeamseng.foodsstore.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.tangeamseng.foodsstore.R;
import com.tangeamseng.foodsstore.holder.VIewPageHeaderHolder;
import com.tangeamseng.foodsstore.model.headmodel;

import java.util.List;

public class ViewPageHeader extends RecyclerView.Adapter<VIewPageHeaderHolder> {
    List<headmodel> headmodels;
    ViewPager viewPager;

    public ViewPageHeader(List<headmodel> headmodels, ViewPager viewPager) {
        this.headmodels = headmodels;
        this.viewPager = viewPager;
    }

    @NonNull
    @Override
    public VIewPageHeaderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_pager_header_shimmer,null);
        return new VIewPageHeaderHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VIewPageHeaderHolder holder, int position) {
    holder.headtext.setText(headmodels.get(position).getHeadtittle());
    holder.headimage.setImageResource(headmodels.get(position).getHeadimage());

    }

    @Override
    public int getItemCount() {
        return headmodels.size();
    }
}
