import java.util.HashSet;
import java.util.Set;

public class Series {

    private final Discount discountTracker = new Discount();
    private Set<Book> listOfBooks = new HashSet<Book>();

    public int numberOfBooks() {
        return listOfBooks.size();
    }

    public boolean tryToAddBook(Book book) {
        return listOfBooks.add(book);
    }

    public double getDiscount() {
        return discountTracker.getDiscountFor(numberOfBooks());
    }

    public Double getPrice() {
        double price = 0;
        for(Book book : listOfBooks)
            price += book.getPrice();
        return price * (1.00 - getDiscount());
    }
}
