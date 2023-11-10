import java.util.ArrayList;

public class Library {

    private String libraryName;
    private ArrayList<Book> booksList;
    private ArrayList<User> usersList;
    private ArrayList<Transaction> transactionsList;
    private Integer dueDate; // how many days you can borrow a book before you are fined
    private Integer fine;

    public Library(String libraryName, Integer dueDate, Integer fine) {
        this.libraryName = libraryName;
        this.booksList = new ArrayList<>();
        this.usersList = new ArrayList<>();
        this.transactionsList = new ArrayList<>();
        this.fine = fine;
        this.dueDate = dueDate;
    }

    public Boolean addBook(Book addedBook) {
        for (Book book : booksList) {
            if(book.equals(addedBook)) {
                return false;
            }
        }
        return booksList.add(addedBook);
    }

    public Boolean removeBook(Book removedBook) {
        return booksList.remove(removedBook);
    }

    public void addUser(User newUser) {
        usersList.add(newUser);
    }

    public Book searchBook(Book searchedBook) {
        for(Book book : booksList) {
            if(book.equals(searchedBook)) {
                return book;
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

    public void getBooksList() {
        for( Book book : booksList) {
            System.out.println(book.getTitle());
        }
    }

    public Boolean borrowBook(User user, Book desiredBook) {
        for(Book book : booksList) {
            if(book.equals(desiredBook)) {
                if(book.getIsAvailable()) {
                    if(user.getCash() >= book.getPrice()) {
                        Transaction newTrans = new Transaction(user,book);
                        newTrans.borrowBook();
                        transactionsList.add(newTrans);
                        System.out.println("You borrowed " + desiredBook.getTitle() +  ". Have a nice reading!");
                        return true;
                    } else {
                        System.out.println("You don't have enough money");
                        return false;
                    }
                } else {
                    System.out.println("The book is not available...sorry");
                    return false;
                }
            }
        }
        return false;
    }

    public void returnBook(User user, Book returnedBook) {
        for(Transaction transaction: transactionsList) {
            if(transaction.getBookInvolved().equals(returnedBook) && transaction.getUserInvolved().equals(user)) {
                Boolean isFine = transaction.returnBook(dueDate);
                if(!isFine) {
                    System.out.println("You had this book too many days! you have a fine of: " + fine);
                    user.setCash(user.getCash()-fine);
                } else {
                    System.out.println("You returned " + returnedBook.getTitle() + " successfully. thank you!");
                }
            }
        }


    }

}
