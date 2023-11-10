import java.util.ArrayList;

public class User {

    private String userName;
    private ArrayList<Book> borrowingHistory;
    private Integer cash;

    public User(String userName, Integer cash) {
        this.userName = userName;
        this.borrowingHistory = new ArrayList();
        this.cash = cash;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void addBookToList(Book book) {
        borrowingHistory.add(book);
    }
    public Boolean removeBookFromList(Book book) {
        return borrowingHistory.remove(book);
    }

    public void setCash(Integer cash) {
        this.cash = cash;
    }
    public Integer getCash() {
        return this.cash;
    }

    public void getBorrowingHistory() {
        for(Book book : borrowingHistory) {
            System.out.println(userName + " borrowed " + book.getTitle());
        }
    }

}
