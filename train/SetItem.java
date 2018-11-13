package de.tu_berlin.summertu_2017.java.catalog;

/**
 * Set item consisting ot two SingleItems.
 *
 * @author <a href="mailto:gruemme@math.tu-berlin.de">Christian Gruemme</a>
 * @since 2017-6-29
 */
public class SetItem extends Item {

    public int priceofTheSet;

    public SetItem(SingleItem item1, SingleItem item2, int priceofTheSet) {
        super("Set of one " + item1.name + " and one " + item2.name);
        description = item1.description + " " + item2.description;
        this.priceofTheSet = priceofTheSet;
    }

    public int totalPrice() {
        return this.priceofTheSet;
    }
}
