package haidtph20645.fpoly.assignmentandroidadvanced.model;

import java.io.Serializable;
import java.util.ArrayList;

public class MonHoc implements Serializable {
    public String code;
    public String name;
    public String teacher;
    public int idRegister;
    public ArrayList<ThongTin> list;

    public MonHoc() {
    }

    public MonHoc(String code, String name, String teacher) {
        this.code = code;
        this.name = name;
        this.teacher = teacher;
    }

    public MonHoc(String code, String name, String teacher, int idRegister) {
        this.code = code;
        this.name = name;
        this.teacher = teacher;
        this.idRegister = idRegister;
    }

    public MonHoc(String code, String name, String teacher, int idRegister, ArrayList<ThongTin> list) {
        this.code = code;
        this.name = name;
        this.teacher = teacher;
        this.idRegister = idRegister;
        this.list = list;
    }
}
