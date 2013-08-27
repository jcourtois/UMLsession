import java.util.ArrayList;
import java.util.List;

public class Cart {

    public List<Book> getListOfBooks() {
        return listOfBooks;
    }

    private List<Book> listOfBooks = new ArrayList<Book>();

    public boolean add(Book book) {
        return listOfBooks.add(book);
    }

    public double getPrice() {
        double price = 0;
        for(Series series : new SeriesBuilder().parse(listOfBooks))
            price += series.getPrice();
        return price;
    }
}
