package manajemen.perpustakaan;

public class Book {
    private String title;
    private String category;
    private boolean isBorrowed;

    public Book(String title, String category) {
        this.title = title;
        this.category = category;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrowBook() {
        isBorrowed = true;
    }

    public void returnBook() {
        isBorrowed = false;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Category: " + category + ", Borrowed: " + (isBorrowed ? "Yes" : "No");
    }
}
