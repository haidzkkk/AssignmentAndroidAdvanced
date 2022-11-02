package haidtph20645.fpoly.assignmentandroidadvanced.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import haidtph20645.fpoly.assignmentandroidadvanced.R;
import haidtph20645.fpoly.assignmentandroidadvanced.adapter.DangKyMonHocAdapter;
import haidtph20645.fpoly.assignmentandroidadvanced.model.MonHoc;
import haidtph20645.fpoly.assignmentandroidadvanced.service.DangKyMonHocService;

public class DanhSachKhoaHocActivity extends AppCompatActivity {

    RecyclerView rcv_dangkymonhoc;
    TextView textView;
    int id;

    boolean isAll;
    IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_khoa_hoc);

        rcv_dangkymonhoc = findViewById(R.id.rcv_dangkymonhoc);
        textView = findViewById(R.id.tv_dangkymonhoc);

        intentFilter = new IntentFilter();
        intentFilter.addAction("danhSachMonHoc");
        intentFilter.addAction("DSMonHoc");

        //lấy intent để check có lấy tất cả ds hay lấy ds đã đăng ký
        Intent intentIsAll = getIntent();
        Bundle bundleIsAll = intentIsAll.getExtras();
        isAll = bundleIsAll.getBoolean("isAll");
        if (isAll){
            textView.setText("Đăng ký môn học");
        }else {
            textView.setText("Khóa học đã đăng ký");
        }

        //id của người dùng đăng nhập
        SharedPreferences sharedPreferences = getSharedPreferences("THONGTIN", MODE_PRIVATE);
        id = sharedPreferences.getInt("id", -1);

//chuyển dữ liệu qua service để xử lý
        Intent intent = new Intent(DanhSachKhoaHocActivity.this, DangKyMonHocService.class);
        Bundle bundle = new Bundle();
        bundle.putInt("id", id);
        bundle.putBoolean("isAll", isAll);
        intent.putExtras(bundle);
        startService(intent);
    }

    // đăng ký
    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(broadcastReceiver, intentFilter);
    }

    //hủy đăng ký
    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadcastReceiver);
    }

    //nhận broadcast resiver từ service
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            switch (intent.getAction()){
                case "danhSachMonHoc":
                case "DSMonHoc":
                    Bundle bundle = intent.getExtras();
                    boolean check = bundle.getBoolean("check", true);
                    if (check){
                        ArrayList<MonHoc> list = (ArrayList<MonHoc>) bundle.getSerializable("list");
                        loadData(list);
                    }else {
                        Toast.makeText(context, "Thất bại", Toast.LENGTH_SHORT).show();
                    }

                    break;

                default:
                    break;
            }

        }
    };


    private void loadData(ArrayList<MonHoc> list){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rcv_dangkymonhoc.setLayoutManager(layoutManager);
        DangKyMonHocAdapter adapter = new DangKyMonHocAdapter(this, list, id, isAll);
        rcv_dangkymonhoc.setAdapter(adapter);
    }

}