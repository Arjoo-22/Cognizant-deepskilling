import java.util.Comparator;

class Book {
    int bookId;
    String title;
    String author;

    // Constructor
    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    // Display method
    void display() {
        System.out.println("Book ID : " + bookId);
        System.out.println("Title   : " + title);
        System.out.println("Author  : " + author);
        System.out.println();
    }
}

public class LibraryManagementSystem {

    // Linear Search Method
    static Book linearSearch(Book books[], String targetTitle) {

        for (Book b : books) {
            if (b.title.equalsIgnoreCase(targetTitle)) {
                return b;
            }
        }
        return null;
    }

    // Binary Search Method
    static Book binarySearch(Book books[], String targetTitle) {

        int low = 0;
        int high = books.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int compare = books[mid].title.compareToIgnoreCase(targetTitle);

            if (compare == 0) {
                return books[mid];
            } 
            else if (compare < 0) {
                low = mid + 1;
            } 
            else {
                high = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Book books[] = {
                new Book(101, "Java", "James Gosling"),
                new Book(102, "Python", "Guido Van Rossum"),
                new Book(103, "C++", "Bjarne Stroustrup"),
                new Book(104, "Data Structures", "Mark Allen")
        };

        // Linear Search
        System.out.println("===== Linear Search =====");

        Book result1 = linearSearch(books, "Python");

        if (result1 != null)
            result1.display();
        else
            System.out.println("Book not found");


        // Sort array for Binary Search
        Arrays.sort(books, Comparator.comparing(book -> book.title));

        // Binary Search
        System.out.println("===== Binary Search =====");

        Book result2 = binarySearch(books, "Python");

        if (result2 != null)
            result2.display();
        else
            System.out.println("Book not found");
    }
} {
    
}
