import java.util.ArrayList;

public class Library {

    private String libraryName;
    private ArrayList<Writing> writingList;
    private ArrayList<User> usersList;
    private ArrayList<Transaction> transactionsList;
    private Integer dueDate; // how many days you can borrow a book before you are fined
    private Integer fine;

    public Library(String libraryName, Integer dueDate, Integer fine) {
        this.libraryName = libraryName;
        this.writingList = new ArrayList<>();
        this.usersList = new ArrayList<>();
        this.transactionsList = new ArrayList<>();
        this.fine = fine;
        this.dueDate = dueDate;
    }

    public Boolean addWriting(Writing addedWriting) {
        for (Writing write : writingList) {
            if(write.equals(addedWriting)) {
                return false;
            }
        }
        return writingList.add(addedWriting);
    }

    public Boolean removeWriting(Writing removedWriting) {
        return writingList.remove(removedWriting);
    }

    public void addUser(User newUser) {
        usersList.add(newUser);
    }

    public Writing searchWriting(Writing searchedWriting) {
        for(Writing write : writingList) {
            if(write.equals(searchedWriting)) {
                return write;
            }
        }
        return null;
    }

    public void getUsersList() {
        for( User user : usersList) {
            System.out.println(user.getUserName());
        }
    }
    public void getTransactionsList() {
        for( Transaction transaction : transactionsList) {
            System.out.println(transaction.toString());
        }
    }

    public void getWritingList() {
        for( Writing write : writingList) {
            System.out.print(write.getTitle());
            if(write instanceof Book)
                System.out.println(" is a Book");
            else if(write instanceof Diary)
                System.out.println(" is a Diary");
            else
                System.out.println(" is a Newspaper");
        }
    }

    public Boolean borrowWriting(User user, Writing desiredWriting) {
        for(Writing write : writingList) {
            if(write.equals(desiredWriting)) {
                if(write.getIsAvailable()) {
                    if(user.getCash() >= write.getPrice()) {
                        Transaction newTrans = new Transaction(user,write);
                        newTrans.borrowBook();
                        transactionsList.add(newTrans);
                        System.out.println("You borrowed " + desiredWriting.getTitle() +  ". Have a nice reading!");
                        return true;
                    } else {
                        System.out.println("You don't have enough money");
                        return false;
                    }
                } else {
                    System.out.println("The write is not available...sorry");
                    return false;
                }
            }
        }
        return false;
    }

    public void returnWriting(User user, Writing returnedWriting) {
        for(Transaction transaction: transactionsList) {
            if(transaction.getWritingInvolved().equals(returnedWriting) && transaction.getUserInvolved().equals(user)) {
                Boolean isFine = transaction.returnBook(dueDate);
                if(!isFine) {
                    System.out.println("You had this book too many days! you have a fine of: " + fine);
                    user.setCash(user.getCash()-fine);
                } else {
                    System.out.println("You returned " + returnedWriting.getTitle() + " successfully. thank you!");
                }
            }
        }


    }

}
