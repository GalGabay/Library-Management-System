public class Diary extends Writing {

    private String author;

    public Diary(String title, Integer price, String author) {
        super(title, price);
        this.author = author;
    }

    public String getAuthor() {
        return this.author;
    }
    public void setAuthor(String newAuthor) {
        this.author = newAuthor;
    }

    public String toString() {
        return "Dairy " + getTitle() + " by " + author;
    }
}
