package haidtph20645.fpoly.assignmentandroidadvanced.service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import haidtph20645.fpoly.assignmentandroidadvanced.dao.DangKyMonHocDAO;
import haidtph20645.fpoly.assignmentandroidadvanced.model.MonHoc;

public class DangKyMonHocService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

// xử lý dữ liệu bằng service
        Bundle bundle = intent.getExtras();
        int id = bundle.getInt("id");
        boolean isAll = bundle.getBoolean("isAll");

        DangKyMonHocDAO dangKyMonHocDAO = new DangKyMonHocDAO(this);
        ArrayList<MonHoc> list = dangKyMonHocDAO.select(id, isAll);

//chuyền ngược lại activity bằng broadcast
        Intent intentBR = new Intent();
        Bundle bundleBR = new Bundle();
        bundleBR.putSerializable("list", list);               //phải implements Serializable bên model thì với chuyển list qua bundle đuọc
        intentBR.putExtras(bundleBR);
        intentBR.setAction("danhSachMonHoc");
        sendBroadcast(intentBR  );

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
