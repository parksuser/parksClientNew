package com.tlalim.masa.parksclient.activities.user;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.tlalim.masa.parksclient.R;
import com.tlalim.masa.parksclient.activities.MainMenu;

public class CreateWithEmail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_with_email);
    }

    public void createWithMail(View v) {
        EditText name = (EditText) findViewById(R.id.nameCreate);
        String name1 = name.getText().toString();

        EditText email = (EditText) findViewById(R.id.emailCreate);
        String email1 = email.getText().toString();

        EditText password = (EditText) findViewById(R.id.passwordCreate);
        String password1 = password.getText().toString();

        EditText reTypePassword = (EditText) findViewById(R.id.reTypePassword);
        String reTypePassword1 = reTypePassword.getText().toString();

        EditText greenCard = (EditText) findViewById(R.id.greencard);
        String greenCard1 = greenCard.getText().toString();

        if (!name1.equals("") && !email1.equals("") && !password1.equals("") &&
                !reTypePassword1.equals("")) {

            System.out.println("все поля были заполнены");

            if (password.getText().toString().equals(reTypePassword.getText().toString())) {

                System.out.println("Пароли совпали");

                ParseUser parseUser = new ParseUser();

                parseUser.setUsername(name1);
                parseUser.setEmail(email1);
                parseUser.setPassword(password1);


                if (!greenCard1.equals("")) {
                    parseUser.put("cardNumber", greenCard1);
                    System.out.println("карта добавлена");
                }

                parseUser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            Toast.makeText(getApplicationContext(), "Account was created",
                                    Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(), MainMenu.class));
                        } else
                            Toast.makeText(getApplicationContext(), "Failed! " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                    }
                });
            } else {
                Toast.makeText(getApplicationContext(), "Password is not the same",
                        Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(getApplicationContext(),
                    "Please fill in the required fields and try again", Toast.LENGTH_LONG).
                    show();
        }
    }

    public void buyGreenCard(View view) {
        //эту функцию нужно реализовать
    }
}
