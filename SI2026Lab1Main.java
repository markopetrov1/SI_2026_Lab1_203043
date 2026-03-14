import java.util.ArrayList;
import java.util.List;
//Updated by 243120
class Book {
    private String title;
    private String author;
    private String genre;
    private boolean borrowed;

    public Book(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.borrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Genre: " + genre + ", Borrowed: " + borrowed;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean searchBook(String title){
        for(Book b : books){
            if(b.title.equalsIgnoreCase(title)){
                return true;
            }
        }
        return false;
    }

    public boolean searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return true;
            }
        }
        return false;
    }

    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.setBorrowed(true);
                System.out.println("Borrowed successfully");
                return;
            }
        }
    }
    
    public boolean searchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return true;
            }
        }
        return false;
    }

    public void listByGenre(String genre) {
        for (Book book : books) {
            if (book.getGenre().equalsIgnoreCase(genre)) {
                System.out.println(book.getTitle());
            }
        }
    }
    public void printBooksByGenre(String genre) {
    }

    public int countAvailableBooks() {
        int count = 0;
        for (Book book : books) {
            if (!book.isBorrowed()) {
                count++;
            }
        }
        return count;
    }

    public void printBorrowedBooks() {
        for (Book book : books) {
            if (book.isBorrowed()) {
                System.out.println(book);
            }
        }
    }
}

public class SI2026Lab1Main {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "Programming"));
        library.addBook(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy"));
        library.addBook(new Book("1984", "George Orwell", "Dystopian"));

        System.out.println(library.searchByTitle("SomeTitle"));
        library.printBooksByGenre("Programming");
        System.out.println(library.searchByTitle("Clean Code"));
        library.borrowBook("Clean Code");
        System.out.println("Library initialized.");
    }
}
