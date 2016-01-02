package com.tlalim.masa.parksclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.parse.ParseUser;
import com.tlalim.masa.parksclient.activities.MainMenu;
import com.tlalim.masa.parksclient.activities.user.CreateAccount;
import com.tlalim.masa.parksclient.activities.user.LogIn;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ParseUser.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainMenu.class));
        }
    }
    public void createAccount(View view) {
        startActivity(new Intent(getApplicationContext(), CreateAccount.class));
    }

    public void logInAccount(View view) {
        startActivity(new Intent(getApplicationContext(),LogIn.class));
    }
}
