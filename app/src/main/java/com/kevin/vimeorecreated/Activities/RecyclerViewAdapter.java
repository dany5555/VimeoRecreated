package com.kevin.vimeorecreated.Activities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kevin.vimeorecreated.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> categoriesArrayList = new ArrayList<>();
    private ArrayList<String> backgroundImagesArrayList = new ArrayList<>();
    private ArrayList<Integer> foregroundImageArrayList = new ArrayList<>();

    private Context context;

    public RecyclerViewAdapter(ArrayList<String> categoriesArrayList, ArrayList<String> backgroundImagesArrayList, ArrayList<Integer> foregroundImageArrayList, Context context) {
        this.categoriesArrayList = categoriesArrayList;
        this.backgroundImagesArrayList = backgroundImagesArrayList;
        this.foregroundImageArrayList = foregroundImageArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.categories_list_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.categoryName.setText(categoriesArrayList.get(i));
        Glide.with(context).load(backgroundImagesArrayList.get(i)).into(viewHolder.backgroundImgaeView);
        viewHolder.foregroundImageView.setImageResource(foregroundImageArrayList.get(i));

    }

    @Override
    public int getItemCount() {
        return categoriesArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView backgroundImgaeView;
        ImageView foregroundImageView;
        TextView categoryName;

        public ViewHolder(View itemView) {
            super(itemView);
            backgroundImgaeView = itemView.findViewById(R.id.background_image);
            foregroundImageView = itemView.findViewById(R.id.foreground_icon);
            categoryName = itemView.findViewById(R.id.category_name);
        }
    }
}
