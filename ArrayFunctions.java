package pgdp.arrayfun;

import java.util.Arrays;

import java.util.ArrayList;

public class ArrayFunctions {

    protected ArrayFunctions() {
        throw new IllegalStateException("Don't create objects of type 'ArrayFunctions'!");
    }

    public static void main(String[] args) {
        //example call
        // Creating a two-dimensional array with three inner arrays
        int[][] arrayOfArrays = {
                {1, 4},
                {2, 5},
                {3, 6}
        };

        // Calling zipMany with the two-dimensional array
        System.out.println(Arrays.toString(zipMany(arrayOfArrays)));

        // The rest of your code
        // int[] a = {2, 3, 4};
        // System.out.println(sumOfSquares(a));

        // Other methods like zipMany and sumOfSquares should be here
        System.out.println(Arrays.toString(zip(new int[]{1, 5, 5, 5, 5}, new int[]{2, 4, 2, 3, 4})));
/*        int[] a = {2, 3, 4};
        System.out.println(sumOfSquares(a));*/

    }

    /**
     * Berechnet für das übergebene Array die Summe der Quadrate der Einträge.
     * Gibt dabei einen Fehler aus und -1 zurück, wenn ein Overflow entsteht.
     *
     * @param array Ein beliebiges Integer-Array.
     * @return Die Summe der Quadrate, wenn diese in einen 'long' passt, -1 sonst.
     */
    public static long sumOfSquares(int[] array) {
        // TODO
        long sum = 0L;

        if (array.length == 0) {
            sum = 0L;
            return sum;
        }

        /*checks for overflows in longs and ints*/
        for (int i = 0; i < array.length; i++) {

            /*long olduğu için hiçbir zmaman Long.MAX_VALUE'yu aşmaz zaten*/
            long square = (long) array[i] * (long) array[i];

            if (square > Long.MAX_VALUE - sum) {
                System.out.println("Overflow!");
                return -1;
            }
            sum = sum + square;
        }
        return sum;
    }


