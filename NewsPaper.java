public class NewsPaper extends  Writing {

    private String publishing;
    private String dateOfPublish;

    public NewsPaper(String title, Integer price, String publishing, String dateOfPublish) {
        super(title,price);
        this.publishing = publishing;
        this.dateOfPublish = dateOfPublish;
    }

    public String getPublishing() {
        return publishing;
    }
    public String getDateOfPublish() {
        return dateOfPublish;
    }
    public void setPublishing(String newPublishing) {
        this.publishing = newPublishing;
    }
    public void setDateOfPublish(String dateOfPublish) {
        this.dateOfPublish = dateOfPublish;
    }

    public String toString() {
        return getTitle() + " is a Newspaper by " + publishing + " published on " + dateOfPublish;
    }
}
