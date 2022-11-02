package haidtph20645.fpoly.assignmentandroidadvanced.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import haidtph20645.fpoly.assignmentandroidadvanced.R;

public class MonHocActivity extends AppCompatActivity {

    CardView dangkykhoahoc, khoahocdadangky;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_hoc);

        dangkykhoahoc = findViewById(R.id.monhoc_cardView_dangkykhoahoc);
        khoahocdadangky = findViewById(R.id.monhoc_cardView_khoahocdadangky);


        dangkykhoahoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MonHocActivity.this, DanhSachKhoaHocActivity.class);
                Bundle bundle = new Bundle();
                bundle.putBoolean("isAll", true);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        khoahocdadangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MonHocActivity.this, DanhSachKhoaHocActivity.class);
                Bundle bundle = new Bundle();
                bundle.putBoolean("isAll", false);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });



    }
}