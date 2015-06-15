//import Book.java;
import java.util.List;
import java.util.ArrayList;


public class Library {
    // Add the missing implementation to this class
    String mAddress;
    List<Book> mBooks = new ArrayList<>();

    public Library(String address){
        mAddress = address;
    }

    public  void printAddress(){
        System.out.println(mAddress);
    }

    public  void addBook(Book book){
        mBooks.add(book);
    }

    public void borrowBook(String book){
     boolean isBookInLibrary = false;
     boolean borrowed = false;
     Book libBook = new Book(book);

     for(Book mBook : mBooks){
        if(mBook.getTitle().equals(book)){
            isBookInLibrary = true;
            libBook = mBook;
        }
        if(mBook.isBorrowed()){
            borrowed = true;
            libBook = mBook;
        }
     }

     if (isBookInLibrary && !borrowed){
        System.out.println("You sucesfully borrowed The Lord of The Rings.");
        libBook.borrowed();
     } else if(isBookInLibrary && borrowed) {
        System.out.println("Sorry, this book is already borrowed.");
     } else {
        System.out.println("Sorry, this book is not in our catalog.");
     }
    }

    public void returnBook(String book){
        Book libBook = new Book(book);

        for(Book mBook : mBooks){
            if(mBook.getTitle().equals(book)){
                libBook = mBook;
            }
        }
        libBook.returned();
    }

    public void printAvailableBooks(){
        if (mBooks.size() == 0){
            System.out.println("No books in catalog");
        } else {
           for(Book book : mBooks){
                System.out.println(book.getTitle());
            }
        }
    }

    public static void printOpeningHours(){
        System.out.println("Libraries are open daily from 9am to 5pm");
    }
    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
} 