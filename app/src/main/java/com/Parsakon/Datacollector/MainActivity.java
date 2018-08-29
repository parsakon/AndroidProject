package com.example.datacollection;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.datacollector.MESSAGE";
    public static final String EMPTY_FIELDS = "Please complete all fields";
    public static final String PASS_NOT_EQUALS = "Passwords do not match";
    public static final String INVALID_EMAIL = "Email is not correct format";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
    public void login(View view){
        Intent intent = new Intent (this, activity_login.class);
        startActivity(intent);


    }
   public void signUp (View view){
        EditText firstname1 = (EditText) findViewById(R.id.firstname);
        EditText lastname1 = (EditText) findViewById(R.id.lastname);
        EditText emailTyped = (EditText) findViewById(R.id.email);
        EditText pass1 = (EditText) findViewById(R.id.password);
        EditText pass2 = (EditText) findViewById(R.id.passwordConfirm);

        String fname = firstname1.getText().toString();
        String lname = lastname1.getText().toString();
        String semail = emailTyped.getText().toString();
        String spass1 = pass1.getText().toString();
        String spass2 = pass2.getText().toString();

        Context context = getBaseContext();
        CharSequence text = EMPTY_FIELDS;
        int duration = Toast.LENGTH_SHORT;
//       Toast t = Toast.makeText(context, username.getText().toString(), duration);
//        t.show();
       //      Toast t = Toast.makeText(context, text, duration);
        if (fname.isEmpty() || lname.isEmpty() || semail.isEmpty() || spass1.isEmpty() || spass2.isEmpty()){
            Toast t = Toast.makeText(context, text, duration);
            t.show();
        }
        else if (!(spass1.equals(spass2))){
            Toast t = Toast.makeText(context, PASS_NOT_EQUALS, duration);
            t.show();
        }

        else if (!(isEmailValid(semail))){
            Toast t = Toast.makeText(context, INVALID_EMAIL, duration );
            t.show();
        }

        Intent intent = new Intent(this, signUpActivity.class);

    }

    boolean isEmailValid (CharSequence email)
    {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
