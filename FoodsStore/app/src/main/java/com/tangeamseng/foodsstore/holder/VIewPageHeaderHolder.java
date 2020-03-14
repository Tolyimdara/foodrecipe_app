package com.tangeamseng.foodsstore.holder;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tangeamseng.foodsstore.R;
public class VIewPageHeaderHolder extends RecyclerView.ViewHolder {
    public ImageView headimage;
    public TextView headtext;

    public VIewPageHeaderHolder(@NonNull View itemView) {
        super(itemView);
        headimage=itemView.findViewById(R.id.imagehead);
        headtext=itemView.findViewById(R.id.tittlehead);

    }
}
