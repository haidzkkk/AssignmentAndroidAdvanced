package haidtph20645.fpoly.assignmentandroidadvanced.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import haidtph20645.fpoly.assignmentandroidadvanced.DBhelper.Dbhelper;
import haidtph20645.fpoly.assignmentandroidadvanced.model.MonHoc;
import haidtph20645.fpoly.assignmentandroidadvanced.model.ThongTin;

public class DangKyMonHocDAO {
    private Dbhelper dbhelper;

    public DangKyMonHocDAO(Context context) {
        dbhelper = new Dbhelper(context);
    }

    //lấy danh sách môn học
    public ArrayList<MonHoc> select(int id, boolean isAll) {
        ArrayList<MonHoc> list = new ArrayList<>();
        SQLiteDatabase db = dbhelper.getReadableDatabase();
        Cursor cursor;
        if (isAll) {
            cursor = db.rawQuery("SELECT * FROM MonHoc LEFT JOIN DangKy " +
                    "ON MonHoc.code = DangKy.code AND DangKy.id = ?", new String[]{String.valueOf(id)});
        }
        else {
            cursor = db.rawQuery("SELECT * FROM MonHoc JOIN DangKy " +
                    "ON MonHoc.code = DangKy.code WHERE DangKy.id = ?", new String[]{String.valueOf(id)});
        }

        if (cursor.getCount() != 0) {
            cursor.moveToFirst();
            do {
                list.add(new MonHoc(cursor.getString(0), cursor.getString(1),
                        cursor.getString(2), cursor.getInt(3), getListTT(cursor.getString(0))));
            } while (cursor.moveToNext());
        }
        return list;
    }

    public boolean insert(int id, String code) {
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", id);
        values.put("code", code);
        long check = db.insert("DangKy", null, values);
        return check > 0;
    }

    public boolean delete(int id, String code) {
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        long check = db.delete("DangKy", "id =? AND code =?", new String[]{String.valueOf(id), code});
        return check > 0;
    }

    public ArrayList<ThongTin> getListTT(String code){
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        ArrayList<ThongTin> listTT = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT date, address FROM ThongTin WHERE code = ?", new String[]{code});
        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            do {
                listTT.add(new ThongTin(cursor.getString(0), cursor.getString(1)));
            }while (cursor.moveToNext());
        }
        return listTT;
    }

}
