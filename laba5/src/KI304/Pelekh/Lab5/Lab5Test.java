package KI304.Pelekh.Lab5;

import java.io.IOException;
import java.util.Scanner;

public class Lab5Test {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Equations eq = new Equations();
        FileHandler fileHandler = new FileHandler();
        
        try {
            // Введення X
            System.out.print("Enter X: ");
            double x = scanner.nextDouble();
            
            // Обчислення результату
            double result = eq.calculate(x);
            System.out.println("Calculation result: " + result);

            // Запис результату в текстовий файл
            System.out.print("Enter text file name to save result: ");
            String textFileName = scanner.next();
            fileHandler.writeToTextFile(textFileName, result);
            System.out.println("Result saved to text file.");

            // Запис результату в бінарний файл
            System.out.print("Enter binary file name to save result: ");
            String binaryFileName = scanner.next();
            fileHandler.writeToBinaryFile(binaryFileName, result);
            System.out.println("Result saved to binary file.");

            // Читання результату з текстового файлу
            double textFileResult = fileHandler.readFromTextFile(textFileName);
            System.out.println("Result read from text file: " + textFileResult);

            // Читання результату з бінарного файлу
            double binaryFileResult = fileHandler.readFromBinaryFile(binaryFileName);
            System.out.println("Result read from binary file: " + binaryFileResult);

        } catch (CalcException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Error handling files: " + e.getMessage());
        }
    }
}
