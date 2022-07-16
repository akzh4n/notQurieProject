package com.example.qurieproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Random;

public class SplashScreen extends Activity {

    Thread splashTread;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        imageView = (ImageView)findViewById(R.id.splashImage);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        int[] ids = new int[]{R.drawable.s_img,R.drawable.s_image_black, R.drawable.s_image_black2};
        Random randomGenerator = new Random();
        int r= randomGenerator.nextInt(ids.length);
        this.imageView.setImageDrawable(getResources().getDrawable(ids[r]));

        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 3500) {
                        sleep(100);
                        waited += 100;
                    }
                    Intent intent = new Intent(SplashScreen.this,
                            MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    SplashScreen.this.finish();
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    SplashScreen.this.finish();
                }

            }
        };
        splashTread.start();
    }

}