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

        Writing write1 = new Book("Hello", "Yuval Asraf", 30, 300);
        Writing write2 = new Diary("World",80, "Gal Gabay");
        Writing write3 = new NewsPaper("HI", 5, "The Times", "14/10/2023");
        Writing write4 = new Book("I'm preety", "Yuval Asraf", 50, 118);
        lb1.addWriting(write1);
        lb1.addWriting(write2);
        lb1.addWriting(write3);
        lb1.addWriting(write4);
        System.out.println(write1);
        System.out.println(write2);
        System.out.println(write3);
        System.out.println(write4);
       // lb1.getWritingList();
        System.out.println();

        lb1.borrowWriting(user2, write3);
        lb1.borrowWriting(user1, write2);

        lb1.returnWriting(user2, write3);

        System.out.println();

        System.out.println("Transactions history: ");
        lb1.getTransactionsList();

        System.out.println("User's borrowing history: ");
        user2.getBorrowingHistory();
        user1.getBorrowingHistory();

        if(write3.getOwner() != null)
            System.out.println("Owner of write3 is: " + write3.getOwner().getUserName());
        if(write2.getOwner() != null)
            System.out.println("Owner of write2 is: " + write2.getOwner().getUserName());
        if(user2.getCurrentlyOwn() != null)
            System.out.println(user2.getUserName() + " owns " + user2.getCurrentlyOwn());
        if(user1.getCurrentlyOwn() != null)
            System.out.println(user1.getUserName() + " owns " + user1.getCurrentlyOwn());


        System.out.println(lb1.searchWriting());

    }
}
