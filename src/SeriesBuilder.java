import java.util.*;

public class SeriesBuilder {

    private boolean addBookWasSuccessful;
    private Iterator<Series> seriesIterator;
    private Set<Series> seriesSet;

    public Collection<Series> parse(List<Book> listOfBooks) {
        seriesSet = getNewSeriesSet();

        for(Book book : listOfBooks) {
            haveNotAddedBookToPackageYet();
            getNewSeriesIterator();

            while (thereIsAnotherSeries()) {
                tryToAddBookToNextSeries(book);
                if(addBookWasSuccessful)
                    break;
            }
            if(addBookWasNotSuccessful())
                seriesSet.add(bookToNewSeries(book));
        }
        return seriesSet;
    }

    private void haveNotAddedBookToPackageYet() {
        addBookWasSuccessful = false;
    }

    private boolean addBookWasNotSuccessful() {
        return !addBookWasSuccessful;
    }

    private void tryToAddBookToNextSeries(Book book) {
        addBookWasSuccessful = nextSeries().tryToAddBook(book);
    }

    private Series bookToNewSeries(Book book) {
        Series newSeries = new Series();
        newSeries.tryToAddBook(book);
        return newSeries;
    }

    private LinkedHashSet<Series> getNewSeriesSet() {
        LinkedHashSet<Series> seriesSet = new LinkedHashSet<Series>();
        seriesSet.add(new Series());
        return seriesSet;
    }

    private boolean thereIsAnotherSeries() {
        return seriesIterator.hasNext();
    }

    private void getNewSeriesIterator() {
        seriesIterator = seriesSet.iterator();
    }

    private Series nextSeries() {
        return seriesIterator.next();
    }
}
