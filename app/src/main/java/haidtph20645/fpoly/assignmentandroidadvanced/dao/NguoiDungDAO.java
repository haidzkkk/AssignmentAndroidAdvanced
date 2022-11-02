package haidtph20645.fpoly.assignmentandroidadvanced.dao;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import haidtph20645.fpoly.assignmentandroidadvanced.DBhelper.Dbhelper;

public class NguoiDungDAO {
    Dbhelper dbhelper;
    SharedPreferences sharedPreferences;

    public NguoiDungDAO(Context context){
        dbhelper = new Dbhelper(context);
        sharedPreferences = context.getSharedPreferences("THONGTIN", Context.MODE_PRIVATE);
    }

    //kiểm tra thông tin đăng nhập
    public Boolean kiemTraDangNhap(String user, String password){
        SQLiteDatabase db = dbhelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM NguoiDung WHERE username = ? AND password = ?", new String[]{user, password});
        cursor.moveToFirst();
        if (cursor.getCount() != 0){
            //lưu thoogn tin người dùng (để phục vụ cho đăng ký khóa học và hủy đăng ký
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("id", cursor.getInt(0));
            editor.commit();
            return true;
        }
        return false;
    }

}
