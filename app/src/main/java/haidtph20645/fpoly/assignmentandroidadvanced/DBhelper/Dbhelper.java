package haidtph20645.fpoly.assignmentandroidadvanced.DBhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Dbhelper extends SQLiteOpenHelper {
    public Dbhelper(@Nullable Context context) {
        super(context, "dbassandroid", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE DanhSachSave(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "title TEXT not null," +
                "description TEXT not null," +
                "date TEXT not null," +
                "link TEXT not null);");

        db.execSQL("CREATE TABLE NguoiDung(id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT, name TEXT)");
        db.execSQL("CREATE TABLE DangKy(id INTEGER, code TEXT)");
        db.execSQL("CREATE TABLE MonHoc(code TEXT PRIMARY KEY, name TEXT, teacher TEXT)");
        db.execSQL("CREATE TABLE ThongTin(id INTEGER PRIMARY KEY AUTOINCREMENT, code TEXT, date TEXT, address TEXT)");

        //data người dùng (user)
        db.execSQL("INSERT INTO NguoiDung VALUES(1,'hai','hai','Thanh Hai'),(2,'admin','admin','Do Thanh Hai')");

        //id: id người dùng, code: mã môn học đăng ký
        //data các môn học mà người dùng đã đăng ký
        db.execSQL("INSERT INTO DangKy VALUES(1,'MOB201'),(1,'MOB306'),(2,'MOB306')");

        //data môn học (course)
        db.execSQL("INSERT INTO MonHoc VALUES('MOB201','Android Nâng Cao','Phan Hoàng Hải')," +
                "('MOB306','React Native','Lý Đức Tuấn'),('MOB2041','Dự Án Mẫu','Trần Nguyễn Anh Đức')");

        //data thông tin lịch học từng môn (info)
        db.execSQL("INSERT INTO ThongTin VALUES(1, 'MOB201', 'Ca 2 - 19/09/2022', 'T1011')," +
                "(2, 'MOB201', 'Ca 2 - 21/09/2022', 'T1011'),(3, 'MOB201', 'Ca 2 - 23/09/2022', 'T1011')," +
                "(4, 'MOB306', 'Ca 5 - 20/09/2022', 'F204'),(5, 'MOB306', 'Ca 5 - 22/09/2022', 'F204')," +
                "(6, 'MOB2041', 'Ca 1 - 20/09/2022', 'Online - https://meet.google.com/rku-beuk-wqu')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion != oldVersion){
            db.execSQL("DROP TABLE IF EXISTS NguoiDung");
            db.execSQL("DROP TABLE IF EXISTS DangKy");
            db.execSQL("DROP TABLE IF EXISTS MonHoc");
            db.execSQL("DROP TABLE IF EXISTS ThongTin");
        }
    }
}
