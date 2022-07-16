package com.example.qurieproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class JoinActivity extends AppCompatActivity {

    private TextView okBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        okBtn = (TextView) findViewById(R.id.okBtn);

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                okBtn.setBackground(getResources().getDrawable(R.drawable.round_button_on_click));
                Intent intent = new Intent(JoinActivity.this, ConnectWalletActivity.class);
                startActivity(intent);

            }
        });
    }
}