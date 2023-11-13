import java.util.ArrayList;
import java.util.Scanner;

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
                        newTrans.borrowWriting();
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
                Boolean isFine = transaction.returnWriting(dueDate);
                if(!isFine) {
                    System.out.println("You had this book too many days! you have a fine of: " + fine);
                    user.setCash(user.getCash()-fine);
                } else {
                    System.out.println("You returned " + returnedWriting.getTitle() + " successfully. thank you!");
                }
            }
        }


    }

    // search writing by category, author or title:
    public ArrayList<Writing> searchWriting() {

        ArrayList<Writing> result = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Library Searching:");

        String criteria;
        System.out.println("Please choose which criteria are you interested in:(title,author,category)");
        while(true) {
            criteria = scanner.nextLine();
            if (!criteria.equals("title") && !criteria.equals("author") && !criteria.equals("category")) {
                System.out.println("Wrong criteria! peak again:(title, author or category) ");
            } else {
                break;
            }
        }

        System.out.println("What you are searching for: ");
        String search = scanner.nextLine();

        for (Writing write : writingList) {
            if (criteria.equals("title") && write.getTitle().equalsIgnoreCase(search) ||
                    (criteria.equals("category") && search.equalsIgnoreCase("Diary") && write instanceof Diary) ||
                    (criteria.equals("category") && search.equalsIgnoreCase("Book") && write instanceof Book) ||
                    (criteria.equals("category") && search.equalsIgnoreCase("Newspaper") && write instanceof NewsPaper) ||
                    (criteria.equals("author") && write instanceof NewsPaper && ((NewsPaper) write).getPublishing().equalsIgnoreCase(search)) ||
                    (criteria.equals("author") && write instanceof Diary && ((Diary) write).getAuthor().equalsIgnoreCase(search)) ||
                    (criteria.equals("author") && write instanceof Book && ((Book) write).getAuthor().equalsIgnoreCase(search))
            ) {
                result.add(write);
            }
        }

        System.out.println("The results are: ");
        return result;

    }

}
