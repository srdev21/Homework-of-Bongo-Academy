package com.srdevhub.homework;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class ArrayList_Hashmap_Practice extends AppCompatActivity {

    ListView listView;
    ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();
    HashMap<String,String> hashMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_array_list_hashmap_practice);
        listView=findViewById(R.id.listView);


        hashMap=new HashMap<>();
        hashMap.put("name","Sowad");
        hashMap.put("phone","01825899732");
        hashMap.put("email","srsowad123@gmail.com");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("name","Rahat");
        hashMap.put("phone","01954315401");
        hashMap.put("email","shrahat@gmail.com");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("name","Siam");
        hashMap.put("phone","01893014179");
        hashMap.put("email","siamhossain@gmail.com");
        arrayList.add(hashMap);

        MyAdapter myAdapter= new MyAdapter();
        listView.setAdapter(myAdapter);



    }

    private class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater= (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myView=layoutInflater.inflate(R.layout.item,viewGroup,false);

            TextView userName=myView.findViewById(R.id.userName);
            TextView userPhone=myView.findViewById(R.id.userPhone);
            TextView userEmail=myView.findViewById(R.id.userEmail);

            HashMap<String,String> hasmap=arrayList.get(position);
            userName.setText(hasmap.get("name"));
            userPhone.setText(hasmap.get("phone"));
            userEmail.setText(hasmap.get("email"));




            return myView;
        }
    }
}