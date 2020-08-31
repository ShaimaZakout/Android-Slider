package com.example.slider;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class SliderAdapter extends PagerAdapter {
    Context context;
    ArrayList<String> titleText = new ArrayList<>();
    ArrayList<String> subText = new ArrayList<>();
    ArrayList<Integer> imgs = new ArrayList<>();


    public SliderAdapter(Context context) {
        this.context = context;
        titleText.add("Eat");
        titleText.add("Sleep");
        titleText.add("Code");
        subText.add("PROFESSIONAL UMBRELLA: Our most popular umbrella, the umbrella is a compact wind resistant navy blue rain umbrella designed to fit in business briefcases, college backpacks, small travel totes, and glove compartments. With sleek styling, including a blue wind proof canopy, rubberized comfort grip handle, and an auto open close mechanism, the umbrella is the perfect size umbrella for the frequent traveler");
        subText.add("PROFESSIONAL UMBRELLA: Our most popular umbrella, the umbrella is a compact wind resistant navy blue rain umbrella designed to fit in business briefcases, college backpacks, small travel totes, and glove compartments. With sleek styling, including a blue wind proof canopy, rubberized comfort grip handle, and an auto open close mechanism, the umbrella is the perfect size umbrella for the frequent traveler");
        subText.add("PROFESSIONAL UMBRELLA: Our most popular umbrella, the umbrella is a compact wind resistant navy blue rain umbrella designed to fit in business briefcases, college backpacks, small travel totes, and glove compartments. With sleek styling, including a blue wind proof canopy, rubberized comfort grip handle, and an auto open close mechanism, the umbrella is the perfect size umbrella for the frequent traveler");
        imgs.add(R.drawable.group_10);
        imgs.add(R.drawable.group_11);
        imgs.add(R.drawable.group_12);

    }

    @Override
    public int getCount() {
        return imgs.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.slider_custom_layout, null, false);
        ImageView imgV = view.findViewById(R.id.slider_img);
        TextView subtext = view.findViewById(R.id.slider_subtext);
        TextView titel = view.findViewById(R.id.slider_text);
        imgV.setImageResource(imgs.get(position));
        titel.setText(titleText.get(position));
        subtext.setText(subText.get(position));
        container.addView(view);


        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
//        super.destroyItem(container, position, object);
    }
}
