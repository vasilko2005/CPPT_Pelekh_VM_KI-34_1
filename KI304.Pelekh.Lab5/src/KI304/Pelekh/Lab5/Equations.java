package KI304.Pelekh.Lab5;


class Equations {
	
public double calculate(double x) throws CalcException {
    double y, numerator, denominator;  // Оголошуємо змінні для чисельника, знаменника та результату.

    try {
        // Обчислюємо чисельник: cot(x) = 1/tan(x)
        numerator = 1.0 / Math.tan(x);  // Використовуємо Math.tan() для обчислення тангенса і беремо обернене значення.

        // Обчислюємо знаменник: sin(2x) + 4*cos(x)
        denominator = Math.sin(2 * x) + 4 * Math.cos(x);  // Обчислюємо синус 2x та 4 помножити на косинус x.

        // Перевіряємо, чи не дорівнює знаменник нулю.
        if (denominator == 0) {
            throw new ArithmeticException();  // Генеруємо виключення, якщо знаменник дорівнює нулю.
        }

      
        y = numerator / denominator;

       
        if (Double.isNaN(y) || Double.isInfinite(y)) {
            throw new ArithmeticException();  // Генеруємо виняток, якщо результат некоректний (NaN або нескінченність).
        }

    } catch (ArithmeticException ex) {
        
        throw new CalcException("Exception reason: Invalid value of X for calculation.");
    }

    return y;  // Повертаємо результат обчислення.
    
}
}