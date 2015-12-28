package com.tlalim.masa.parksclient.activities.user;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.tlalim.masa.parksclient.R;
import com.tlalim.masa.parksclient.activities.MainMenu;

public class LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
    }

    public void forgotPassword(View view) {
        Intent intent = new Intent(getApplicationContext(), ForgotPassword.class);
        startActivity(intent);
    }

    public void logIn(View view) {
        EditText name = (EditText) findViewById(R.id.emailLoginIn);
        EditText password = (EditText) findViewById(R.id.passwordLogin);

        ParseUser.logInInBackground(name.getText().toString(),
                password.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser parseUser, ParseException e) {
                        if (e == null) {
                            Toast.makeText(getApplicationContext(), "Success!!!", Toast.LENGTH_LONG).
                                    show();
                            Intent intent = new Intent(getApplicationContext(), MainMenu.class);
                            startActivity(intent);
                        } else
                            Toast.makeText(getApplicationContext(), "Failed! " + e.getMessage(), Toast.LENGTH_LONG).
                                    show();
                    }

                });
    }
}
