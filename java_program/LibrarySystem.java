class Book {  
    private String title;  
    private String author;  
    private String ISBN;  
    private boolean isIssued;  

    public Book(String title, String author, String ISBN) {  
        this.title = title;  
        this.author = author;  
        this.ISBN = ISBN;  
        this.isIssued = false;  
    }  

    public void issue() {  
        if (!isIssued) {  
            isIssued = true;  
            System.out.println(title + " issued.");  
        } else {  
            System.out.println(title + " already issued.");  
        }  
    }  

    public void returnBook() {  
        if (isIssued) {  
            isIssued = false;  
            System.out.println(title + " returned.");  
        } else {  
            System.out.println(title + " not issued.");  
        }  
    }  

    public String getDetails() {  
        return "Title: " + title + ", Author: " + author + ", ISBN: " + ISBN + ", Issued: " + isIssued;  
    }  
}  

public class LibrarySystem {  
    public static void main(String[] args) {  
        Book[] books = new Book[2];  
        books[0] = new Book("Java Basics", "Author1", "ISBN1");  
        books[1] = new Book("OOP Concepts", "Author2", "ISBN2");  

        books[0].issue();  
        System.out.println(books[0].getDetails());  
        books[0].returnBook();  
        System.out.println(books[0].getDetails());  
    }  
}  
