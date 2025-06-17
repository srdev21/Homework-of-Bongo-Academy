package com.srdevhub.homework;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NumberTable extends AppCompatActivity {

    ImageView back,btnDelete;

    EditText edValue;
    TextView resBox;
    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_number_table);

        edValue = findViewById(R.id.edValue);
        resBox = findViewById(R.id.resBox);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnDelete = findViewById(R.id.btnDelete);
        back=findViewById(R.id.back);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String SValue = edValue.getText().toString().trim();
                // Check if input is not empty
                if (!SValue.isEmpty()) {
                    try {
                        int value = Integer.parseInt(SValue);
                        resBox.setText(""); // Clear previous result
                        Table(value);
                        showToast("Table Generated Successfully");
                    } catch (NumberFormatException e) {
                        resBox.setText("Invalid number");
                    }
                } else {
                    resBox.setText("Please enter a number");
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

        }
    private void Table(int value){

        for (int i=1;i<=10;i++){
            resBox.append(value+"*"+i+"="+value*i+"\n");
        }


    }

    private  void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }
}