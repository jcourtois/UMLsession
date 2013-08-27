import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class PackageTest {

    @Test
    public void canAddBookToPackage(){
        assertTrue(new Series().tryToAddBook(new Book(1)));
    }

    @Test
    public void cantAddMoreThanOneOfTheSameBookToPackage() {
        Series series = new Series();
        series.tryToAddBook(new Book(1));
        series.tryToAddBook(new Book(1));
        series.tryToAddBook(new Book(1));
        assertThat(series.numberOfBooks(), is(1));
    }

    @Test
    public void ifThereIsOneBookTheDiscountIsZeroPercent() {
        Series series = getPackageWithNDifferentBooks(1);
        assertThat(series.numberOfBooks(),is(1));

        assertThat(series.getDiscount(),is(0.00));
    }

    @Test
    public void ifThereAreTwoBooksTheDiscountIsFivePercent() {
        Series series = getPackageWithNDifferentBooks(2);
        assertThat(series.numberOfBooks(), is(2));

        assertThat(series.getDiscount(),is(0.05));
    }

    @Test
    public void ifThereAreThreeBooksTheDiscountIsTenPercent() {
        Series series = getPackageWithNDifferentBooks(3);
        assertThat(series.numberOfBooks(), is(3));

        assertThat(series.getDiscount(),is(0.10));
    }

    @Test
    public void ifThereAreFourBooksTheDiscountIsTwentyPercent() {
        Series series = getPackageWithNDifferentBooks(4);
        assertThat(series.numberOfBooks(), is(4));

        assertThat(series.getDiscount(),is(0.20));
    }

    @Test
    public void ifThereAreFiveBooksTheDiscountIsTwentyFivePercent() {
        Series series = getPackageWithNDifferentBooks(5);
        assertThat(series.numberOfBooks(), is(5));

        assertThat(series.getDiscount(),is(0.25));
    }

    @Test
    public void ifThereAreZeroBooksTheDiscountIsZero() {
        Series series = new Series();

        assertThat(series.getDiscount(),is(0.00));
    }

    @Test
    public void thePriceForFourDifferentBooksShouldBeTwentyFivePointSix() {
        Series series = getPackageWithNDifferentBooks(4);
        assertThat(series.getPrice(), is(25.6));
    }

    private Series getPackageWithNDifferentBooks(int number) {
        Series series = new Series();
        for(int i=1; i<=number; i++)
            series.tryToAddBook(new Book(i));
        return series;
    }
}
