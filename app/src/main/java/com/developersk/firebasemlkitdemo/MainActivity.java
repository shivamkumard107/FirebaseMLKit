package com.developersk.firebasemlkitdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static ArrayList<Integer> images, title, description;
    private ArrayList<MainListItem> list;
    private RecyclerView recyclerView;
    private MainAdapter adapter;
    private String[] backgroundColors = {"#ffffff", "#ffffff", "#ffffff", "#ffffff", "#ffffff", "#ffffff", "#ffffff", "#ffffff", "#ffffff", "#ffffff"};
    private ImageView user_image;
    private ImageView nav_user_img;
    private TextView nav_user;
    private static void addImages() {
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

    private static void addTitle() {
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

    private static void addDesc() {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


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

        recyclerView = findViewById(R.id.recycler);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        recyclerView.setAdapter(adapter);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        View hView =  navigationView.getHeaderView(0);
         nav_user = hView.findViewById(R.id.username);
        nav_user_img = hView.findViewById(R.id.userimg);
        nav_user.setText("Anonymous");
        nav_user_img.setImageResource(R.drawable.ic_avatar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        user_image = findViewById(R.id.userimg);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_documentation) {
            /*add intent to chrome*/
        } else if (id == R.id.nav_contribute) {
            /*add intent to chrome*/
        } else if (id == R.id.nav_settings) {
            Intent setting = new Intent(this, SettingsActivity.class);
            startActivity(setting);
        } else if (id == R.id.nav_about) {
            Intent about = new Intent(this, AboutusActivity.class);
            startActivity(about);
        } else if (id == R.id.nav_share) {
            /*sharing intent*/
        } else if (id == R.id.nav_feedback) {
            Intent feedback = new Intent(this, FeedbackAtivity.class);
            startActivity(feedback);
        }else if(id == R.id.nav_rate){
            /*add intent to playstore*/
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
