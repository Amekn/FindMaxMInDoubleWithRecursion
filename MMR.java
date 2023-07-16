/**
 * MMR
 *
 * A method class contain the definition to find the max and min from an double array with recursion.
 */
public class MMR{
    
    /**
     * MMR()
     *
     * Private constructor to ensure the class could not be instantiated.
     */
    private MMR(){};
    
    /**
     * findMaxAndMinRecursion(double[] arr, int leftEnd, int rightEnd)
     *
     * Method implements the default of how to find the max and min form an double array using recursion.
     * @param arr, the array contain all elements to be looking through.
     * @param leftEnd, the left end of the current selection inclusive.
     * @param rightEnd, the right end of the current selection inclusive.
     * @return results, the array contain 2 elements, the 0th element is the maximum, and the 1th element is the minium.
     */
    private static double[] findMaxAndMinRecursion(double[] arr, int leftEnd, int rightEnd){
        //Postcondition: the 0th item in the return value is the maximum.
        //the 1th item in the return value is the minimum.
        double[] results1 = new double[2];
        //Base case 1: the length of arr is 1.
        if(leftEnd == rightEnd){
            results1[0] = arr[leftEnd];
            results1[1] = arr[leftEnd];
            return results1;
        }
        //Base case 2: the length of arr is 2.
        if((leftEnd + 1) == rightEnd){
            results1[0] = (arr[leftEnd] > arr[rightEnd]) ? arr[leftEnd] : arr[rightEnd];
            results1[1] = (results1[0] == arr[leftEnd]) ? arr[rightEnd] : arr[leftEnd];
            return results1;
        }
        //Recursive case:
        int currentSize = (rightEnd - leftEnd) + 1;
        int average = currentSize / 2;
        average = (average % 2 == 0) ? average - 1 : average;
        results1 = findMaxAndMinRecursion(arr, leftEnd, leftEnd + average);
        double[] results2 = findMaxAndMinRecursion(arr, leftEnd + average + 1, rightEnd);
        if(results2[0] > results1[0]){
            if(results2[1] > results1[1]){
                results2[1] = results1[1];
            }
            return results2;
        }
        if(results1[1] > results2[1]){
            results1[1] = results2[1];
        }
        return results1;
    }
    
    
    /**
     * findMaxAndMIn(double[] arr)
     *
     * Driver routines that checks for precondition before the recursive routine is called.
     * @param arr, the array contains the all the elements to be checked through.
     * @param result, the array that contains the maximum and minium.
     */
    
    public static double[] findMaxAndMin(double[] arr){
        //Precondition: arr.length >= 1.
        if(!(arr.length >= 1)) throw new IllegalArgumentException("The length of the array must be longer than 1.");
        return findMaxAndMinRecursion(arr, 0, arr.length - 1);
    }
}
