public class Writing {
    private String title;
    private Boolean isAvailable;
    private Integer price;
    private User owner;

    public Writing(String title, Integer price) {
        this.title = title;
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
    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

}
