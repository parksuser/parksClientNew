package com.tlalim.masa.parksclient.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.tlalim.masa.parksclient.R;
import com.tlalim.masa.parksclient.activities.news.ClientNewsMainActivity;

public class MainMenu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void openNews(View view) {
        Intent intent = new Intent(getApplicationContext(), ClientNewsMainActivity.class);
        startActivity(intent);
    }
}
