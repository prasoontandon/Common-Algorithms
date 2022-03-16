//////////////////////////////////////////////////////
// Date Learned: March 16th, 2022
//
// Time Complexity: O(n^2)
// Space Complexity: O(1)
/////////////////////////////////////////////////////

import java.util.Random;

public class BubbleSort {

  public static void main(String[] args) {
    Random rand = new Random();

    int[] numArray = new int[10];

    for (int i = 0; i < numArray.length; ++i) {
      numArray[i] = rand.nextInt(100);
    }

    System.out.println("Before: ");
    printArray(numArray);

    bubbleSort(numArray);

    System.out.println("\nAfter: ");
    printArray(numArray);
  }

  private static void bubbleSort(int[] numArray) {

    int N = numArray.length;

    for (int i = 0; i < N - 1; ++i) {
      for (int j = 0; j < N - 1 - i; ++j) {
        if (numArray[j] > numArray[j + 1]) {
          
          //Swap
          int temp = numArray[j];
          numArray[j] = numArray[j + 1];
          numArray[j + 1] = temp;
        }
      }
    }
  }

  private static void printArray(int[] numArray) {
    for (int number : numArray) {
      System.out.print(number + " ");
    }
  }
}
