
import java.util.Scanner;

/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * This class contains the Menu and main methods
 * Student Name: Brayden Johnston
 * Student Number: 041079392
 * Section #: 303
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD. 
 * 
 */
public class Lab1 {
	
	/**
	 * This method displays a menu of options and returns the user's choice.
	 * 
	 * @param options - The options to display on the menu
	 * @return The user's menu choice as an integer
	 */
	private static int displayMainMenu(String... options) {
		Scanner input = new Scanner(System.in);
		
		while (true) {
			// Display options
			for (int i = 0; i < options.length; i++) {
				System.out.printf("\t%d. %s%n", i + 1, options[i]);
			}

			System.out.print("Select action: ");
			String choice = input.nextLine();

			try {
				int choiceNum = Integer.parseInt(choice);

				// Check if choice is within range
				if (choiceNum < 1 || choiceNum > options.length) {
					throw new Exception();
				}

				return choiceNum;
			} catch (NumberFormatException e) {
				System.out.println("\nEnter an integer.");
			} catch (Exception e) {
				System.out.println("\nEnter a number within range.");
			}
		}
	}
	
	/**
	 * The main method for the program.
	 *
	 * @param args - Command line arguments (not used)
	 */
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    Numbers numbers = null;
	    boolean exit = false;

	    while (!exit) {
	        // Display main menu and get user's choice
	        System.out.print("\nPlease select one of the following: \n");
	        int choice = displayMainMenu(
	            "Initialize a default array",
	            "To specify the max size of the array",
	            "Add value to the array",
	            "Display values in the array",
	            "Display average of the values, minimum value, maximum value, max mod min",
	            "Enter multiple values",
	            "Read values from file",
	            "Save values to file",
	            "To Exit"
	        );

	        switch (choice) {
	            case 1: // Initialize a default array
	                numbers = new Numbers();
	                break;
	            case 2: // To specify the max size of the array
	                System.out.print("Enter the maximum size of the array: ");
	                String size = input.nextLine();
	                try {
	                    int sizeNum = Integer.parseInt(size);
	                    if(sizeNum > 0) {
	                    numbers = new Numbers(sizeNum);
	                    }else {
	                    	System.out.println("Enter a positive integer.");
	                    }
	                } catch (NumberFormatException e) {
	                    System.out.println("\nEnter an integer.");
	                }
	                break;
	            case 3: // Add value to the array
	                if (numbers == null) {
	                    System.out.println("Array not initialized.");
	                } else {
	                    System.out.print("Enter a float value: ");
	                    try {
	                        float value = input.nextFloat();
	                        numbers.addValue(value);
	                    } catch (Exception e) {
	                        System.out.println("Invalid input. Please enter a float value.");
	                    }
	                    input.nextLine(); // consume the newline character
	                }
	                break;
	            case 4: // Display values in the array
	                if (numbers == null) {
	                    System.out.println("Array not initialized.");
	                } else {
	                    System.out.print("Numbers are: \n");
	                    System.out.println(numbers.toString());
	                }
	                break;
	            case 5: // Display average, minimum, maximum, and mod values
	                if (numbers == null) {
	                    System.out.println("Array not initialized.");
	                } else if(numbers.getNumItems() > 0) {
	                    float average = numbers.calcAverage();
	                    float[] minMax = numbers.findMinMax();
	                    int factorial = numbers.getfactorialMax();
	                    System.out.printf("Average: %.2f\n", average);
	                    System.out.printf("Minimum value: %.2f\n", minMax[0]);
	                    System.out.printf("Maximum value: %.2f\n", minMax[1]);
	                    System.out.printf("Max mod min: %.2f\n", minMax[2]);
	                    System.out.printf("Factorial of the maximum value in the array: %d\n", factorial);
	                } else {
	                	System.out.println("Please enter values into the array before using this option.");
	                }
	                break;
	            case 6: // Enter multiple values
	                if (numbers == null) {
	                    System.out.println("Array not initialized.");
	                } else {
	                    System.out.println("How many values do you wish to add? ");
	                    String numValues = input.nextLine();
	                    try {
	                        int intValues = Integer.parseInt(numValues);
	                        boolean valueSize = numbers.checkSize(intValues);
	                        if (valueSize) {
	                            for (int i = 0; i < intValues; i++) {
	                                System.out.print("Enter a float value: ");
	                                try {
	                                    float value = input.nextFloat();
	                                    numbers.addValue(value);
	                                } catch (Exception e) {
	                                    System.out.println("Invalid input. Please enter a float value.");
	                                }
	                                input.nextLine(); // Consume newline character
									}
								}else {
									System.out.println("No room in array to add all values");
								}
							}catch(Exception e) {
								System.out.println("Invalid input. Please enter a integer value.");
							}
							}

						break;
					case 7: // Read values from a file
						if (numbers == null) {
							System.out.println("Array not initialized.");
							} else {
							Lab2.readValuesFromFile(numbers, input);
							}
						break;
					case 8: // Save values from the array to a file
						if (numbers == null) {
							System.out.println("Array not initialized.");
							} else {
							Lab2.saveValuesToFile(numbers, input);
							}
							break;
		                    
					case 9: // Exit
						exit = true;
						break;
			}
		}
		System.out.print("Exiting...");
	}
}

	

