import java.util.Scanner;

public class Main {
    private static final BookManager bookManager = new BookManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("[1] Dodaj książkę");
            System.out.println("[2] Usuń książkę");
            System.out.println("[3] Zaktualizuj książkę");
            System.out.println("[4] Wyświetl książki");
            System.out.println("[5] Wyjście");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    removeBook(scanner);
                    break;
                case 3:
                    updateBook(scanner);
                    break;
                case 4:
                    listBooks();
                    break;
                case 5:
                    System.out.println("Zamykanie...");
                    return;
                default:
                    System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        }
    }

    private static void addBook(Scanner scanner) {
        System.out.print("Podaj tytuł: ");
        String title = scanner.nextLine();
        System.out.print("Podaj autora: ");
        String author = scanner.nextLine();
        System.out.print("Podaj ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Podaj rok: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        Book book = new Book(title, author, isbn, year);
        bookManager.addBook(book);
        System.out.println("Książka dodana pomyślnie.");
    }

    private static void removeBook(Scanner scanner) {
        System.out.print("Podaj ISBN książki do usunięcia: ");
        String isbn = scanner.nextLine();
        if (bookManager.bookExists(isbn)) {
            bookManager.removeBook(isbn);
            System.out.println("Książka usunięta pomyślnie.");
        } else {
            System.out.println("Błędny numer ISBN. Książka nie została znaleziona.");
        }
    }

    private static void updateBook(Scanner scanner) {
        System.out.print("Podaj ISBN książki do zaktualizowania: ");
        String isbn = scanner.nextLine();
        System.out.print("Podaj nowy tytuł: ");
        String title = scanner.nextLine();
        System.out.print("Podaj nowego autora: ");
        String author = scanner.nextLine();
        System.out.print("Podaj nowy rok: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        Book updatedBook = new Book(title, author, isbn, year);
        bookManager.updateBook(isbn, updatedBook);
        System.out.println("Książka zaktualizowana pomyślnie.");
    }

    private static void listBooks() {
        System.out.println("Książki:");
        for (Book book : bookManager.getBooks()) {
            System.out.println(book);
        }
    }
}
