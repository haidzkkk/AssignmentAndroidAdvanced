package haidtph20645.fpoly.assignmentandroidadvanced.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import haidtph20645.fpoly.assignmentandroidadvanced.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout Course = findViewById(R.id.main_img_course);
        LinearLayout Map= findViewById(R.id.main_img_map);
        LinearLayout New = findViewById(R.id.main_img_new);
        LinearLayout Social = findViewById(R.id.main_img_social);

        Course.setOnClickListener(view ->{
            Toast.makeText(this, "imgCourse", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, MonHocActivity.class));
        });

        Map.setOnClickListener(view ->{
            Toast.makeText(this, "imgMap", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, MapsWebViewActivity2.class));
        });

        New.setOnClickListener(view ->{
            Toast.makeText(this, "imgNew", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, NewActivity.class));
        });

        Social.setOnClickListener(view ->{
            Toast.makeText(this, "imgSocial", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, FacebookActivity.class));
        });

    }
}