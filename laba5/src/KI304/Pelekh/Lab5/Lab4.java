package KI304.Pelekh.Lab5;  
import java.util.Scanner;  
import java.io.*;  
import static java.lang.System.out; 

/**
 * Class <code>EquationsApp</code> implements driver for Equations class
 * @author Ваше Прізвище
 * @version 1.0
 */
public class Lab4 {
    /**
     * Main method to execute the program
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            out.print("Enter file name: ");  
            Scanner in = new Scanner(System.in);  
            String fName = in.nextLine();  
            PrintWriter fout = new PrintWriter(new File(fName));  
            try {
                try {
                    Equations eq = new Equations(); 
                    out.print("Enter X: ");  
                    double x = in.nextDouble();  
                    fout.print(eq.calculate(x));  
                } finally {
                   
                    fout.flush(); 
                    fout.close();  
                }
            } catch (CalcException ex) {
                
                out.print(ex.getMessage());  
            }
        } catch (FileNotFoundException ex) {
            
            out.print("Exception reason: Perhaps wrong file path");  
        }
    }
}