    /**
     * Methode, die zwei Arrays zu einem verbindet, indem sie abwechselnd Einträge des ersten und des zweiten Input-
     * Arrays verwendet.
     *
     * @param a Ein beliebiges Integer-Array.
     * @param b Ein beliebiges Integer-Array.
     * @return 'a' und 'b' zusammengezipped.
     */
    public static int[] zip(int[] a, int[] b) {
        int length = a.length + b.length;
        int[] zippedArray = new int[length];
        int indexA = 0, indexB = 0;

        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) { // Alternate starting with array a
                if (indexA < a.length) {
                    zippedArray[i] = a[indexA++];
                } else if (indexB < b.length) { // If a is exhausted, continue with b
                    zippedArray[i] = b[indexB++];
                }
            } else { // Alternate with array b
                if (indexB < b.length) {
                    zippedArray[i] = b[indexB++];
                } else if (indexA < a.length) { // If b is exhausted, continue with a
                    zippedArray[i] = a[indexA++];
                }
            }
        }

        return zippedArray;
    }


    /**
     * Methode, die eine beliebige Zahl an Arrays (dargestellt als Array von Arrays) zu einem einzigen Array verbindet,
     * indem sie abwechselnd von jedem Array einen Eintrag nimmt, bis alle aufgebraucht sind.
     *
     * @param arrays Array von Integer-Arrays
     * @return Die Arrays in 'arrays' zusammengezipped
     */
    public static int[] zipMany(int[][] arrays) {
        // Check if the input is an empty array of arrays. If so, return an empty array.
        if (arrays.length == 0) {
            return new int[0];
        }

        // Calculate the total length of all arrays combined. This will be the size of the zipped array.
        int totalLength = 0;

        /*The for (int[] array : arrays) loop is a shorthand way of iterating over each element in arrays. Here, array is a loop variable that represents one element (one inner array) from arrays during each iteration of the loop.
In each iteration, array takes the value of the next inner array from arrays. For our example arrays ([[1, 2], [3, 4, 5], [6]]), in the first iteration, array would be [1, 2], in the second iteration [3, 4, 5], and in the third iteration [6].*/
        for (int[] array : arrays) {

            /*mesela int [] array = 0 iken array.length indeksi 0 olan arrayın eleman sayısını verir*/
            totalLength += array.length;
        }

        // Create the zipped array with the total length.
        int[] zippedArray = new int[totalLength];

        // Create an array to keep track of the current index for each array in 'arrays'.
        int[] indices = new int[arrays.length];

        // This will be the index to insert elements into the zipped array.
        int zippedIndex = 0;

        // A flag to check if we are done zipping all arrays.
        boolean done = false;
        while (!done) {
            // Assume we are done until we find an array that still has elements to add.
            done = true;

            // Iterate through each array in 'arrays'.
            for (int i = 0; i < arrays.length; i++) {

                // Check if the current array has more elements to add.
                if (indices[i] < arrays[i].length) {
                    // Add the next element of the current array to the zipped array.
                    zippedArray[zippedIndex++] = arrays[i][indices[i]++];

                    // Since we've added an element, we are not done yet.
                    done = false;
                }
                // If the current array is exhausted, move to the next array.
            }
            // Continue the process until all arrays are exhausted.
        }

        // Return the zipped array containing elements from all arrays, added in order.
        return zippedArray;
    }


    /**
     * Behält aus dem übergebenen Array nur die Einträge, die innerhalb der übergebenen Grenzen liegen.
     * Gibt das Ergebnis als neues Array zurück.
     *
     * @param array Ein beliebiges Integer-Array
     * @param min   Ein beliebiger Integer
     * @param max   Ein beliebiger Integer
     * @return Das gefilterte Array
     */
    public static int[] filter(int[] array, int min, int max) {
        // TODO

        // First, check if the max value is less than the min value.
        // If so, return an empty array because no numbers can be within this range.
        if (max < min) {
            return new int[0];
        }

        // Create an ArrayList to hold the numbers that are within the specified range.
        // The ArrayList is used because we don't know the size of the resulting array beforehand.
        ArrayList<Integer> filteredList = new ArrayList<>();

        // Loop through each number in the input array.
        for (int number : array) {
            // Check if the current number is within the range [min, max] (inclusive).
            if (number >= min && number <= max) {
                // If the number is within the range, add it to the filtered list.
                filteredList.add(number);
            }
        }

        // Convert the ArrayList to an int array.
        // This is necessary because the method's return type is int[].
        int[] filteredArray = new int[filteredList.size()];
        for (int i = 0; i < filteredArray.length; i++) {
            // Copy each element from the ArrayList to the new array.
            filteredArray[i] = filteredList.get(i);
        }

        // Return the array containing only the numbers within the specified range.
        return filteredArray;
    }

    /**
     * Rotiert das übergebene Array um die übergebene Anzahl an Schritten nach rechts.
     * Das Array wird In-Place rotiert. Es gibt keine Rückgabe.
     *
     * @param array  Ein beliebiges Integer-Array
     * @param amount Ein beliebiger Integer
     */
    public static void rotate(int[] array, int amount) {
        // The length of the array is checked to avoid division by zero in the next step.
        if (array.length == 0) {
            return; // If the array is empty, there's nothing to rotate.
        }

        // Modulo operation ensures that the rotation amount is within the array bounds.
        // This handles cases where the rotation amount is larger than the array length.
        amount = amount % array.length;

        // Converting negative rotation amounts to positive equivalents.
        // Negative rotations to the left are the same as positive rotations to the right.
        if (amount < 0) {
            amount += array.length;
        }

        // Early return if no rotation is needed.
        if (amount == 0) {
            return;
        }

        // A temporary array is created to hold the rotated elements.
        int[] temporaryArray = new int[array.length];

        // Loop through each element of the original array.
        for (int i = 0; i < array.length; i++) {
            // Calculate the new index for each element after rotation.
            // The new index needs to wrap around the array, hence the use of modulo.
            int newIndex = (i + amount) % array.length;

            // Place each element of the original array into its new position in the temporary array.
            temporaryArray[newIndex] = array[i];
        }

        // Copy the rotated elements from the temporary array back into the original array.
        for (int i = 0; i < array.length; i++) {
            array[i] = temporaryArray[i];
        }

        // Note: The array is rotated in place, so there's no need to return anything.
    }


    /**
     * Zählt die Anzahl an Vorkommen jeder Zahl im übergebenen Array, die in diesem mindestens einmal vorkommt.
     * Die Rückgabe erfolgt über ein 2D-Array, bei dem jedes innere Array aus zwei Einträgen besteht: Einer Zahl,
     * die im übergebenen Array vorkommt sowie der Anzahl an Vorkommen dieser.
     * Für jede im übergebenen Array vorkommenden Zahl gibt es ein solches inneres Array.
     * Diese tauchen im Rückgabewert in der gleichen Reihenfolge auf, in der die jeweils ersten Vorkommen der Zahlen
     * im übergebenen Array auftauchen.
     *
     * @param array Ein beliebiges Integer-Array
     * @return Das Array mit den Vielfachheiten der einzelnen Zahlen, wiederum als Integer-Arrays mit zwei Einträgen dargestellt.
     */

        public static int[][] quantities(int[] array) {
            ArrayList<int[]> resultList = new ArrayList<>();

            // Iterate over each element in the array.
            for (int i = 0; i < array.length; i++) {
                boolean found = false;
                // Check if this element has already been accounted for.
                for (int[] pair : resultList) {
                    if (pair[0] == array[i]) {
                        // If found, increment the count and set found to true.
                        pair[1]++;
                        found = true;
                        break;
                    }
                }
                // If the element is not found, add it with a count of 1.
                if (!found) {
                    resultList.add(new int[]{array[i], 1});
                }
            }

            // Convert the ArrayList to a 2D array.
            int[][] result = new int[resultList.size()][2];
            for (int i = 0; i < resultList.size(); i++) {
                result[i] = resultList.get(i);
            }

            return result;
        }
    }
