package Cate.model;

public class Category {
    private int cateid;
    private String catename;
    private String icon;

    // Constructor mặc định (không tham số)
    public Category() {
    }

    // Constructor đầy đủ tham số
    public Category(int cateid, String catename, String icon) {
        this.cateid = cateid;
        this.catename = catename;
        this.icon = icon;
    }

    // Getter và Setter
    public int getCateid() {
        return cateid;
    }

    public void setCateid(int cateid) {
        this.cateid = cateid;
    }

    public String getCatename() {
        return catename;
    }

    public void setCatename(String catename) {
        this.catename = catename;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    // Optional: toString() để dễ debug
    @Override
    public String toString() {
        return "Category{" +
                "cateid=" + cateid +
                ", catename='" + catename + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}