package KI304.Pelekh.Lab3;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Головний клас для демонстрації роботи принтера.
 */
public class PrinterAPP {
    public static void main(String[] args) {
        try {
            LaserPrinter printer = new LaserPrinter("HP LaserJet", 100, 100);

            printer.printDocument(10, 10);
            printer.addPaper(20);
            printer.printDocument(5, 5);
            printer.refillInk();

            System.out.println("Current ink level: " + printer.checkInkLevel() + "%");
            System.out.println("Current paper level: " + printer.checkPaperLevel() + " sheets");

            printer.connectToNetwork();

            printer.dispose(); // Закриття лог-файлу
        } catch (FileNotFoundException e) {
            System.err.println("Error initializing printer: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        }
    }
}
