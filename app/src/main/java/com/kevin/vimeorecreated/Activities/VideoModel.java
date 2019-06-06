package com.kevin.vimeorecreated.Activities;

import org.json.JSONException;
import org.json.JSONObject;

public class VideoModel {

    public String videoThumbnailUrl;
    public String videoTitle;
    public String videoAuthor;
    public String videoPlays;
    public String videoTimeUploaded;
    public String videoDuration;

    public VideoModel(JSONObject jsonObject) {
        if (jsonObject != null) {
            try {
                videoThumbnailUrl = jsonObject.getString("videoThumbnailUrl");
                videoTitle = jsonObject.getString("videoTitle");
                videoAuthor = jsonObject.getString("videoAuthor");
                videoPlays = jsonObject.getString("videoPlays");
                videoTimeUploaded = jsonObject.getString("videoTimeUploaded");
                videoDuration = jsonObject.getString("videoDuration");

            } catch (JSONException e) {

            }
        }
    }




}
