package com.example.alex.locationshoppinglist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button signInButton;
    Button noSignInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signInButton = (Button) findViewById(R.id.signIn);
        noSignInButton = (Button) findViewById(R.id.noSignIn);

        signInButton.setOnClickListener(this);
        noSignInButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Log.d("click", "works");

        switch(view.getId()) {
            case R.id.noSignIn:

                Intent i = new Intent(view.getContext(), HomeActivity.class);
                startActivity(i);

                break;

            default:
                break;
        }
    }
}
