package com.srdevhub.homework;

import android.os.Bundle;
import android.text.Html;
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

public class HomeWork_5 extends AppCompatActivity {

    EditText edValue;
    TextView resBox;
    Button btnCalculate;
    ImageView btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_work5);

        edValue = findViewById(R.id.edValue);
        resBox = findViewById(R.id.resBox);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnDelete = findViewById(R.id.btnDelete);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String SValue=edValue.getText().toString();
                if (SValue.length() > 0) {

                    int value  = Integer.parseInt(SValue);

                    if (value<=50){
                        double bill=value*0.5;
                        double totalBill=bill+(bill*0.2);
                        resBox.setText(Html.fromHtml("Your Bill is <font color='#06A93A'>"+totalBill+"  </font> Taka")); // Orange

                    }else if (value>50 && value<=150){
                        double bill=((value-50)*0.75)+(50*0.5);
                        double totalBill=bill+(bill*0.2);
                        resBox.setText(Html.fromHtml("Your Bill is <font color='#0EE251'>"+totalBill+"  </font> Taka")); // Orange
                    }else if (value<150 && value<=250){
                        double bill=((value-150)*1.20)+(50*0.5)+(100*0.75);
                        double totalBill=bill+(bill*0.2);
                        resBox.setText(Html.fromHtml("Your Bill is <font color='#FF5722'>"+totalBill+"  </font> Taka")); // Orange

                    }else if (value>250){
                        double bill=((value-250)*1.50)+(50*0.5)+(100*0.75)+(100*1.20);
                        double totalBill=bill+(bill*0.2);
                        resBox.setText(Html.fromHtml("Your Bill is <font color='#04B450'>"+totalBill+"  </font> Taka")); // Orange
                    }

                }else {
                    edValue.setError("Please Enter Value");
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edValue.setText("");
                resBox.setText("");
            }});

    }
}