public class Book {

    private String title;
    private String author;
    private Boolean isAvailable;
    private Integer price;
    private User owner;

    public Book(String title, String author, Integer price) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        this.price = price;
        this.owner = null;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean bool) {
        this.isAvailable = bool;
    }
    public Integer getPrice() {
        return this.price;
    }
    public void setPrice(Integer newPrice) {
        this.price = newPrice;
    }
    public void setOwner(User owner) {
        this.owner = owner;
    }
    public User getOwner() {
        return this.owner;
    }

    public String getTitle() {
        return title;
    }

}
