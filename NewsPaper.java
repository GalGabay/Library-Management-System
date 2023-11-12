public class NewsPaper extends  Writing {

    private String publishing;
    private String dateOfPublish;

    public NewsPaper(String title, Integer price, String publishing, String dateOfPublish) {
        super(title,price);
        this.publishing = publishing;
        this.dateOfPublish = dateOfPublish;
    }

    public String toString() {
        return "Newspaper by " + publishing + " published on " + dateOfPublish;
    }
}
