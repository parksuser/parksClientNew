package com.tlalim.masa.parksclient.activities.user;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.tlalim.masa.parksclient.R;

public class CreateAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
    }

    //first
    public void createMail(View view) {
        Intent intent = new Intent(getApplicationContext(), CreateWithEmail.class);
        startActivity(intent);
    }
}
