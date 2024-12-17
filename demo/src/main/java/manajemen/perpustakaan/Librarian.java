package manajemen.perpustakaan;

public class Librarian extends User {
    public Librarian(String name) {
        super(name);
    }

    @Override
    public void displayRole() {
        System.out.println(name + " is a Librarian.");
    }
}
