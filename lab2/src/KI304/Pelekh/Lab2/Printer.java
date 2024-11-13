package KI304.Pelekh.Lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

//Поля (змінні класу):
	
public class Printer {
    private String model;
    private int inkLevel;
    private int paperLevel;
    private PrintWriter fout;

    //Конструктор:
    public Printer(String model, int inkLevel, int paperLevel) throws FileNotFoundException {
        this.model = model;
        this.inkLevel = inkLevel;
        this.paperLevel = paperLevel;
        this.fout = new PrintWriter(new File("printer.txt")); // Ініціалізація PrintWriter
        log("Принтер ініційовано: " + model);
    }

    public void printDocument(int pages, int copies) {
        if (inkLevel <= 0 || paperLevel <= 0) {
            log("Не можна надрукувати. Перевірте рівень чорнила та паперу.");
            return;
        }
        log("Друкуємо " + copies + " копій по " + pages + " сторінок.");
        inkLevel -= pages * copies; // Зменшити рівень чорнила
        paperLevel -= pages * copies; // Зменшити рівень паперу
        log("Надруковано " + (pages * copies) + " сторінок. Залишок чорнила: " + inkLevel + ", Залишок паперу: " + paperLevel);
    }

    public void addPaper(int sheets) {
        paperLevel += sheets;
        log("Додано " + sheets + " аркушів паперу. Поточний рівень паперу: " + paperLevel);
    }

    public void refillInk() {
        inkLevel = 100; // Встановлюємо чорнило на максимальний рівень
        log("Чорнило поповнено. Поточний рівень чорнила: " + inkLevel);
    }

    public int checkInkLevel() {
        return inkLevel;
    }

    public int checkPaperLevel() {
        return paperLevel;
    }

    public void dispose() {
        log("Закриваємо ресурси принтера.");
        fout.close(); // Закриття лог-файлу
    }

    private void log(String message) {
        System.out.println(message); // Виводимо в консоль
        fout.println(message); // Записуємо в файл
        fout.flush(); // Скидання буфера
    }
}