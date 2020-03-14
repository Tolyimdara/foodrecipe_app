package com.tangeamseng.foodsstore.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tangeamseng.foodsstore.R;

public class CategoriesHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView textView;
    public CategoriesHolder(@NonNull View itemView) {
        super(itemView);
        this.imageView=itemView.findViewById(R.id.catgoriesimg);
        this.textView=itemView.findViewById(R.id.categoriestxt);
    }
}
