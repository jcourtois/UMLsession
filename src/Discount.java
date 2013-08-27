import java.util.HashMap;

public class Discount {

    private final HashMap<Integer,Double> discountMap;

    public Discount() {
        discountMap = new HashMap<Integer, Double>();
        discountMap.put(1, 0.00);
        discountMap.put(2, 0.05);
        discountMap.put(3, 0.10);
        discountMap.put(4, 0.20);
        discountMap.put(5, 0.25);
    }

    double getDiscountFor(Integer numberOfBooks) {
        if(discountMap.containsKey(numberOfBooks))
            return discountMap.get(numberOfBooks);
        return 0.00;
    }
}