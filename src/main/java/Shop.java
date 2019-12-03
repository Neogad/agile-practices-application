import java.util.ArrayList;
import java.util.List;

public class Shop {
    public static List getAllItems(String filter) {
        if (filter == "") {
            throw new IllegalArgumentException("filter MUST NOT be null");
        }

        List storeAllItems = getStoreItems();
        List promoItems = getPromoItems();
        storeAllItems.addAll(promoItems);

        return storeAllItems;
    }

    private static List getStoreItems() {
        List storeItems = new ArrayList();

        Item testItem = new Item(1, "sweeter");

        storeItems.add(testItem);
        return storeItems;
    }

    private static List getPromoItems() {
        List promoItems = new ArrayList();

        Item testItem = new Item(2, "shapka");

        promoItems.add(testItem);
        return promoItems;
    }
}

class Item {
    public int id;
    public String name;

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;

        Item item = (Item) o;

        if (id != item.id) return false;
        return name != null ? name.equals(item.name) : item.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "{" + id + ", " + name + "}";
    }
}