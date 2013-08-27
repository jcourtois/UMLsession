import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class seriesBuilderTest {
    @Test
    public void shouldTakeTwoDifferentBooksAndReturnOnePackage() {
        List<Book> listOfBooks = new ArrayList<Book>();
        listOfBooks.add(new Book(1));
        listOfBooks.add(new Book(2));
        Collection<Series> seriesCollection = new SeriesBuilder().parse(listOfBooks);

        assertThat(seriesCollection.size(),is(1));
    }

    @Test
    public void shouldTakeTwoOfTheSameBooksAndReturnTwoPackages() {
        List<Book> listOfBooks = new ArrayList<Book>();
        listOfBooks.add(new Book(1));
        listOfBooks.add(new Book(1));
        Collection<Series> seriesCollection = new SeriesBuilder().parse(listOfBooks);

        assertThat(seriesCollection.size(),is(2));
    }

    @Test
    public void shouldTakeFourOfTheSameBooksAndOneDifferentAndReturnFourPackages() {
        List<Book> listOfBooks = new ArrayList<Book>();
        listOfBooks.add(new Book(1));
        listOfBooks.add(new Book(1));
        listOfBooks.add(new Book(1));
        listOfBooks.add(new Book(2));
        listOfBooks.add(new Book(1));
        Collection<Series> seriesCollection = new SeriesBuilder().parse(listOfBooks);

        assertThat(seriesCollection.size(),is(4));
    }

    @Test
    public void shouldTakeFiveOfTheSameBooksAndOneDifferentAndReturnFivePackages() {
        List<Book> listOfBooks = new ArrayList<Book>();
        listOfBooks.add(new Book(1));
        listOfBooks.add(new Book(1));
        listOfBooks.add(new Book(1));
        listOfBooks.add(new Book(2));
        listOfBooks.add(new Book(2));

        listOfBooks.add(new Book(3));
        listOfBooks.add(new Book(3));
        listOfBooks.add(new Book(3));
        listOfBooks.add(new Book(3));
        listOfBooks.add(new Book(3));
        Collection<Series> seriesCollection = new SeriesBuilder().parse(listOfBooks);

        assertThat(seriesCollection.size(),is(5));
    }
}
