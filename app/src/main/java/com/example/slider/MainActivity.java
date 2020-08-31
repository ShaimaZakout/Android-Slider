package com.example.slider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ViewPager slider;
    LinearLayout dots;
    Context c = MainActivity.this;
    TextView[] arrDotes;
    Button nextBtn, backBtn;
    int curntPage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nextBtn = findViewById(R.id.next_btn);
        backBtn = findViewById(R.id.back_btn);
        slider = findViewById(R.id.view_pager_id);
        dots = findViewById(R.id.dots_layout);
        SliderAdapter adapter = new SliderAdapter(c);
        slider.setAdapter(adapter);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slider.setCurrentItem(curntPage + 1);
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slider.setCurrentItem(curntPage - 1);
            }
        });
        ViewPager.OnPageChangeListener listenerV = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setDotes(position);
                curntPage = position;
                if (position == 0) {
                    nextBtn.setText("Next");
                    backBtn.setText("");
                    backBtn.setVisibility(View.INVISIBLE);
                    nextBtn.setEnabled(true);
                    backBtn.setEnabled(false);


                } else if (position == arrDotes.length - 1) {
                    nextBtn.setText("Finish");
                    backBtn.setText("Back");
                    backBtn.setVisibility(View.VISIBLE);
                    nextBtn.setEnabled(true);
                    backBtn.setEnabled(true);
                } else {
                    nextBtn.setText("Next");
                    backBtn.setText("Back");
                    backBtn.setVisibility(View.VISIBLE);
                    nextBtn.setEnabled(true);
                    backBtn.setEnabled(true);
                }


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };

        setDotes(0);
        slider.addOnPageChangeListener(listenerV);

    }

    public void setDotes(int postion) {
        arrDotes = new TextView[3];
        for (int i = 0; i < arrDotes.length; i++) {
            arrDotes[i] = new TextView(c);
//            arrDotes[i].setText(Html.fromHtml("ƃ#8226"));
            arrDotes[i].setTextSize(35);
            arrDotes[i].setTextColor(getResources().getColor(R.color.colorBase));
            dots.addView(arrDotes[i]);
            if (arrDotes.length > 0) {
//                arrDotes[postion].setTextColor(getResources().getColor(R.color.colorWhite));
            }


        }

    }
}
