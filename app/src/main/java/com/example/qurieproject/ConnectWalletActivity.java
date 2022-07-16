package com.example.qurieproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class ConnectWalletActivity extends AppCompatActivity {

    private CardView metaCard;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_wallet);

        metaCard = (CardView) findViewById(R.id.card1);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);


        metaCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                metaCard.setCardBackgroundColor(Color.BLUE);
                progressBar.setVisibility(View.VISIBLE);

                Intent intent = new Intent(ConnectWalletActivity.this, CheckingActivity.class);
                startActivity(intent);
            }
        });
    }
}