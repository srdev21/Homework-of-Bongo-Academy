package com.srdevhub.homework;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class NewsApp extends AppCompatActivity {
    ListView listView;
    HashMap<String,String> hashMap;
    ArrayList< HashMap<String,String>> arrayList= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_news_app);
        listView=findViewById(R.id.listView);

        CreateTable();

        NewsApadter newsApadter=new NewsApadter();
        listView.setAdapter(newsApadter);

    }

    private  class NewsApadter extends BaseAdapter{

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
            View myView=layoutInflater.inflate(R.layout.news_item, viewGroup,false);


            TextView id_title=myView.findViewById(R.id.id_title);
            TextView id_des=myView.findViewById(R.id.id_des);
            TextView id_cat=myView.findViewById(R.id.id_cat);
            ImageView id_image=myView.findViewById(R.id.id_image);
            LinearLayout itemLay=myView.findViewById(R.id.item_lay);

            HashMap<String,String> hashMap=arrayList.get(position);

            String title= hashMap.get("title");
            String des= hashMap.get("des");
            String cat= hashMap.get("cat");
            String image_url= hashMap.get("image_url");

            id_title.setText(title);
            id_des.setText(des);
            id_cat.setText(cat);
            Picasso.get().load(image_url).into(id_image);

            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            id_cat.setBackgroundColor(color);

            itemLay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    NewsDetails.TITLE=title;
                    NewsDetails.DES=des;

                    Bitmap bitmap= ((BitmapDrawable)id_image.getDrawable()).getBitmap();
                    NewsDetails.MyBitmap=bitmap;

                    Intent intent=new Intent(NewsApp.this, NewsDetails.class);
                    startActivity(intent);
                }
            });


            return myView;
        }
    }

    private  void CreateTable(){
        hashMap=new HashMap<>();
        hashMap.put("cat","Sports");
        hashMap.put("title","Portugal beat Spain 5-3 on penalties: Nations League final – as it happened");
        hashMap.put("des","Cristiano Ronaldo was in tears as Portugal picked up their second Nations League title by beating holders Spain 5-3 on penalties following a thrilling 2-2 draw in Sunday’s final.\n" +
                "\n" +
                "Ronaldo’s 138th international goal took the final to a shootout, with Alvaro Morata’s miss proving costly for Spain as Ruben Neves struck the winning spot kick to spark wild scenes of celebration, with emotion overwhelming the veteran captain.\n" +
                "\n" +
                "Spain’s exhilarating 5-4 victory over France in Thursday’s semifinal ensured Luis de la Fuente’s side had continued an unbeaten run that stretched back to March 2023 coming into Sunday’s showpiece final in Munich.\n" +
                "\n" +
                "They appeared on course for yet another trophy, on the back of last year’s European Championship triumph, as Martin Zubimendi tapped home his second international goal in the 21st minute.\n" +
                "\n" +
                "The holders’ lead did not last long, however, as flying Portugal full-back Nuno Mendes slotted home the equaliser after good work from Ronaldo in the build-up.\n" +
                "\n" +
                "A sublime pass from midfielder Pedri helped Mikel Oyarzabal, who netted the winner against England in last year’s European Championship final, restore Spain’s lead before the break.\n" +
                "\n" +
                "The football tussle between the Iberian neighbours was billed as a clash between old and new – 40-year-old and five-times Ballon d’Or winner Ronaldo and Spain’s teenage sensation Lamine Yamal.\n" +
                "\n" +
                "While Yamal, among the favourites to take home one of the most prestigious individual awards this year, struggled to make inroads, Ronaldo pounced on his chance, firing Portugal level from close range just past the hour mark.\n" +
                "\n" +
                "Ronaldo went off injured late on and neither side could find a winner in extra time, with the game going to a shootout and Portugal netting all five of their penalties to claim the trophy.");
        hashMap.put("image_url","https://ss-i.thgim.com/public/incoming/c23oe0/article69669635.ece/alternates/LANDSCAPE_1200/Portugal-Nations-League.jpg");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("cat","War");
        hashMap.put("title","Israel's Netanyahu doesn't rule out targeting Iran's supreme leader and regime change");
        hashMap.put("des","Israeli Prime Minister Benjamin Netanyahu has suggested that targeting Iranian Supreme Leader Ayatollah Ali Khamenei and overthrowing his government could be a way to end the war that erupted when Israel launched airstrikes at the Islamic Republic last week.\n" +
                "\n" +
                "“We are doing what we need to do,” Netanyahu told ABC News on Monday night when asked if he plans to target Khamenei. “It’s not going to escalate the conflict, it’s going to end the conflict.”\n" +
                "\n" +
                "Earlier over the weekend, Netanyahu suggested that Israel’s operation “could certainly” result in a change in leadership inside Iran.\n" +
                "\n" +
                "His latest comments came as President Donald Trump indicated that the five-day conflict between the two countries could be entering a new phase as he left the G7 meeting of rich nations in Alberta, Canada, early to head back to Washington for meetings with top military officials.");
        hashMap.put("image_url","https://media-cldnry.s-nbcnews.com/image/upload/t_fit-860w,f_avif,q_auto:eco,dpr_2/rockcms/2025-06/250617-ali-khamenei-mb-1155-91e752.jpg");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("cat","Technology");
        hashMap.put("title","Google Adds AI Mode Traffic To Search Console Reports");
        hashMap.put("des","Google has updated Search Console to include AI Mode traffic (from AI-powered search experiences) in Performance reports.\n" +
                "\n" +
                "\uD83E\uDDE0 What is AI Mode?\n" +
                "A new interactive AI search experience from Google.\n" +
                "\n" +
                "Uses a method called “query fan out” to break questions into subtopics and search them in parallel.\n" +
                "\n" +
                "Enhances traditional search with deeper, AI-assisted responses.\n" +
                "\n" +
                "\uD83D\uDCCA What Changed?\n" +
                "Clicks and impressions from AI Mode are now counted in total Search Console metrics (not separated).\n" +
                "\n" +
                "No separate reporting tab exists — it's mixed in with existing “Web” traffic.\n" +
                "\n" +
                "Might cause noticeable shifts in your traffic stats.\n" +
                "\n" +
                "\uD83D\uDCC8 How AI Mode Metrics Work:\n" +
                "Click: When someone clicks an external link in AI Mode.\n" +
                "\n" +
                "Impression: Follows standard impression rules — the user must see or potentially see your link.\n" +
                "\n" +
                "Position: Works the same as regular search result rankings.\n" +
                "\n" +
                "Follow-up questions in AI Mode count as new queries.\n" +
                "\n" +
                "✅ SEO Best Practices Stay the Same\n" +
                "No new markup or schema needed.\n" +
                "\n" +
                "Tools like nosnippet, noindex, etc., still apply.\n" +
                "\n" +
                "No technical changes required to appear in AI Mode.\n" +
                "\n" +
                "\uD83D\uDD2E Looking Ahead\n" +
                "Expect changes in performance metrics.\n" +
                "\n" +
                "Google claims AI-generated traffic is “higher quality” (users stay longer), but this isn't yet verifiable due to the lack of segmented data.\n" +
                "\n" +
                "TL;DR: Google’s AI Mode traffic is now blended into your Search Console totals. No SEO changes are needed, but expect metric shifts as AI Mode grows in use.");
        hashMap.put("image_url","https://searchengineland.com/wp-content/seloads/2024/10/google-robots-1920.jpg");
        arrayList.add(hashMap);

    }
}