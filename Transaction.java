import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.Map;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Transaction {

    private int transactionId;
    private User userInvolved;
    private Book bookInvolved;
    private String dateBorrowed;
    private String dateReturned;

    public Transaction(User userInvolved, Book bookInvolved) {
        this.transactionId = (int)(Math.random() * 10000) + 1;
        this.userInvolved = userInvolved;
        this.bookInvolved = bookInvolved;
        this.dateReturned = null;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.dateBorrowed = dtf.format(now);
    }

    public void borrowBook() {
        bookInvolved.setIsAvailable(false);
        bookInvolved.setOwner(userInvolved);
        userInvolved.addBookToList(bookInvolved);
        userInvolved.setCash(userInvolved.getCash()-bookInvolved.getPrice());
    }

    public Boolean returnBook(Integer dueDate) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        LocalDateTime dateBorrowedParsed = LocalDateTime.parse(dateBorrowed, dtf);
        long daysBetween = Duration.between(now, dateBorrowedParsed).toDays();
        if(daysBetween > dueDate) {
            return false;
        } else {
            this.dateReturned = dtf.format(now);
            bookInvolved.setIsAvailable(true);
            bookInvolved.setOwner(null);
            return true;
        }


    }

    public User getUserInvolved() {
        return userInvolved;
    }
    public Book getBookInvolved() {
        return bookInvolved;
    }

    public String toString() {
        String output =  "Transaction " + transactionId + " : user " + userInvolved.getUserName() + " Borrowed book " + bookInvolved.getTitle() + " on " + dateBorrowed;
        if(dateReturned != null) {
            output += " and returned on " + dateReturned;
        }
        return output;
    }
}
