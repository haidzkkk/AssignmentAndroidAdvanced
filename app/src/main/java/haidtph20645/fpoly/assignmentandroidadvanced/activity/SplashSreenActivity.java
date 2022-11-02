package haidtph20645.fpoly.assignmentandroidadvanced.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import haidtph20645.fpoly.assignmentandroidadvanced.R;

public class SplashSreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_sreen);

        ImageView imageView = findViewById(R.id.splashscreen_img);

//        Glide.with(this).load(R.mipmap.splash).into(imageView);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashSreenActivity.this, LoginActivity.class));
            }
        }, 1000);

    }
}