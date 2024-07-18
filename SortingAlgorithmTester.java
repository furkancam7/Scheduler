import java.util.Random;


public class SortingAlgorithmTester {
    public static void main(String[] args) {
        Random random = new Random();
        long studentID = 1119400531L; 

        // Test array generation and sorting algorithm with ascending, descending, and random arrays
        for (int size = 10000; size <= 1000000; size += 10000) {
            testArrayGenerationAndSorting("Ascending", size, studentID, random);
            testArrayGenerationAndSorting("Descending", size, studentID, random);
            testArrayGenerationAndSorting("Random", size, studentID, random);
        }
    }
    /**
     * Test the generation of an array and sorting algorithm for a specific type of array.
     * @param type The type of array (Ascending, Descending, or Random).
     * @param size The size of the array to be generated and sorted.
     * @param studentID The student ID for sorting algorithm verification.
     * @param random The Random object for generating random numbers.
     */
    public static void testArrayGenerationAndSorting(String type, int size, long studentID, Random random) {
        // Generate array and measure generation time
        long startTime = System.nanoTime();
        int[] array = generateArray(type, size, random);
        long endTime = System.nanoTime();
        long generationTime = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds

        // Print array generation time and size
        System.out.println(type + " array generation time (" + size + " elements): " );

        // Test sorting algorithm
        testSortingAlgorithm(array, studentID);
    }
    /**
     * Test a sorting algorithm with the given array.
     * @param array The array to be sorted.
     * @param studentID The student ID for sorting algorithm verification.
     */
    public static void testSortingAlgorithm(int[] array, long studentID) {

            // This method sorts the given array using sorting algorithms and measures
            // the execution times of each algorithm.

            long startTime, endTime;
            long[] executionTimes = new long[5]; // Array to store execution times of each algorithm

            // QuickSort
            startTime = System.currentTimeMillis();
            SortingAlgorithms.sort1(array, studentID); // Sort the given array with QuickSort
            endTime = System.currentTimeMillis();
            executionTimes[0] = endTime - startTime; // Record the execution time of QuickSort

            // MergeSort
            startTime = System.currentTimeMillis();
            SortingAlgorithms.sort2(array, studentID); // Sort the given array with MergeSort
            endTime = System.currentTimeMillis();
            executionTimes[1] = endTime - startTime; // Record the execution time of MergeSort

            // Insertion Sort
            startTime = System.currentTimeMillis();
            SortingAlgorithms.sort3(array, studentID); // Sort the given array with Insertion Sort
            endTime = System.currentTimeMillis();
            executionTimes[2] = endTime - startTime; // Record the execution time of Insertion Sort

            // Bubble Sort
            startTime = System.currentTimeMillis();
            SortingAlgorithms.sort4(array, studentID); // Sort the given array with Bubble Sort
            endTime = System.currentTimeMillis();
            executionTimes[3] = endTime - startTime; // Record the execution time of Bubble Sort

            // Selection Sort
            startTime = System.currentTimeMillis();
            SortingAlgorithms.sort5(array, studentID); // Sort the given array with Selection Sort
            endTime = System.currentTimeMillis();
            executionTimes[4] = endTime - startTime; // Record the execution time of Selection Sort

            // Print or analyze execution times for each sorting algorithm
            for (int i = 0; i < executionTimes.length; i++) {
                System.out.println("Execution time for sort" + (i + 1) + ": " + executionTimes[i] + " milliseconds");
            }

            // Find the sorting algorithm with the lowest execution time
            int minIndex = 0;
            long minTime = executionTimes[0];
            for (int i = 1; i < executionTimes.length; i++) {
                if (executionTimes[i] < minTime) {
                    minIndex = i;
                    minTime = executionTimes[i];
                }
            }

            // Make a guess about which sorting algorithm is being used
        String guessedAlgorithm;
        switch (minIndex) {
            case 0:
                guessedAlgorithm = "QuickSort"; // If the fastest algorithm is QuickSort, assign its name to guessedAlgorithm
                break;
            case 1:
                guessedAlgorithm = "MergeSort"; // If the fastest algorithm is MergeSort, assign its name to guessedAlgorithm
                break;
            case 2:
                guessedAlgorithm = "Insertion Sort"; // If the fastest algorithm is Insertion Sort, assign its name to guessedAlgorithm
                break;
            case 3:
                guessedAlgorithm = "Bubble Sort"; // If the fastest algorithm is Bubble Sort, assign its name to guessedAlgorithm
                break;
            case 4:
                guessedAlgorithm = "Selection Sort"; // If the fastest algorithm is Selection Sort, assign its name to guessedAlgorithm
                break;
            default:
                guessedAlgorithm = "Unknown"; // If none of the algorithms are the fastest (unlikely scenario), set guessedAlgorithm to "Unknown"
        }

        System.out.println("Guessed algorithm for this sort: " + guessedAlgorithm); // Print out the guessed algorithm name
        System.out.println();



        }

    /**
     * Generates an array based on the specified type and size.
     *
     * @param type   The type of array to generate ("Ascending", "Descending", or "Random").
     * @param size   The size of the array to generate.
     * @param random The Random object for generating random numbers.
     * @return The generated array.
     */
    public static int[] generateArray(String type, int size, Random random) {
        switch (type) {
            case "Ascending":
                return generateAscendingArray(size); // Call generateAscendingArray method if type is "Ascending"
            case "Descending":
                return generateDescendingArray(size); // Call generateDescendingArray method if type is "Descending"
            case "Random":
                return generateRandomArray(size, random);// Call generateRandomArray method if type is "Random"
            default:
                return new int[0]; // Return an empty array if type is unknown
        }
    }
    /**
     * Generate an ascending array of the specified size.
     * @param size The size of the array to be generated.
     * @return The generated ascending array.
     */
    public static int[] generateAscendingArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }
    /**
     * Generate a descending array of the specified size.
     * @param size The size of the array to be generated.
     * @return The generated descending array.
     */
    public static int[] generateDescendingArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - i;
        }
        return array;
    }
    /**
     * Generate a random array of the specified size.
     * @param size The size of the array to be generated.
     * @param random The Random object for generating random numbers.
     * @return The generated random array.
     */
    public static int[] generateRandomArray(int size, Random random) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }
}
