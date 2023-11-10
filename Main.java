public class Main {

    public static void main(String[] args) {
        Library lb1 = new Library("My Library", 0, 10);

        User user1 = new User("Gal", 100);
        User user2 = new User("Bony", 100);
        User user3 = new User("Yuval", 100);
        User user4 = new User("Liran", 100);
        lb1.addUser(user1);
        lb1.addUser(user2);
        lb1.addUser(user3);
        lb1.addUser(user4);


        //lb1.getUsersList();
        System.out.println();

        Book book1 = new Book("Hello", "Yuval Asraf", 30);
        Book book2 = new Book("World", "Gal Gabay", 80);
        Book book3 = new Book("HI", "Bony", 40);
        Book book4 = new Book("I'm preety", "Yuval Asraf", 50);
        lb1.addBook(book1);
        lb1.addBook(book2);
        lb1.addBook(book3);
        lb1.addBook(book4);

        //lb1.getBooksList();

        lb1.borrowBook(user2, book3);
        lb1.borrowBook(user1, book2);

        lb1.returnBook(user2, book3);

        System.out.println("Transactions history: ");
        lb1.getTransactionsList();

        System.out.println("User's borrowing history: ");
        user2.getBorrowingHistory();
        user1.getBorrowingHistory();

        if(book3.getOwner() != null)
            System.out.println("Owner of book3 is: " + book3.getOwner().getUserName());
        if(book2.getOwner() != null)
            System.out.println("Owner of book2 is: " + book2.getOwner().getUserName());


    }
}
