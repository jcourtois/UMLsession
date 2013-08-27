import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BookTest {
    @Test
    public void priceOfBookOneIsEight() {
        assertThat(new Book(1).getPrice(), is(Double.valueOf(8)));
    }

    @Test
    public void bookOneIsEqualToBookOne () {
        assertThat(new Book(1), is(new Book(1)));
    }


}
