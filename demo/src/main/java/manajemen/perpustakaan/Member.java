package manajemen.perpustakaan;

public class Member extends User {
    public Member(String name) {
        super(name);
    }

    @Override
    public void displayRole() {
        System.out.println(name + " is a Library Member.");
    }
}
