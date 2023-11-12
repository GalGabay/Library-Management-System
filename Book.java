public class Book extends Writing {

    private Integer numPages;
    private String author;

    public Book(String title, String author, Integer price, Integer numPages) {
        super(title,price);
        this.author = author;
        this.numPages = numPages;
    }

}
