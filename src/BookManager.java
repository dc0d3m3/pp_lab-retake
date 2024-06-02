import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookManager implements BookOperations {
    private List<Book> books;

    public BookManager() {
        this.books = new ArrayList<>();
        // przykładowe książki na uzupełnienie bazy
        books.add(new Book("Kępa Oksywska 1939", "Wacław Tym, Andrzej Rzepniewski", "8321572103", 1985));
        books.add(new Book("Nineteen Eighty-Four (1984)", "George Orwell", "9780452284234", 1949));
        books.add(new Book("Folwark zwierzęcy (Animal Farm)", "George Orwell", "9780141036137", 1945));
        books.add(new Book("Toksyczni ludzie", "Lillian Glass", "9788374893514", 2009));
        books.add(new Book("Władca Pierścieni: Trylogia (The Lord of the Rings)", "J.R.R. Tolkien", "9780618640157", 1954));
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void removeBook(String isbn) {
        Optional<Book> bookToRemove = books.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst();
        if (bookToRemove.isPresent()) {
            books.remove(bookToRemove.get());
        }
    }

    @Override
    public void updateBook(String isbn, Book updatedBook) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equals(isbn)) {
                books.set(i, updatedBook);
                break;
            }
        }
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }

    public boolean bookExists(String isbn) {
        return books.stream().anyMatch(book -> book.getIsbn().equals(isbn));
    }
}
