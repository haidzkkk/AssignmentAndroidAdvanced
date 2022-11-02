package haidtph20645.fpoly.assignmentandroidadvanced.model;

public class New {
    public int id;
    public String title;
    public String description;
    public String date;
    public String link;

    public New(String title, String description, String date, String link) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.link = link;
    }

    public New(int id, String title, String description, String date, String link) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.link = link;
    }
}
