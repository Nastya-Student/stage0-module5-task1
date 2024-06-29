package com.epam.mjc.stage0;

/**
 * Here are the tasks for working with the arrays.
 * <p>
 * The usage of any additional packages (such as java.util.*) is forbidden.
 */
public class ArrayTasks {

    /**
     * Return a String[] array that will list all the seasons of the year, starting with winter.
     */
    public String[] seasonsArray() {
        return new String[]{"winter", "spring", "summer", "autumn"};
    }

    /**
     * Generate an int[] array of consecutive positive integers
     * starting at 1 of the given length (length parameter > 0).
     * <p>
     * Example:
     * <p>
     * length = 1  -> [1]
     * length = 3  -> [1, 2, 3]
     * length = 5  -> [1, 2, 3, 4, 5]
     */
    public int[] generateNumbers(int length) {
        int [] arr = new int[length];
        for(int i = 0; i < length; i ++){
            arr[i] = i + 1;
        }
        return arr;
    }

    /**
     * Find the sum of all elements of the int[] array.
     * <p>
     * Example:
     * <p>
     * arr = [1, 3, 5]   -> sum = 9
     * arr = [5, -3, -4] -> sum = -2
     */
    public int totalSum(int[] arr) {
        return sum(arr);
    }
    private int sum (int [] arr){
        if(arr.length == 1){
            return arr[0];
        }
        int [] newArr = new int[arr.length - 1];
        System.arraycopy(arr, 1, newArr , 0, newArr.length);
        return arr[0] + sum(newArr);
    }

    /**
     * Return the index of the first occurrence of number in the arr array.
     * If there is no such element in the array, return -1.
     * <p>
     * Example:
     * <p>
     * arr = [99, -7, 102], number = -7    ->   2
     * arr = [5, -3, -4],   number = 10    ->  -1
     */
    public int findIndexOfNumber(int[] arr, int number) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == number){
                return i;
            }
        }
        return -1;
    }

    /**
     * Return the new String[] array obtained from the arr array
     * by reversing the order of the elements.
     * <p>
     * Example:
     * <p>
     * arr = ["Bob", "Nick"]               -> ["Nick", "Bob"]
     * arr = ["pineapple", "apple", "pen"] -> ["pen", "apple", "pineapple"]
     */
    public String[] reverseArray(String[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            String temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        return arr;
    }

    /**
     * Return new int[] array obtained from arr int[] array
     * by choosing positive numbers only.
     * P.S. 0 is not a positive number =)
     * <p>
     * Example:
     * <p>
     * arr = [1,-2, 3]      -> [1, 3]
     * arr = [-1, -2, -3]   -> []
     * arr = [1, 2]         -> [1, 2]
     */
    public int[] getOnlyPositiveNumbers(int[] arr) {
        int newLength = 0;
        boolean isLastPositive;
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > 0){
                continue;
            }
            isLastPositive = true;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] > 0){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    isLastPositive = false;
                    break;
                }
            }
            if(isLastPositive){
                newLength = i;
                break;
            }
        }
        int [] newArr = new int [newLength];
        System.arraycopy(arr, 0, newArr, 0, newLength);
        return newArr;
    }


    /**
     * Return a sorted, ragged, two-dimensional int[][] array following these rules:
     * Incoming one-dimensional arrays must be arranged in ascending order of their length;
     * numbers in all one-dimensional arrays must be in ascending order.
     * <p>
     * Example:
     * <p>
     * arr = [[3, 1, 2,], [3,2]] -> [[2, 3], [1, 2, 3]]
     * arr = [[5, 4], [7]]       -> [[7], [4, 5]]
     */
    public int[][] sortRaggedArray(int[][] arr) {
        // i will think it over later
        arr = sortArr(arr);
        for(int i = 0; i < arr.length; i++){
            arr[i] = sortInt(arr[i]);
        }
        return arr;
    }
    private int [][] sortArr(int [][] arr){
        int [][] copy = new int [arr.length][];
        System.arraycopy(arr, 0, copy, 0, arr.length);

        for (int i = arr.length - 1; i >= 0; i --){
            int maxLength = 0;
            int index = i;
            for(int j = copy.length - 1; j >= 0; j--){
                if(copy[j] == null){
                    continue;
                }
                if(copy[j].length > maxLength){
                    maxLength = copy[j].length;
                    index = j;
                }
            }
            arr[i] = copy[index];
            copy[index] = null;

        }
        return arr;
    }
    private int [] sortInt(int [] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int index = i;
            for (int j = i; j < arr.length; j++) {
                if(arr[j] < min){
                    min = arr[j];
                    index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
        return arr;
    }
}
