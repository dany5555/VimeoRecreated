package com.kevin.vimeorecreated.Activities;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kevin.vimeorecreated.R;

import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {

    ArrayList<VideoModel> videoModelArrayList;
    Context context;

    public VideoAdapter(ArrayList<VideoModel> videoModelArrayList, Context context) {
        this.videoModelArrayList = videoModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.staff_picks_list_item, viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        VideoModel videoModel = videoModelArrayList.get(i);

        viewHolder.videoTitle.setText(videoModel.videoTitle);
        viewHolder.videoAuthor.setText(videoModel.videoAuthor);
        viewHolder.videoPlays.setText(videoModel.videoPlays);
        viewHolder.videoTimeUploaded.setText(videoModel.videoTimeUploaded);
        viewHolder.videoDuration.setText(videoModel.videoDuration);

        Glide.with(context).load(videoModel.videoThumbnailUrl).into(viewHolder.videoThumbnail);


    }

    @Override
    public int getItemCount() {
        return videoModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView videoThumbnail;
        TextView videoTitle;
        TextView videoAuthor;
        TextView videoPlays;
        TextView videoTimeUploaded;
        TextView videoDuration;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            videoThumbnail = itemView.findViewById(R.id.video_thumbnail);
            videoTitle = itemView.findViewById(R.id.title_textview);
            videoAuthor = itemView.findViewById(R.id.author_textview);
            videoPlays = itemView.findViewById(R.id.plays_textview);
            videoTimeUploaded = itemView.findViewById(R.id.uploaded_textview);
            videoDuration = itemView.findViewById(R.id.duration_textview);
        }
    }


}
