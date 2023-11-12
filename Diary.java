public class Diary extends Writing {

    private String author;

    public Diary(String title, Integer price, String author) {
        super(title, price);
        this.author = author;
    }

    public String toString() {
        return "Dairy " + getTitle() + " by " + author;
    }
}
