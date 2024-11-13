package KI304.Pelekh.Lab5;

import java.io.*;

public class FileHandler {
    
    /**
     * Method to write calculation result to a text file.
     * @param fileName name of the file where the result will be saved
     * @param result the result of the equation to be saved
     */
    public void writeToTextFile(String fileName, double result) throws IOException {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter(fileName));
            writer.println(result);
        } finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }
    }

    /**
     * Method to read calculation result from a text file.
     * @param fileName name of the file from which the result will be read
     * @return the result read from the file
     */
    public double readFromTextFile(String fileName) throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            return Double.parseDouble(reader.readLine());
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    /**
     * Method to write calculation result to a binary file.
     * @param fileName name of the file where the result will be saved
     * @param result the result of the equation to be saved
     */
    public void writeToBinaryFile(String fileName, double result) throws IOException {
        DataOutputStream dataOut = null;
        try {
            dataOut = new DataOutputStream(new FileOutputStream(fileName));
            dataOut.writeDouble(result);
        } finally {
            if (dataOut != null) {
                dataOut.flush();
                dataOut.close();
            }
        }
    }

    /**
     * Method to read calculation result from a binary file.
     * @param fileName name of the file from which the result will be read
     * @return the result read from the file
     */
    public double readFromBinaryFile(String fileName) throws IOException {
        DataInputStream dataIn = null;
        try {
            dataIn = new DataInputStream(new FileInputStream(fileName));
            return dataIn.readDouble();
        } finally {
            if (dataIn != null) {
                dataIn.close();
            }
        }
    }
}
