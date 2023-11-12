public class Book extends Writing {

    private Integer numPages;
    private String author;

    public Book(String title, String author, Integer price, Integer numPages) {
        super(title,price);
        this.author = author;
        this.numPages = numPages;
    }
    public String getAuthor() {
        return this.author;
    }
    public void setAuthor(String newAuthor) {
        this.author = newAuthor;
    }
    public Integer getNumPages() {
        return this.numPages;
    }
    public void setNumPages(Integer numPages) {
        this.numPages = numPages;
    }

    public String toString() {
        return "Book " + getTitle() + " by " + author;
    }

}
