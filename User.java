import java.util.ArrayList;

public class User {

    private String userName;
    private ArrayList<Writing> borrowingHistory;
    private Integer cash;

    private Writing currentlyOwn;

    public User(String userName, Integer cash) {
        this.userName = userName;
        this.borrowingHistory = new ArrayList();
        this.cash = cash;
        this.currentlyOwn = null;
    }

    public void setCurrentlyOwn(Writing newCurrentlyOwn) {
        this.currentlyOwn = newCurrentlyOwn;
    }
    public Writing getCurrentlyOwn() {
        return this.currentlyOwn;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void addWritingToList(Writing write) {
        borrowingHistory.add(write);
    }
    public Boolean removeWritingFromList(Writing write) {
        return borrowingHistory.remove(write);
    }

    public void setCash(Integer cash) {
        this.cash = cash;
    }
    public Integer getCash() {
        return this.cash;
    }

    public void getBorrowingHistory() {
        for(Writing write : borrowingHistory) {
            System.out.println(userName + " borrowed " + write.getTitle());
        }
    }

}
