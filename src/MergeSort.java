//////////////////////////////////////////////////////
// Date Learned: March 7th, 2022
//
// Time Complexity: O(n * log(n))
// Space Complexity: O(n) 
/////////////////////////////////////////////////////

import java.util.Random;

public class MergeSort {
  public static void main(String[] args) {

    // Creating a random array of ints to sort
    Random rand = new Random();
    int[] numbers = new int[10];

    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = rand.nextInt(1000000);
    }

    System.out.println("Before:");
    printArray(numbers);

    ////////MAIN CALL////////////
    mergeSort(numbers);
    ////////MERGESORT///////////

    System.out.println("\nAfter:");
    printArray(numbers);
  }

  private static void mergeSort(int[] inputArray) {
    int length = inputArray.length;

    // Base case of recursion
    if (length <= 1) {
      return;
    }

    int midpoint = length / 2;
    int[] leftArray = new int[midpoint];
    int[] rightArray = new int[length - midpoint];

    // Populate left and right arrays
    for (int i = 0; i < midpoint; ++i) {
      leftArray[i] = inputArray[i];
    }
    for (int i = midpoint; i < length; ++i) {
      rightArray[i - midpoint] = inputArray[i];
    }

    // Recursive Call
    mergeSort(leftArray);
    mergeSort(rightArray);

    // Merge Arrays
    mergeArrays(inputArray, leftArray, rightArray);

  }

  private static void mergeArrays(int[] inputArray, int[] leftArray, int[] rightArray) {

    int lengthLeft = leftArray.length;
    int lengthRight = rightArray.length;

    int pointer1 = 0;
    int pointer2 = 0;
    int pointer3 = 0;

    while (pointer1 < lengthLeft && pointer2 < lengthRight) {

      if (leftArray[pointer1] <= rightArray[pointer2]) {
        inputArray[pointer3] = leftArray[pointer1++];

      } else {
        inputArray[pointer3] = rightArray[pointer2++];
      }
      pointer3++;
    }

    while (pointer1 < lengthLeft) {
      inputArray[pointer3++] = leftArray[pointer1++];
    }
    while (pointer2 < lengthRight) {
      inputArray[pointer3++] = rightArray[pointer2++];
    }

  }

  private static void printArray(int[] numbers) {
    for (int i = 0; i < numbers.length; i++) {
      System.out.println(numbers[i]);
    }
  }
}

