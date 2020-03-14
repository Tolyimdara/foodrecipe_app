package com.tangeamseng.foodsstore.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.squareup.picasso.Picasso;
import com.tangeamseng.foodsstore.R;
import com.tangeamseng.foodsstore.holder.CategoriesHolder;
import com.tangeamseng.foodsstore.model.CategoriesModel;
import java.util.ArrayList;
public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesHolder> {
    Context context;
    ArrayList<CategoriesModel> listmodel;
    public CategoriesAdapter(Context context, ArrayList<CategoriesModel> listmodel) {
        this.context = context;
        this.listmodel = listmodel;
    }
    @NonNull
    @Override
    public CategoriesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_category_shimmer,null);
        return new CategoriesHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull CategoriesHolder holder, int position) {
    holder.textView.setText(listmodel.get(position).getCatName());
    Picasso.get().load(listmodel.get(position).getThumb()).into(holder.imageView);

    }
    @Override
    public int getItemCount() {
       return listmodel.size();
    }
}
