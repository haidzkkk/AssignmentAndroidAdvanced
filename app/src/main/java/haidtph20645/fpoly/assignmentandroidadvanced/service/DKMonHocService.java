package haidtph20645.fpoly.assignmentandroidadvanced.service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import haidtph20645.fpoly.assignmentandroidadvanced.dao.DangKyMonHocDAO;
import haidtph20645.fpoly.assignmentandroidadvanced.model.MonHoc;

public class DKMonHocService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Bundle bundle = intent.getExtras();
        int id = bundle.getInt("id", -1);
        String code = bundle.getString("code", "");
        boolean isAll = bundle.getBoolean("isAll", false);

        int isRegister = bundle.getInt("isRegister", -1);
        DangKyMonHocDAO dangKyMonHocDAO = new DangKyMonHocDAO(this);
        boolean check;
        if (isRegister == id){
            check = dangKyMonHocDAO.delete(id, code);
        }else {
            check = dangKyMonHocDAO.insert(id, code);
        }
        ArrayList<MonHoc> list = new ArrayList<>();
        if (check){
            list = dangKyMonHocDAO.select(id, isAll);
        }

        Intent intentBR = new Intent();
        Bundle bundleBR = new Bundle();
        bundleBR.putBoolean("check", check);
        bundleBR.putSerializable("list", list);
        intentBR.putExtras(bundleBR);
        intentBR.setAction("DSMonHoc");
        sendBroadcast(intentBR);

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
