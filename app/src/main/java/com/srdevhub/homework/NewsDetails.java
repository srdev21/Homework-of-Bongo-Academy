package com.srdevhub.homework;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

public class NewsDetails extends AppCompatActivity {

    ImageView cover_id;
    TextView title_id,des_id;
    FloatingActionButton microphone_id;

    TextToSpeech textToSpeech;

    public  static String TITLE="";
    public  static String DES="";
    public  static Bitmap MyBitmap=null;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_news_details);

        cover_id=findViewById(R.id.cover_id);
        title_id=findViewById(R.id.title_id);
        des_id=findViewById(R.id.des_id);
        microphone_id=findViewById(R.id.microphone_id);


        title_id.setText(TITLE);
        des_id.setText(DES);
        if (MyBitmap!=null){
            cover_id.setImageBitmap(MyBitmap);

        }

        textToSpeech= new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {

            }
        });

        microphone_id.setOnClickListener(view -> {
            textToSpeech.speak(TITLE+DES,TextToSpeech.QUEUE_FLUSH,null);
        });


    }
}