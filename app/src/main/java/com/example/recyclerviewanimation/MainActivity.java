package com.example.recyclerviewanimation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView NewsRecyclerView;
    NewsAdapter newsAdapter;
    List<NewsItem> mData;
    FloatingActionButton fabSwitcher;    // dark
    boolean isDark = false;   // dark
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //  this activity full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        // hide the action bar
        getSupportActionBar().hide();

        fabSwitcher = findViewById(R.id.fab_switcher);
        constraintLayout = findViewById(R.id.constraint);
        NewsRecyclerView = findViewById(R.id.news_recycler);
        mData = new ArrayList<>();

        // load theme state
        isDark = getThemeStatePref();
        if (isDark) {                        // dark
            // dark theme is on
            constraintLayout.setBackgroundColor(getResources().getColor(R.color.black));
        } else {
            // light the is on
            constraintLayout.setBackgroundColor(getResources().getColor(R.color.white));
        }

        // fill list news with data
        // just for testing purpose i will fill the news list with random data
        // you may get your data from an api / firebase or sqlite database

        mData.add(new NewsItem("Benim Dünyalı", "Milyon yıllardan beridir dünyada yaşıyorum asdkahj asdkajhksjd ashıkahksjahkdjhakdsa hashdaıkhdsjkahsdja ashdıahsakısdja ashdaıksjdaksdna sakhdakjhsdkab dasbdkahsdkıajda bdakjdakj", "3 Şubat 3333", R.drawable.spacecraft));
        mData.add(new NewsItem("Marsın Hemen Yanından", "Herkese marstan selamlar", "1909", R.drawable.user));
        mData.add(new NewsItem("Benim Ben Uzay Aracı", "Tekerleklerim var döner döner gezerim asdkahj asdkajhksjd ashıkahksjahkdjhakdsa hashdaıkhdsjkahsdja ashdıahsakısdja ashdaıksjdaksdna sakhdakjhsdkab dasbdkahsdkıajda bdakjdakj", "1500 MÖ", R.drawable.uservoryager));
        mData.add(new NewsItem("Benim Dünyalı", "Milyon yıllardan beridir dünyada yaşıyorum", "3 Şubat 3333", R.drawable.spacecraft));
        mData.add(new NewsItem("Marsın Hemen Yanından", "Herkese marstan selamlar", "1909", R.drawable.user));
        mData.add(new NewsItem("Benim Ben Uzay Aracı", "Tekerleklerim var döner döner gezerim asdkahj asdkajhksjd ashıkahksjahkdjhakdsa hashdaıkhdsjkahsdja ashdıahsakısdja ashdaıksjdaksdna sakhdakjhsdkab dasbdkahsdkıajda bdakjdakj", "1500 MÖ", R.drawable.uservoryager));
        mData.add(new NewsItem("Benim Dünyalı", "Milyon yıllardan beridir dünyada yaşıyorum asdkahj asdkajhksjd ashıkahksjahkdjhakdsa hashdaıkhdsjkahsdja ashdıahsakısdja ashdaıksjdaksdna sakhdakjhsdkab dasbdkahsdkıajda bdakjdakj", "3 Şubat 3333", R.drawable.spacecraft));
        mData.add(new NewsItem("Marsın Hemen Yanından", "Herkese marstan selamlar asdkahj asdkajhksjd ashıkahksjahkdjhakdsa hashdaıkhdsjkahsdja ashdıahsakısdja ashdaıksjdaksdna sakhdakjhsdkab dasbdkahsdkıajda bdakjdakj", "1909", R.drawable.user));
        mData.add(new NewsItem("Benim Ben Uzay Aracı", "Tekerleklerim var döner döner gezerim", "1500 MÖ", R.drawable.uservoryager));
        mData.add(new NewsItem("Benim Dünyalı", "Milyon yıllardan beridir dünyada yaşıyorum asdkahj asdkajhksjd ashıkahksjahkdjhakdsa hashdaıkhdsjkahsdja ashdıahsakısdja ashdaıksjdaksdna sakhdakjhsdkab dasbdkahsdkıajda bdakjdakj", "3 Şubat 3333", R.drawable.spacecraft));
        mData.add(new NewsItem("Marsın Hemen Yanından", "Herkese marstan selamlar asdkahj asdkajhksjd ashıkahksjahkdjhakdsa hashdaıkhdsjkahsdja ashdıahsakısdja ashdaıksjdaksdna sakhdakjhsdkab dasbdkahsdkıajda bdakjdakj", "1909", R.drawable.user));
        mData.add(new NewsItem("Benim Ben Uzay Aracı", "Tekerleklerim var döner döner gezerim asdkahj asdkajhksjd ashıkahksjahkdjhakdsa hashdaıkhdsjkahsdja ashdıahsakısdja ashdaıksjdaksdna sakhdakjhsdkab dasbdkahsdkıajda bdakjdakj", "1500 MÖ", R.drawable.uservoryager));
        mData.add(new NewsItem("Benim Dünyalı", "Milyon yıllardan beridir dünyada yaşıyorum asdkahj asdkajhksjd ashıkahksjahkdjhakdsa hashdaıkhdsjkahsdja ashdıahsakısdja ashdaıksjdaksdna sakhdakjhsdkab dasbdkahsdkıajda bdakjdakj", "3 Şubat 3333", R.drawable.spacecraft));
        mData.add(new NewsItem("Marsın Hemen Yanından", "Herkese marstan selamlar", "1909", R.drawable.user));
        mData.add(new NewsItem("Benim Ben Uzay Aracı", "Tekerleklerim var döner döner gezerim asdkahj asdkajhksjd ashıkahksjahkdjhakdsa hashdaıkhdsjkahsdja ashdıahsakısdja ashdaıksjdaksdna sakhdakjhsdkab dasbdkahsdkıajda bdakjdakj", "1500 MÖ", R.drawable.uservoryager));
        mData.add(new NewsItem("Benim Dünyalı", "Milyon yıllardan beridir dünyada yaşıyorum", "3 Şubat 3333", R.drawable.spacecraft));
        mData.add(new NewsItem("Marsın Hemen Yanından", "Herkese marstan selamlar asdkahj asdkajhksjd ashıkahksjahkdjhakdsa hashdaıkhdsjkahsdja ashdıahsakısdja ashdaıksjdaksdna sakhdakjhsdkab dasbdkahsdkıajda bdakjdakj", "1909", R.drawable.user));
        mData.add(new NewsItem("Benim Ben Uzay Aracı", "Tekerleklerim var döner döner gezerim asdkahj asdkajhksjd ashıkahksjahkdjhakdsa hashdaıkhdsjkahsdja ashdıahsakısdja ashdaıksjdaksdna sakhdakjhsdkab dasbdkahsdkıajda bdakjdakj", "1500 MÖ", R.drawable.uservoryager));

        // adapter ini and setup

        newsAdapter = new NewsAdapter(this, mData, isDark);
        NewsRecyclerView.setAdapter(newsAdapter);
        NewsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        fabSwitcher.setOnClickListener(new View.OnClickListener() {            // Dark or light
            @Override
            public void onClick(View v) {
                isDark = !isDark;
                if (isDark) {
                    constraintLayout.setBackgroundColor(getResources().getColor(R.color.black));
                } else {
                    constraintLayout.setBackgroundColor(getResources().getColor(R.color.white));
                }
                newsAdapter = new NewsAdapter(getApplicationContext(), mData, isDark);
                NewsRecyclerView.setAdapter(newsAdapter);
                saveThemeStatePref(isDark);   // save dark
            }
        });

    }

    private void saveThemeStatePref(boolean isDark) {    // save dark
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isDark", isDark);
        editor.commit();
    }

    private boolean getThemeStatePref() {     // save dark
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPref", MODE_PRIVATE);
        boolean isDark = pref.getBoolean("isDark", false);
        return isDark;
    }
}