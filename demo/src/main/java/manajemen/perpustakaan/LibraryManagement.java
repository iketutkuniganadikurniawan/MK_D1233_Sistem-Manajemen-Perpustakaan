package manajemen.perpustakaan;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagement {
    private ArrayList<Book> books;

    public LibraryManagement() {
        books = new ArrayList<>();
    }

    public void addBook(String title, String category) {
        books.add(new Book(title, category));
        System.out.println("Buku berhasil ditambahkan.");
    }

    public void searchBook(String query, String type) {
        for (Book book : books) {
            if ((type.equals("title") && book.getTitle().equalsIgnoreCase(query)) ||
                (type.equals("category") && book.getCategory().equalsIgnoreCase(query))) {
                System.out.println(book);
            }
        }
    }

    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isBorrowed()) {
                book.borrowBook();
                System.out.println("Anda berhasil meminjam buku: " + title);
                return;
            }
        }
        System.out.println("Buku tidak tersedia atau sudah dipinjam.");
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isBorrowed()) {
                book.returnBook();
                System.out.println("Anda berhasil mengembalikan buku: " + title);
                return;
            }
        }
        System.out.println("Buku tidak ditemukan atau belum dipinjam.");
    }

    public static void main(String[] args) {
        LibraryManagement library = new LibraryManagement();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selamat datang di Sistem Manajemen Perpustakaan!");
        Librarian librarian = new Librarian("Alice");
        librarian.displayRole();

        Member member = new Member("Bob");
        member.displayRole();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Cari Buku");
            System.out.println("3. Pinjam Buku");
            System.out.println("4. Kembalikan Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Masukkan judul buku: ");
                    String title = scanner.nextLine();
                    System.out.print("Masukkan kategori buku: ");
                    String category = scanner.nextLine();
                    library.addBook(title, category);
                    break;
                case 2:
                    System.out.print("Cari berdasarkan (title/category): ");
                    String type = scanner.nextLine();
                    System.out.print("Masukkan kata kunci pencarian: ");
                    String query = scanner.nextLine();
                    library.searchBook(query, type);
                    break;
                case 3:
                    System.out.print("Masukkan judul buku yang ingin dipinjam: ");
                    title = scanner.nextLine();
                    library.borrowBook(title);
                    break;
                case 4:
                    System.out.print("Masukkan judul buku yang ingin dikembalikan: ");
                    title = scanner.nextLine();
                    library.returnBook(title);
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan Sistem Manajemen Perpustakaan!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}
