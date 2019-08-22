package com.developersk.firebasemlkitdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<MainListItem> list;
    private RecyclerView recyclerView;
    private MainAdapter adapter;
    private static ArrayList<Integer> images, title, description ;
    private String[] backgroundColors = {"#ffffff", "#ffffff", "#ffffff", "#ffffff", "#ffffff", "#ffffff", "#ffffff", "#ffffff", "#ffffff", "#ffffff"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        images = new ArrayList<>();
        addImages();
        title = new ArrayList<>();
        addTitle();
        description = new ArrayList<>();
        addDesc();

        Intent[] links = {
                new Intent(MainActivity.this, TextActivity.class),
                new Intent(MainActivity.this, ProfileActivity.class),
                new Intent(MainActivity.this, CustomActivity.class),
                new Intent(MainActivity.this, ImageActivity.class),
                new Intent(MainActivity.this, AutoMLActivity.class),
                new Intent(MainActivity.this, BarcodeActivity.class),
                new Intent(MainActivity.this, LandmarkActivity.class),
                new Intent(MainActivity.this, LanguageActivity.class),
                new Intent(MainActivity.this, TranslateActivity.class),
                new Intent(MainActivity.this, SmartReplyActivity.class)
        };

        list = new ArrayList<>();
        for (int i = 0; i < images.size(); i++) {
            MainListItem item = new MainListItem();

            item.setImageUrl(images.get(i));
            item.setHindiText(title.get(i));
            item.setEnglishText(description.get(i));
            item.setBackgroundColor(backgroundColors[i]);
            item.setIntent(links[i]);

            list.add(item);
        }

        adapter = new MainAdapter(this, list);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));

        recyclerView.setAdapter(adapter);

    }
    private static void addImages(){
        images.add(R.drawable.text_recognition);
        images.add(R.drawable.face_detection);
        images.add(R.drawable.object_detection);
        images.add(R.drawable.image_labeling);
        images.add(R.drawable.automl);
        images.add(R.drawable.barcode_scanning);
        images.add(R.drawable.landmark_recognition);
        images.add(R.drawable.language_detection);
        images.add(R.drawable.on_device_translate);
        images.add(R.drawable.smart_reply);
    }
    private static void addTitle(){
       title.add(R.string.text_recognition);
       title.add(R.string.face_detection);
       title.add(R.string.object_detection_tracking);
       title.add(R.string.image_labeling);
       title.add(R.string.automl);
       title.add(R.string.barcode_scanning);
       title.add(R.string.landmark_recognition);
       title.add(R.string.lang_id);
       title.add(R.string.on_device_translation);
       title.add(R.string.smart_reply);
    }
    private static void addDesc(){
        description.add(R.string.text_recognition_desc);
        description.add(R.string.face_detection_desc);
        description.add(R.string.object_detection_tracking_desc);
        description.add(R.string.image_labeling_desc);
        description.add(R.string.automl_desc);
        description.add(R.string.barcode_scanning_desc);
        description.add(R.string.landmark_recognition_desc);
        description.add(R.string.lang_id_desc);
        description.add(R.string.on_device_translation_desc);
        description.add(R.string.smart_reply_desc);
    }

}
