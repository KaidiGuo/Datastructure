package de.tu_berlin.summertu_2017.java.catalog;

/**
 * Single item.
 *
 * @author <a href="mailto:gruemme@math.tu-berlin.de">Christian Gruemme</a>
 * @since 2017-6-29
 */
public class SingleItem extends Item {

    public int price;

    public SingleItem(String n, int price) {
        super(n);
        this.price = price;
    }

    public int totalPrice() {
        return this.price;
    }
}
