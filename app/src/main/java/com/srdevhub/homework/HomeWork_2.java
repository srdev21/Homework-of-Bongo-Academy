package com.srdevhub.homework;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeWork_2 extends AppCompatActivity {

    EditText edYear;
    TextView resBox;
    Button btnCalculate;
    ImageView btnDelete;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_work2);
        edYear = findViewById(R.id.edYear);
        resBox = findViewById(R.id.resBox);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnDelete = findViewById(R.id.btnDelete);
        back=findViewById(R.id.back);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edYear.getText().toString().length()>0 && edYear.getText().toString().length()<5){
                    String SValue= edYear.getText().toString();
                    int year = Integer.parseInt(SValue);
                    if (year%4==0 && year%100!=0 || year%400==0){
                        resBox.setText("This is a Leap Year");
                    }else {
                        resBox.setText("This is not a Leap Year");
                    }
                }else{
                    edYear.setError("Please enter 4digit value here");
                }

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edYear.setText("");
                resBox.setText("");
                }
        });



        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                HomeWork_2.super.onBackPressed();
            }
        });


    }
}