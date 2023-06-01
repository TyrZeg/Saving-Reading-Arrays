
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * This class contains the file read and file save methods
 * Student Name: Brayden Johnston
 * Student Number: 041079392
 * Section #: 303
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD. 
 * 
 */
public class Lab2 {
    /**
     * Reads values from a file and adds them to the array.
     *
     * @param numbers  The Numbers object to add values to
     * @param scanner  The Scanner object for file input
     */
    public static void readValuesFromFile(Numbers numbers, Scanner scanner) {
        System.out.print("Enter the filename: ");
        String filename = scanner.nextLine();

        try {
            File file = new File(filename);
            Scanner fileScanner = new Scanner(file);

            if (fileScanner.hasNextInt()) {
                int numFloats = fileScanner.nextInt();  // Read the number of floats from the first line of the file
                fileScanner.nextLine(); // Consume the newline character

                boolean numSize = numbers.checkSize(numFloats);  // Check if there is enough room in the array to add the values
                if (numSize) {
                    for (int i = 0; i < numFloats; i++) {
                        if (fileScanner.hasNextFloat()) {
                            float value = fileScanner.nextFloat();  // Read a float value from the file
                            numbers.addValue(value);  // Add the value to the numbers object
                        } else {
                            System.out.println("Invalid value in the file. Skipping.");
                            fileScanner.nextLine(); // Skip the invalid line
                        }
                    }
                    System.out.println("Values read from file successfully.");
                } else {
                    System.out.println("No room in array to add all values");
                }
            } else {
                System.out.println("Invalid file format. First line should contain the number of floats.");
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    /**
     * Saves the current values to a file.
     *
     * @param numbers  The Numbers object to save values from
     * @param scanner  The Scanner object for file input
     */
    public static void saveValuesToFile(Numbers numbers, Scanner scanner) {
        System.out.print("Enter the filename: ");
        String filename = scanner.nextLine();

        try {
            FileWriter fileWriter = new FileWriter(filename);

            fileWriter.write(numbers.getNumItems() + "\n");  // Write the 1number of items in the numbers object as the first line of the file

            for (int i = 0; i < numbers.getNumItems(); i++) {
                fileWriter.write(numbers.getNumber(i) + "\n");  // Write each value from the Numbers object to the file, one value per line
            }

            fileWriter.close();

            System.out.println("Values saved to file successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }
}

