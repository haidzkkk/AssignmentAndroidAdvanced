package haidtph20645.fpoly.assignmentandroidadvanced.service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

import haidtph20645.fpoly.assignmentandroidadvanced.dao.NguoiDungDAO;

public class LoginService extends Service {
    public LoginService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

// xử lý dữ liệu bằng service
        Bundle bundle = intent.getExtras();
        String user = bundle.getString("user");
        String password = bundle.getString("password");

        NguoiDungDAO nguoiDungDAO = new NguoiDungDAO(this);
        boolean check = nguoiDungDAO.kiemTraDangNhap(user, password);

//chuyền ngược lại activity bằng broadcast resever;
        Intent intentBR = new Intent();
        Bundle bundleBR = new Bundle();
        bundleBR.putBoolean("check", check);
        intentBR.putExtras(bundleBR);
        intentBR.setAction("kiemTraDangNhap");
        sendBroadcast(intentBR);


        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}