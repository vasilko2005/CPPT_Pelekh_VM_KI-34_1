package KI304.Pelekh.Lab6;

import java.util.ArrayList;
/**
 * Main class to test the Safe with Document and Picture objects.
 */
class SafeDriver {
    public static void main(String[] args) {
        Safe<Data> safe = new Safe<>();

        // Add items to the safe
        safe.addItem(new Document("Passport", 123));
        safe.addItem(new Picture("HolidayPic", 65432));
        safe.addItem(new Document("Driver's License", 456));
        safe.addItem(new Picture("FamilyPic", 98765));

        System.out.println( "min"+ safe.findMin());
       
      

        // Remove and print an item
        safe.removeItem(2);

        // Print all remaining items
        safe.printAll();
    }
}
