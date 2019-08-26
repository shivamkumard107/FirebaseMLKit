package com.developersk.firebasemlkitdemo;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
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
        View hView = navigationView.getHeaderView(0);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
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



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_documentation) {
            /*add intent to chrome*/
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://firebase.google.com/docs/ml-kit"));
            startActivity(intent);
        } else if (id == R.id.nav_contribute) {
            /*add intent to chrome*/
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://github.com/shivamkumard107/FirebaseMLKit"));
            startActivity(intent);
        }  else if (id == R.id.nav_about) {
            Intent about = new Intent(this, AboutusActivity.class);
            startActivity(about);
        } else if (id == R.id.nav_share) {
            /*sharing intent*/
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "http://play.google.com/store/apps/details?id=" + this.getPackageName() + "\n Here is the share content body";
            /*TODO add app link here*/
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));
        } else if (id == R.id.nav_rate) {
            /*add intent to playstore*/
            Uri uri = Uri.parse("market://details?id=" + this.getPackageName());
            Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
            // To count with Play market backstack, After pressing back button,
            // to taken back to our application, we need to add following flags to intent.
            goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                    Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                    Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
            try {
                startActivity(goToMarket);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://play.google.com/store/apps/details?id=" + this.getPackageName())));
            }
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
