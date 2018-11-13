package de.tu_berlin.summertu_2017.java.catalog;

/**
 * Start of the catalogue searcher.
 *
 * @author <a href="mailto:gruemme@math.tu-berlin.de">Christian Gruemme</a>
 * @since 2017-6-29
 */
public class CatalogueSearcher {

    public static Item[] generateCataloge() {
        Item[] cataloge = new Item[5];

        SingleItem singelItem1 = new SingleItem("Pine apple", 200);
        SingleItem singelItem2 = new SingleItem("Cocumber", 150);

        cataloge[0] = singelItem1;
        cataloge[1] = singelItem2;
        cataloge[2] = new BulkItem("Tomato", 250, 1);
        cataloge[3] = new BulkItem("Olive oil", 100, 5);
        cataloge[4] = new SetItem(singelItem1, singelItem2, 300);

        return cataloge;
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please give a search term");
            return;
        }
        String searchTerm = args[0];

        Item[] cataloge = generateCataloge();

        for (int i = 0; i < cataloge.length; ++i) {
            if (cataloge[i].matchesTerm(searchTerm)) {
                cataloge[i].print();
            }
        }

    }

}
