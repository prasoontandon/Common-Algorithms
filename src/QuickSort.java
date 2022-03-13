//////////////////////////////////////////////////////
// Date Learned: March 13th, 2022
//
// Time Complexity: O(n * log(n))
// Space Complexity: O(log(n))
/////////////////////////////////////////////////////

import java.util.Random;

public class QuickSort {

  /**
   * Main method
   * 
   * @param args arguments if any
   */
  public static void main(String[] args) {
    Random rand = new Random();
    int[] numArray = new int[10];

    for (int i = 0; i < numArray.length; ++i) {
      numArray[i] = rand.nextInt(1000);
    }

    // Before sort
    System.out.println("Unsorted:");
    printArray(numArray);

    quickSort(numArray);

    // After sort
    System.out.println("\nSorted:");
    printArray(numArray);
  }

  /**
   * Applies quick sort algorithm for a given array
   * 
   * @param numArray to quick sort
   * @param low      the lowest index of the sub-array to sort
   * @param high     the highest index of the sub-array to sort
   */
  private static void quickSort(int[] numArray, int low, int high) {

    // Base case: one element to sort
    if (low >= high) {
      return;
    }

    // Fix a pivot and swap it to place it at the end of sub-array
    int pivotIndex = new Random().nextInt(high - low) + low;
    int pivotVal = numArray[pivotIndex];
    swap(numArray, pivotIndex, high);

    int lp = low;
    int rp = high;

    while (lp < rp) {
      while (numArray[lp] <= pivotVal && lp < rp) {
        lp++;
      }
      while (numArray[rp] >= pivotVal && lp < rp) {
        rp--;
      }
      // Swap values to place on the correct side of pivot
      swap(numArray, lp, rp);
    }

    // Swap pivot when lp == rp to place pivot in the correct position
    if (numArray[lp] > numArray[high]) {
      swap(numArray, lp, high);
    } else {
      lp = high;
    }

    // Recursive call: left
    quickSort(numArray, low, rp - 1);

    // Recursive call: right
    quickSort(numArray, lp + 1, high);
  }

  /**
   * Swaps two elements in an array
   * 
   * @param numArray array in which elements are to be swapped
   * @param indexOne index of first element to swap
   * @param indexTwo index of second element to swap
   */
  private static void swap(int[] numArray, int indexOne, int indexTwo) {
    int temp = numArray[indexOne];

    numArray[indexOne] = numArray[indexTwo];
    numArray[indexTwo] = temp;
  }

  /**
   * Prints an array
   *
   * @param numArray to print
   */
  private static void printArray(int[] numArray) {
    for (int num : numArray) {
      System.out.print(num + " ");
    }
  }

  /**
   * Calls the method to quickSort
   * 
   * @param numArray array to sort
   */
  private static void quickSort(int[] numArray) {
    quickSort(numArray, 0, numArray.length - 1);
  }
}
