package KI304.Pelekh.Lab6;

import java.util.ArrayList;


public class Safe<T extends Data> {
    private ArrayList<T> items;

    /**
     * Constructor to initialize the safe with an empty list.
     */
    public Safe() {
        items = new ArrayList<>();
    }

    /**
     * Adds an item to the safe.
     * @param item The item to be added.
     */
    public void addItem(T item) {
        items.add(item);
        System.out.println("Added item:");
        item.print();
    }

    /**
     * Removes an item from the safe by its index.
     * @param index Index of the item to be removed.
     */
    public void removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            System.out.println("Removed item:");
            items.get(index).print();
            items.remove(index);
        } else {
            System.out.println("Invalid index.");
        }
    }

    /**
     * Finds the maximum element based on size.
     * @return The maximum element, or null if the safe is empty.
     */
    public T findMax() {
        if (items.isEmpty()) {
            return null;
        }

        T max = items.get(0);
        for (T item : items) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }

    /**
     * Finds the minimum element based on size.
     * @return The minimum element, or null if the safe is empty.
     */
    public T findMin() {
        if (items.isEmpty()) {
            return null;
        }

        T min = items.get(0);
        for (T item : items) {
            if (item.compareTo(min) < 0) {
                min = item;
            }
        }
        return min;
    }

    /**
     * Prints all items in the safe.
     */
    public void printAll() {
        for (T item : items) {
            item.print();
        }
    }
}

/**
 * Interface representing data items that can be stored in the safe.
 */
interface Data extends Comparable<Data> {
    int getSize();
    void print();
}




































