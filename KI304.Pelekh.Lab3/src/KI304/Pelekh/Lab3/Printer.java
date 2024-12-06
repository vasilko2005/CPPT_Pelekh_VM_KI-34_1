package KI304.Pelekh.Lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Абстрактний клас, що представляє загальні властивості принтера.
 */
public abstract class Printer {
    protected String model;
    protected int inkLevel;
    protected int paperLevel;
    protected PrintWriter fout;

    /**
     * Конструктор класу Printer.
     *
     * @param model назва моделі принтера
     * @param inkLevel рівень чорнила
     * @param paperLevel рівень паперу
     * @throws FileNotFoundException якщо файл для логування не може бути створений
     */
    public Printer(String model, int inkLevel, int paperLevel) throws FileNotFoundException {
        this.model = model;
        this.inkLevel = inkLevel;
        this.paperLevel = paperLevel;
        this.fout = new PrintWriter(new File("printer_log.txt"));
        log("Принтер ініційовано: " + model);
    }

    /**
     * Абстрактний метод для друку документів.
     *
     * @param pages кількість сторінок
     * @param copies кількість копій
     */
    public abstract void printDocument(int pages, int copies);

    /**
     * Додає папір у принтер.
     *
     * @param sheets кількість доданих аркушів
     */
    public void addPaper(int sheets) {
        paperLevel += sheets;
        log("Додано " + sheets + " аркушів паперу. Поточний рівень паперу: " + paperLevel);
    }

    /**
     * Заправляє чорнило до максимального рівня.
     */
    public void refillInk() {
        inkLevel = 100;
        log("Чорнило поповнено. Поточний рівень чорнила: " + inkLevel);
    }

    /**
     * Перевіряє поточний рівень чорнила.
     *
     * @return рівень чорнила
     */
    public int checkInkLevel() {
        return inkLevel;
    }

    /**
     * Перевіряє поточний рівень паперу.
     *
     * @return кількість аркушів паперу
     */
    public int checkPaperLevel() {
        return paperLevel;
    }

    /**
     * Закриває лог-файл.
     */
    public void dispose() {
        log("Закриваємо ресурси принтера.");
        fout.close();
    }

    /**
     * Логування повідомлення у файл та консоль.
     *
     * @param message повідомлення для логування
     */
    protected void log(String message) {
        System.out.println(message);
        fout.println(message);
        fout.flush();
    }
}
