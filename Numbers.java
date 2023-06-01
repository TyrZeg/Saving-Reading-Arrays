/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Brayden Johnston
 * Student Number: 041079392
 * Section #: 303
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD. 
 * 
 */

public class Numbers {
    /**
     * Stores Float values.
     */
    private Float[] numbers;
    /**
     * Store the number of items currently in the array.
     */
    private int numItems;

    /**
     * Default Constructor
     */
    public Numbers() {
        this.numbers = new Float[10];  // Initialize the numbers array with a default size of 10
        this.numItems = 0; 
    }
    

    /**
     * Constructor that initializes the numbers array.
     *
     * @param size - Max size of the numbers array
     */
    public Numbers(int size) {
        this.numbers = new Float[size];  // Initialize the numbers array with the specified size
        this.numItems = 0;  
    }
    
    //Getters
    
    /**
     * Returns the number of items in the array.
     *
     * @return The number of items in the array.
     */
    public int getNumItems() {
        return numItems;
    }

    /**
     * Returns the value at the specified index in the array.
     *
     * @param index The index of the value to retrieve.
     * @return The value at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public Float getNumber(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < numItems) {
            return numbers[index];
        } else {
            throw new IndexOutOfBoundsException("Invalid index.");
        }
    }

    //
    
    /**
     * Adds a value in the array
     *
     * @param value - float value to be added to the array
     */
    public void addValue(float value) {
        if (numItems < numbers.length) {
            numbers[numItems] = value;  // Add the value to the next available index in the numbers array
            numItems++;  // Increment the count of items in the array
        } else {
            System.out.println("Array is full.");  // If the array is already full, print an error message
        }
    }

    /**
     * Calculates the average of all the values in the numbers array.
     *
     * @return float value that represents the average
     */
    public float calcAverage() {
        float sum = 0;
        for (int i = 0; i < numItems; i++) {
            sum += numbers[i];  // Add up all the values in the numbers array
        }
        float average = sum / numItems;  // Calculate the average by dividing the sum by the number of items
        return Math.round(average * 100.0f) / 100.0f;  // Round the average to two decimal places and return it
    }

    /**
     * Returns the minimum and maximum values in the array, and the result of MaxValue modulo MinValue
     *
     * @return an array of float values containing the minimum, maximum, and modulo values respectively
     */
    public float[] findMinMax() {
        if (numItems == 0) {
            return null;  // If the array is empty, return null
        }
		
        float min = numbers[0];  // Assume the first element as the minimum
        float max = numbers[0];  // Assume the first element as the maximum
        for (int i = 1; i < numItems; i++) {
            if (numbers[i] < min) {
                min = numbers[i];  // Update the minimum if a smaller value is found
            }
            if (numbers[i] > max) {
                max = numbers[i];  // Update the maximum if a larger value is found
            }
        }
        float modResult = max % min;  // Calculate the mod of the maximum and minimum values

        float[] result = new float[3];  // Create a float array to store the minimum, maximum, and mod values
        result[0] = min;
        result[1] = max;
        result[2] = modResult;

        return result;  // Return the array with the minimum, maximum, and mod values
    }

    /**
     * Returns the factorial of the maximum value in the array, rounded down to the nearest
	integer.
     *
     * @return the factorial of the maximum value in the array
	*/
    public int getfactorialMax() {
    	if (numItems == 0) {
    		return -1; 
    	}
        int maxIndex = 0;
        for (int i = 1; i < numItems; i++) {
            if (numbers[i] > numbers[maxIndex]) {
                maxIndex = i;  // Find the index of the maximum value in the array
            }
        }

        int maxValue = (int) Math.floor(numbers[maxIndex]);  // Get the maximum value and round it down to the nearest integer
        int factorial = 1;
        for (int i = 2; i <= maxValue; i++) {
            factorial *= i;  // Calculate the factorial of the maximum value
        }

        return factorial;  // Return 
    }

    /**
     * Checks if the specified number of values can be added to the array without exceeding its capacity.
     *
     * @param intValues The number of values to be added.
     * @return {@code true} if the specified number of values can be added, {@code false} otherwise.
     */
    public boolean checkSize(int intValues) {
        boolean valueSize = false;
        if (intValues <= numbers.length - numItems) {
            valueSize = true;
        }
        return valueSize;
    }

    /**
     * Returns a string representation of the Numbers object.
     *
     * @return The string representation of the Numbers object.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numItems; i++) {
            sb.append(i + 1).append(". ").append(numbers[i]).append("\n");
        }
        return sb.toString();
    }
}


