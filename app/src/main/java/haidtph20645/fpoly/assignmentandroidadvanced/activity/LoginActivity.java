package haidtph20645.fpoly.assignmentandroidadvanced.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import haidtph20645.fpoly.assignmentandroidadvanced.R;
import haidtph20645.fpoly.assignmentandroidadvanced.service.LoginService;

public class LoginActivity extends AppCompatActivity {

  /*  các bước sử lý dữ liệu qua service
            b1: lấy dữ liệu gửi qua getService xử lý
            b2: servicer xử lý gửi lại activity bằng broadcast Receiver (kèm cả action)
            b3: activity nhận dữ liệu broadcast từ service bằng (BroadcastReceiver broadcastReceiver)
            b4: phải đăng ký action cho activity (intentFilter) ở onResume và hủy đăng ký ở onPause

            */

    TextInputLayout edt_user, edt_password;
    Button btn_login;

    IntentFilter intentFilter;      //để đăng ký đưuọc antion cho hệ thống

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        edt_user = findViewById(R.id.login_edt_username);
        edt_password = findViewById(R.id.login_edt_password);
        btn_login = findViewById(R.id.login_btn_login);

        intentFilter = new IntentFilter();
        intentFilter.addAction("kiemTraDangNhap");
//        intentFilter.addAction("...");        //nhiều action thì add bằng đó

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edt_user.getEditText().getText().toString().trim();
                String password =  edt_password.getEditText().getText().toString().trim();

                //chuyển dữ liệu qua service để xử lý
                Intent intent = new Intent(LoginActivity.this, LoginService.class);
                Bundle bundle = new Bundle();
                bundle.putString("user", user);
                bundle.putString("password", password);
                intent.putExtras(bundle);
                startService(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(broadcastReceiver, intentFilter);      //đăng ký cho action trên intentfilter
    }



    //nhận broadcast resiver từ service
    public BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            // sử lý nhiều action của broadcast cùng lúc
            switch (intent.getAction()){
                case "kiemTraDangNhap":
                    Bundle bundle = intent.getExtras();
                    boolean check = bundle.getBoolean("check");
                    if (check == true){
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }else {
                        Toast.makeText(context, "Đăng nhập không thành công", Toast.LENGTH_SHORT).show();
                    }
                    break;


                default:
                    break;
            }
        }
    };


}