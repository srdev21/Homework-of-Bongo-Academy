package com.srdevhub.homework;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.text.Html; // Add this import at the top

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeWork_3 extends AppCompatActivity {

    ImageView back,btnDelete;
    EditText edValue;
    TextView resBox;
    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_work3);
        edValue = findViewById(R.id.edYear);
        resBox = findViewById(R.id.resBox);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnDelete = findViewById(R.id.btnDelete);
        back=findViewById(R.id.back);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String SValue= edValue.getText().toString();
                if (SValue.length()>0){
                    int value = Integer.parseInt(SValue);


                    if (value==1){
                        resBox.setText(Html.fromHtml("Today is <font color='#FF5722'>Saturday</font>")); // Orange
                    }else if (value==2){
                        resBox.setText(Html.fromHtml("Today is <font color='#E91E63'>Sunday</font>")); // Pink
                    }else if (value==3){
                        resBox.setText(Html.fromHtml("Today is <font color='#3F51B5'>Monday</font>")); // Indigo
                    }else if (value==4){
                        resBox.setText(Html.fromHtml("Today is <font color='#4CAF50'>Tuesday</font>")); // Green
                    }else if (value==5){
                        resBox.setText(Html.fromHtml("Today is <font color='#9C27B0'>Wednesday</font>")); // Purple
                    }else if (value==6){
                        resBox.setText(Html.fromHtml("Today is <font color='#009688'>Thursday</font>")); // Teal
                    }else if (value==7){
                        resBox.setText(Html.fromHtml("Today is <font color='#FFC107'>Friday</font>")); // Amber


                }else {
                        edValue.setError("Please enter a value between 1-7");
                    }

                }else{
                    edValue.setError("Please enter a value between 1-7");
                }
            }


        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edValue.setText("");
                resBox.setText("");
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                HomeWork_3.super.onBackPressed();
            }
        });

    }
}