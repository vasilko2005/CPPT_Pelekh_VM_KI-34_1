package KI304.Pelekh.Lab3;

import java.io.FileNotFoundException;

/**
 * Підклас для лазерного принтера, що розширює абстрактний клас Printer
 * та реалізує інтерфейс Printable.
 */
public class LaserPrinter extends Printer  implements Printable {

    /**
     * Конструктор класу LaserPrinter.
     *
     * @param model назва моделі принтера
     * @param inkLevel рівень чорнила
     * @param paperLevel рівень паперу
     * @throws FileNotFoundException якщо файл для логування не може бути створений
     */
    public LaserPrinter(String model, int inkLevel, int paperLevel) throws FileNotFoundException {
        super(model, inkLevel, paperLevel);
    }

    @Override
    public void printDocument(int pages, int copies) {
        if (inkLevel <= 0 || paperLevel <= 0) {
            log("Не можна надрукувати. Перевірте рівень чорнила та паперу.");
            return;
        }
        log("Друкуємо " + copies + " копій по " + pages + " сторінок.");
        inkLevel -= pages * copies;
        paperLevel -= pages * copies;
        log("Надруковано " + (pages * copies) + " сторінок. Залишок чорнила: " + inkLevel + ", Залишок паперу: " + paperLevel);
    }

    @Override
    public void connectToNetwork() {
        log("Принтер підключено до мережі.");
    }
}
