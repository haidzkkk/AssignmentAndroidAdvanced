package haidtph20645.fpoly.assignmentandroidadvanced.model;

import java.io.Serializable;

public class ThongTin implements Serializable {
    public String date;
    public String address;

    public ThongTin() {
    }

    public ThongTin(String date, String address) {
        this.date = date;
        this.address = address;
    }
}
