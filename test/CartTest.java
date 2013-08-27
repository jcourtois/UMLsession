import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CartTest {

    @Test
    public void shouldBeAbleToAddOneBookToCart() {
        Cart cart = new Cart();
        assertTrue(cart.add(new Book(1)));
    }

    @Test
    public void theExampleShouldCostFiftyOneSixty() {
        Cart cart = new Cart();
        cart.add(new Book(1));
        cart.add(new Book(1));
        cart.add(new Book(2));
        cart.add(new Book(2));
        cart.add(new Book(3));
        cart.add(new Book(3));
        cart.add(new Book(4));
        cart.add(new Book(5));
        assertThat(cart.getPrice(),is(51.60));
    }

}
