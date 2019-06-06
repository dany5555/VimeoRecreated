package com.kevin.vimeorecreated.Activities;

import android.support.annotation.NonNull;
import android.support.design.bottomnavigation.LabelVisibilityMode;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.kevin.vimeorecreated.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ExploreActivity extends AppCompatActivity {

    RecyclerView listView;
    BottomNavigationView bottomNavigationView;

    ArrayList<VideoModel> videoModelArrayList;

    private ArrayList<String> categoriesArrayList = new ArrayList<>();
    private ArrayList<String> backgroundImagesArrayList = new ArrayList<>();
    private ArrayList<Integer> foregroundImageArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Explore");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

        toolbar.inflateMenu(R.menu.notifications_action_menu);

        bottomNavigationView = findViewById(R.id.bottom_navigation_menu);
        bottomNavigationView.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);

        getContent();

        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);


        listView = findViewById(R.id.staff_picks_listview);
        listView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
        listView.addItemDecoration(itemDecoration);
        videoModelArrayList = new ArrayList<>();

        try {
            JSONObject obj = new JSONObject(loadJSON());
            JSONArray jsonArray = obj.getJSONArray("Videos");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject objc = jsonArray.getJSONObject(i);
                videoModelArrayList.add(new VideoModel(objc));
            }

            listView.setAdapter(new VideoAdapter(videoModelArrayList, this));
        } catch (JSONException e) {

        }





    }

    public String loadJSON() {
        String json = null;
        try {
            InputStream stream = getAssets().open("videos.json");
            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }



    private void getContent() {
        categoriesArrayList.add("Sports");
        backgroundImagesArrayList.add("https://dailypost.files.wordpress.com/2015/04/turnpike-blur.jpg");
        foregroundImageArrayList.add(R.drawable.sports_icon);

        categoriesArrayList.add("Animation");
        backgroundImagesArrayList.add("https://www.thediabetescouncil.com/wp-content/uploads/2018/02/amusement-park-fair-rides-fun.jpg");
        foregroundImageArrayList.add(R.drawable.animation_icon);

        categoriesArrayList.add("Comedy");
        backgroundImagesArrayList.add("https://o0o0sm3y25-flywheel.netdna-ssl.com/wp-content/uploads/2018/11/blurry-picture-iphone.jpg");
        foregroundImageArrayList.add(R.drawable.comedy_icon);

        categoriesArrayList.add("Documentary");
        backgroundImagesArrayList.add("https://i.pinimg.com/originals/39/b5/16/39b5165c510284ea96c6c61ff832e9f9.jpg");
        foregroundImageArrayList.add(R.drawable.documentary_icon);

        categoriesArrayList.add("Travel");
        backgroundImagesArrayList.add("https://st4.depositphotos.com/1445720/19919/v/600/depositphotos_199194638-stock-video-city-night-blurred-background-car.jpg");
        foregroundImageArrayList.add(R.drawable.travel_icon);

        categoriesArrayList.add("Narrative");
        backgroundImagesArrayList.add("https://ak0.picdn.net/shutterstock/videos/20526580/thumb/1.jpg");
        foregroundImageArrayList.add(R.drawable.narrative_icon);

        categoriesArrayList.add("Music");
        backgroundImagesArrayList.add("https://ak7.picdn.net/shutterstock/videos/14154107/thumb/1.jpg");
        foregroundImageArrayList.add(R.drawable.music_icon);

        categoriesArrayList.add("Fashion");
        backgroundImagesArrayList.add("https://ak9.picdn.net/shutterstock/videos/18098629/thumb/12.jpg");
        foregroundImageArrayList.add(R.drawable.fashion_icon);

        initRecyclerView();

    }

    private void initRecyclerView() {

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(categoriesArrayList, backgroundImagesArrayList, foregroundImageArrayList, this);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean b) {

            }
        });

    }






}
