import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.Map;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Transaction {

    private int transactionId;
    private User userInvolved;
    private Writing writingInvolved;
    private String dateBorrowed;
    private String dateReturned;

    public Transaction(User userInvolved, Writing writingInvolved) {
        this.transactionId = (int)(Math.random() * 10000) + 1;
        this.userInvolved = userInvolved;
        this.writingInvolved = writingInvolved;
        this.dateReturned = null;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.dateBorrowed = dtf.format(now);
    }

    public void borrowWriting() {
        writingInvolved.setIsAvailable(false);
        writingInvolved.setOwner(userInvolved);
        userInvolved.addWritingToList(writingInvolved);
        userInvolved.setCash(userInvolved.getCash()-writingInvolved.getPrice());
        userInvolved.setCurrentlyOwn(writingInvolved);
    }

    public Boolean returnWriting(Integer dueDate) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        LocalDateTime dateBorrowedParsed = LocalDateTime.parse(dateBorrowed, dtf);
        long daysBetween = Duration.between(now, dateBorrowedParsed).toDays();
        if(daysBetween > dueDate) {
            return false;
        } else {
            this.dateReturned = dtf.format(now);
            writingInvolved.setIsAvailable(true);
            writingInvolved.setOwner(null);
            userInvolved.setCurrentlyOwn(null);
            return true;
        }


    }

    public User getUserInvolved() {
        return userInvolved;
    }
    public Writing getWritingInvolved() {
        return this.writingInvolved;
    }

    public String toString() {
        String output =  "Transaction " + transactionId + " : user " + userInvolved.getUserName() + " Borrowed  " + writingInvolved.getTitle() + " on " + dateBorrowed;
        if(dateReturned != null) {
            output += " and returned on " + dateReturned;
        }
        return output;
    }
}
