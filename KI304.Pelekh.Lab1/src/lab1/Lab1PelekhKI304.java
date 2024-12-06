package lab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Клас Lab1PelekhVasilko генерує квадратну матрицю у формі ромба, заповнену заданим символом, та записує її у файл.
 * 
 * Користувач вводить розмір матриці (непарне число) і символ-заповнювач. Програма будує масив, що містить ромб,
 * симетрично заповнений обраним символом, та зберігає цей масив у файл "MyFile.txt".
 * 
 * Використання:
 * - Введіть непарний розмір квадратної матриці.
 * - Введіть символ-заповнювач.
 * 
 * Програма автоматично створить файл "MyFile.txt", в який буде записаний виведений ромб.
 * 
 * @version 1.1
 */
public class Lab1PelekhKI304 {
    
    /**
     * Точка входу до програми.
     * 
     * @param args аргументи командного рядка (не використовуються).
     * @throws FileNotFoundException якщо файл "MyFile.txt" не може бути створений або відкритий.
     */
    public static void main(String[] args) throws FileNotFoundException {
        int nRows; 
        char[][] arr; 
        char fillChar; 
        Scanner in = new Scanner(System.in);
        File dataFile = new File("MyFile.txt");
        PrintWriter fout = new PrintWriter(dataFile);

        System.out.print("Введіть розмір квадратної матриці (непарне число): ");
        if (!in.hasNextInt()) {
            System.out.println("Некоректний розмір матриці. Має бути додатнім непарним числом.");
            in.close();
            fout.close();
            return;
        }
        nRows = in.nextInt();
        in.nextLine(); 

        // Перевірка розміру матриці
        if (nRows <= 0 || nRows % 2 == 0) {
            System.out.println("Розмір матриці має бути додатнім непарним числом.");
            in.close();
            fout.close();
            return;
        }

        // Зчитування символу-заповнювача
        System.out.print("Введіть символ-заповнювач: ");
        String input = in.nextLine();
        if (input.length() != 1) {
            System.out.println("Необхідно ввести один символ.");
            in.close();
            fout.close();
            return;
        }
        fillChar = input.charAt(0);

        // Створення зубчатого масиву
        arr = new char[nRows][];
        int mid = nRows / 2; // Індекс середини матриці

        // Генерація верхньої половини зубчатого масиву
        for (int i = 0; i <= mid; i++) {
            arr[i] = new char[2 * i + 1 ]; // Довжина рядка - залежить від індексу
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = fillChar;  // Заповнення символами
            }
        }

        // Копіювання верхньої частини для заповнення нижньої половини масиву
        for (int i = mid + 1; i < nRows; i++) {
            arr[i] = arr[nRows - i - 1].clone(); // Симетричне відображення
        }

        // Заповнення центральної частини нулями
        for (int i = 0; i < nRows; i++) {
            int numZeros = arr[i].length / 2;
            
            }
        }

        // Виведення та запис масиву
        for (int i = 0; i < nRows; i++) {
            int padding = mid - (arr[i].length / 2); // Відступ для вирівнювання рядка
            for (int j = 0; j < padding; j++) {
                System.out.print("  ");
                fout.print("  ");
            }
            
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
                fout.print(arr[i][j] + " ");
            }
            System.out.print("\n");
            fout.print("\n");
        }

        // Закриття потоків
        fout.flush();
        fout.close();
        in.close();
    }
}