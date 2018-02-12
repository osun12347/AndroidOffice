package com.example.v_wngwei.androidoffice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCenter.start(getApplication(), "13333e1c-7982-4d8b-a110-cfbc3d639412", Analytics.class, Crashes.class);

        Button crashButton = findViewById(R.id.bt_crash);
        Button eventsButton = findViewById(R.id.bt_events);

        eventsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, String> properties = new HashMap<>();
                properties.put("Category", "Music");
                properties.put("FileName", "favorite.avi");

                Analytics.trackEvent("Video clicked", properties);
            }
        });
        crashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a=0;
                int b=2/a;
            }
        });
    }
}
