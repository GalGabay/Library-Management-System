# Library-Management-System

OOP Java project; 
Library managemant system, includes borrowing, returning and searching for writing such as books, diaries and newspapers;
Class 'User' with attributes: username, list of borrowing history and the cash the user has.
Getters and setters;
Class 'Writing' with attributes: title, isAvailable, price and current owner.
Getters and setters;
3 classes that extends Writing: Book(added num of pages and author), Diary(added author) and Newspaper(added publishing and date);
Class 'Transaction' with attributes: transaction id, user, book, date Borrowed and date returned.
BorrowBook and returnBook methods, and a toString override method. if the user had a writing for a longer time than expected, the user are fined.;
Class 'Library' which represent the library which got users, writings and transactions in it.
Attributes: list of users, of writings, of transactions. library name, dueDate and fine
Methods: add, search, get the lists, borrow and return writings, search writings by few criteria;