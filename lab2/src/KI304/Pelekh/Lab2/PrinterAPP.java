package KI304.Pelekh.Lab2;

import java.io.FileNotFoundException;
import java.io.IOException; // Додайте цей імпорт

public class PrinterAPP {
    public static void main(String[] args) {
        try {
            Printer printer = new Printer("HP LaserJet", 100, 100);

            printer.printDocument(10, 10);
            printer.addPaper(20);
            printer.printDocument(5, 5);
            printer.refillInk();

            System.out.println("Current ink level: " + printer.checkInkLevel() + "%");
            System.out.println("Current paper level: " + printer.checkPaperLevel() + " sheets");

            printer.dispose(); // Закриття лог-файлу
        } catch (FileNotFoundException e) {
            System.err.println("Error initializing printer: " + e.getMessage());
        } catch (IOException e) { // Додайте обробку IOException
            System.err.println("I/O error: " + e.getMessage());
        }
    }
}