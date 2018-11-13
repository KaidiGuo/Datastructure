package de.tu_berlin.summertu_2017.java.catalog;

/**
 * Parent class of the items of the catalogue.
 *
 * @author <a href="mailto:gruemme@math.tu-berlin.de">Christian Gruemme</a>
 * @since 2017-6-29
 */
public class Item {

    public String name;
    public String description;

    public Item(String n) {
        this.name = n;
        this.description = "It is a " + n;
    }

    public int totalPrice() {
        return 0;
    }

    public boolean matchesTerm(String term) {
        return (name.contains(term)
                || description.contains(term));
    }

    public void print() {
        System.out.println(name + "\t" + totalPrice());
    }
}
