package com.srdevhub.homework;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeWork_4 extends AppCompatActivity {

    EditText edPhy,edChem,edMath,edBio,edCse;
    TextView resBox;
    Button btnCalculate;
    ImageView back,btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_work4);

        edPhy=findViewById(R.id.edPhy);
        edChem=findViewById(R.id.edChem);
        edMath=findViewById(R.id.edMath);
        edBio=findViewById(R.id.edBio);
        edCse=findViewById(R.id.edCse);
        resBox=findViewById(R.id.resBox);
        btnCalculate=findViewById(R.id.btnCalculate);
        back=findViewById(R.id.back);
        btnDelete=findViewById(R.id.btnDelete);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (edPhy.getText().toString().length()>0 && edChem.getText().toString().length()>0 && edMath.getText().toString().length()>0 && edBio.getText().toString().length()>0 && edCse.getText().toString().length()>0){

                   double phy = Double.parseDouble(edPhy.getText().toString());
                   double chem = Double.parseDouble(edChem.getText().toString());
                   double math = Double.parseDouble(edMath.getText().toString());
                   double bio = Double.parseDouble(edBio.getText().toString());
                   double cse = Double.parseDouble(edCse.getText().toString());

                   if (phy>100 || chem>100 || math>100 || bio>100 || cse>100){
                       Toast toast = Toast.makeText(getApplicationContext(), "Please enter values less than 100", Toast.LENGTH_SHORT);
                       View toastView = toast.getView();

                       if (toastView != null) {
                           toastView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.alert));

                           TextView text = toastView.findViewById(android.R.id.message);
                           if (text != null) {
                               text.setTextColor(Color.WHITE);
                           }
                       }

                       toast.show();
                   }else {
                       double total = phy+chem+math+bio+cse;
                       double percentage = (total/500)*100;
                       if (percentage>=80){
                           resBox.setText("Your Total is "+total+"\n Your Grade is A+");
                           resBox.setText(Html.fromHtml("Your Total is <font color='#04B450'>"+total+"  </font> \n<br> Your Grade is <font color='#04B450'>A+</font>")); // Orange
// Load and start the animation
                           Animation slideUp = AnimationUtils.loadAnimation(HomeWork_4.this, R.anim.slide_up);
                           resBox.startAnimation(slideUp);
                       }else if (percentage>=70){
                           resBox.setText(Html.fromHtml("Your Total is <font color='#33D90E'>"+total+"  </font> \n<br> Your Grade is <font color='#33D90E'>A</font>")); // Orange
                           Animation slideUp = AnimationUtils.loadAnimation(HomeWork_4.this, R.anim.slide_up);
                           resBox.startAnimation(slideUp);
                       }else if (percentage>=60){
                           resBox.setText(Html.fromHtml("Your Total is <font color='#88E62A'>"+total+"  </font> \n<br> Your Grade is <font color='#88E62A'>A-</font>")); // Orange
                           Animation slideUp = AnimationUtils.loadAnimation(HomeWork_4.this, R.anim.slide_up);
                           resBox.startAnimation(slideUp);
                       }else if (percentage>=50){
                           resBox.setText(Html.fromHtml("Your Total is <font color='#CCB800'>"+total+"  </font> \n<br> Your Grade is <font color='#CCB800'>B</font>")); // Orange
                           Animation slideUp = AnimationUtils.loadAnimation(HomeWork_4.this, R.anim.slide_up);
                           resBox.startAnimation(slideUp);
                       }else if (percentage>=40){

                           resBox.setText(Html.fromHtml("Your Total is <font color='#FFB900'>"+total+"  </font> \n<br> Your Grade is <font color='#FFB900'>C</font>")); // Orange

                       }else if(percentage<40){
                           resBox.setText(Html.fromHtml("Your Total is <font color='#FF2500'>"+total+"  </font> \n<br> Your Grade is <font color='#FF2500'>F</font>")); // Orange
                           Animation slideUp = AnimationUtils.loadAnimation(HomeWork_4.this, R.anim.slide_up);
                           resBox.startAnimation(slideUp);
                       }
                   }


               }else {
                   Toast toast = Toast.makeText(getApplicationContext(), "Please enter all values and try again", Toast.LENGTH_SHORT);
                   View toastView = toast.getView();

                   if (toastView != null) {
                       toastView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.alert));

                       TextView text = toastView.findViewById(android.R.id.message);
                       if (text != null) {
                           text.setTextColor(Color.WHITE);
                       }
                   }

                   toast.show();

               }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                edPhy.setText("");
                edChem.setText("");
                edMath.setText("");
                edBio.setText("");
                edCse.setText("");
                resBox.setText("");
            }
        });

    }
}