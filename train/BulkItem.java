package de.tu_berlin.summertu_2017.java.catalog;

/**
 * Bulk item.
 *
 * @author <a href="mailto:gruemme@math.tu-berlin.de">Christian Gruemme</a>
 * @since 2017-6-29
 */
public class BulkItem extends Item {

    public int unit_price;
    public int standard_unit_number;

    public BulkItem(String n, int unit_price, int standard_unit_number) {
        super(n);
        this.unit_price = unit_price;
        this.standard_unit_number = standard_unit_number;
    }

    public int totalPrice() {
        return unit_price * standard_unit_number;
    }
}
