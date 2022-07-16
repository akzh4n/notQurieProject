package com.example.qurieproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.w3c.dom.Text;

public class TransferActivity extends AppCompatActivity {

    private TextView sumOfBalanceCrypto, sumOfBalanceDollar;

    private EditText editPersonTokenTxt, editValueTxt;
    private TextView sendBtn;

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);

        editPersonTokenTxt = (EditText) findViewById(R.id.editTokenPersonTxt);
        editValueTxt = (EditText) findViewById(R.id.editValueTxt);
        sendBtn = (TextView) findViewById(R.id.sendBtn);

        sumOfBalanceCrypto = (TextView) findViewById(R.id.sumOfBalanceCrypto);
        sumOfBalanceDollar = (TextView) findViewById(R.id.sumOfBalanceDollar);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendOnClick(view);
                progressBar.setVisibility(View.GONE);
            }
        });


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);


        bottomNavigationView.setSelectedItemId(R.id.transfer);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.qrcode:
                        startActivity(new Intent(getApplicationContext(), QRActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.transfer:
                        return true;
                }
                return false;
            }
        });
    }

    public void sendOnClick(View view) {
        progressBar.setVisibility(View.VISIBLE);



        if (!editPersonTokenTxt.getText().toString().isEmpty() && !editValueTxt.getText().toString().isEmpty()) {
            Toast.makeText(TransferActivity.this, "Successfully", Toast.LENGTH_SHORT).show();

        }
        else {
            Toast.makeText(TransferActivity.this, "Please fill in all fields!", Toast.LENGTH_SHORT).show();
        }
    }
}