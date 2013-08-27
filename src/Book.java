public class Book {

    private final int seriesNumber;

    public Book(int seriesNumber) {
        this.seriesNumber = seriesNumber;
    }

    public double getPrice() {
        return 8;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        return seriesNumber == ((Book) o).seriesNumber;
    }

    @Override
    public int hashCode() {
        return seriesNumber;
    }
}
