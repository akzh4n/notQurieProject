package com.example.qurieproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class CheckingActivity extends AppCompatActivity {

    private EditText secretPhraseText;
    private TextView goBtn;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checking);

        secretPhraseText = (EditText) findViewById(R.id.secretPhraseText);
        goBtn = (TextView) findViewById(R.id.goBtn);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);



        goBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                if(secretPhraseText.getText().toString().equals("cow is purple")) {
                    Toast.makeText(CheckingActivity.this, "Successfully!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(CheckingActivity.this, ProfileActivity.class);
                    startActivity(intent);
                } else{
                    Toast.makeText(CheckingActivity.this, "Oops, something wrong!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

}