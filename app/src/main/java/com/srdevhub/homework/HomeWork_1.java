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

public class HomeWork_1 extends AppCompatActivity {

    ImageView back,btnDelete;

    EditText edValue;
    TextView resBox;
    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_work1);

        edValue = findViewById(R.id.edValue);
        resBox = findViewById(R.id.resBox);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnDelete = findViewById(R.id.btnDelete);
        back=findViewById(R.id.back);



        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (edValue.getText().toString().length()>0){
                    String SValue= edValue.getText().toString();
                    double value = Double.parseDouble(SValue);
                    if (value%5==0 && value%11==0){
                        resBox.setText("Your value is divisible by 5 and 11");
                    }else if (value%5==0){
                        resBox.setText("Your value is divisible by 5");
                    }else if (value%11==0){
                        resBox.setText("Your value is divisible by 11");
                    }else {
                        resBox.setText("Your value is not divisible by 5 and 11");
                    }

                }else {
                    edValue.setError("Please enter a value");
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
                HomeWork_1.super.onBackPressed();
            }
        });


    }
}