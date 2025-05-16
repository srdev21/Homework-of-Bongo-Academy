package com.srdevhub.homework;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ShareCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    NavigationView navigationView;

    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    ImageView imageMenu;

    CardView hw1, hw2, hw3, hw4, hw5, hw6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        hw1 = findViewById(R.id.hw1);
        hw2 = findViewById(R.id.hw2);
        hw3 = findViewById(R.id.hw3);
        hw4 = findViewById(R.id.hw4);
        hw5 = findViewById(R.id.hw5);
        hw6 = findViewById(R.id.hw6);


        hw1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, HomeWork_1.class);
                startActivity(intent);
            }
        });


 hw2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, HomeWork_2.class);
                startActivity(intent);
            }
        });


 hw3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, HomeWork_3.class);
                startActivity(intent);
            }
        });




        hw4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, HomeWork_4.class);
                startActivity(intent);
            }
        });


        hw5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, HomeWork_5.class);
                startActivity(intent);
            }
        });














        //===============Drawer Layout Code=========================
        // Navagation Drawar------------------------------
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_View);
        imageMenu = findViewById(R.id.imageMenu);

        toggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Drawar click event
        // Drawer item Click event ------
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                int itemId = item.getItemId();

                if (itemId == R.id.mHome) {
                    Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawers();
                } else if (itemId == R.id.mRate) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.srsoftdev.footfeed")));


                    drawerLayout.closeDrawers();
                } else if (itemId == R.id.Policy) {
                    // startActivity(new Intent(MainActivity.this, privacy_policy.class));


                    drawerLayout.closeDrawers();
                } else if (itemId == R.id.shareapp) {
                    ShareCompat.IntentBuilder.from(MainActivity.this)
                            .setType("text/plain")
                            .setChooserTitle("Chooser title")
                            .setText("http://play.google.com/store/apps/details?id=com.srsoftdev.footfeed" + MainActivity.this.getPackageName())
                            .startChooser();
                    drawerLayout.closeDrawers();



                }
                return false;
            };
        });
        //------------------------------

        // ------------------------
        // App Bar Click Event
        imageMenu = findViewById(R.id.imageMenu);

        imageMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Code Here
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });


        //===============Drawer Layout Code=========================
    }
}