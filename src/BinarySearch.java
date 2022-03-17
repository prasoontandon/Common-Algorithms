/////////////////////Iterative///////////////////////
// Date Learned: March 17th, 2022
//
// Time Complexity: O(log(n))
// Space Complexity: O(1)
/////////////////////////////////////////////////////

/////////////////////Recursive///////////////////////
// Date Learned: March 17th, 2022
//
// Time Complexity: O(log(n))
// Space Complexity: O(log(n))
/////////////////////////////////////////////////////


public class BinarySearch{
  
  public static void main(String[] args) {
    System.out.println("testBinarySearch: " + testBinarySearch());
    System.out.println("testBinarySearchRecursive: " + testBinarySearchRecursive());  
  }
  
  private static int binarySearch(int[] numbers, int val) {
    
    int left = 0;
    int right = numbers.length - 1;
    int mid;
    
    while(left <= right) {      
      mid = ((right - left) / 2) + left;
      
      if(numbers[mid] == val) {
        return mid;
      } else if(numbers[mid] < val) {      
        left = mid + 1;
      } else {
        right = mid - 1;
      }     
    }
    return -1;
  }
  
  private static int binarySearchRecursive(int[] numbers, int val, int left, int right) {
    
    if(left > right) {
      return -1;
    }
    
    // Find midpoint using algo that avoids int overflow problem
    int mid = ((right - left) / 2) + left;
    
    if(numbers[mid] == val) {
      return mid;      
    } else if(numbers[mid] < val) {
      return binarySearchRecursive(numbers, val, mid + 1, right);      
    } else {
      return binarySearchRecursive(numbers, val, left, mid - 1);      
    }
  }
  
  private static boolean testBinarySearch() {
    
    int[] testArray1 = {6, 20, 34, 43, 62, 66, 73, 76, 77, 93, 99, 118, 121, 127, 129, 133, 145, 
        175, 179, 188};
    int searchFor;
    int expectedIndex;  
    
    { // Test #1
      searchFor = 99;
      expectedIndex = 10;
      
      if(binarySearch(testArray1, searchFor) != expectedIndex) {
        System.out.println("Test 1 in testBinarySearch failed");
        return false;
      }  
    }
    
    { // Test #2
      searchFor = 188;
      expectedIndex = 19;
      
      if(binarySearch(testArray1, searchFor) != expectedIndex) {
        System.out.println("Test 2 in testBinarySearch failed");
        return false;
      }  
    }
    
    { // Test #3
      searchFor = 6;
      expectedIndex = 0;
      
      if(binarySearch(testArray1, searchFor) != expectedIndex) {
        System.out.println("Test 3 in testBinarySearch failed");
        return false;
      }  
    }
    
    { // Test #4
      searchFor = 199;
      expectedIndex = -1;
      
      if(binarySearch(testArray1, searchFor) != expectedIndex) {
        System.out.println("Test 4 in testBinarySearch failed");
        return false;
      }  
    }
    
    return true;
  }
  
  private static boolean testBinarySearchRecursive() {
    int[] testArray2 = {1, 2, 6, 20, 33, 43, 59, 68, 118, 119, 125, 129, 133, 145, 275, 379, 588};
    int length = testArray2.length - 1;
    int searchFor;
    int expectedIndex;  
    
    { // Test #1
      searchFor = 119;
      expectedIndex = 9;
      
      if(binarySearchRecursive(testArray2, searchFor, 0 , length) != expectedIndex) {
        System.out.println("Test 1 in testBinarySearchRecursive failed");
        return false;
      }  
    }
    
    { // Test #2
      searchFor = 588;
      expectedIndex = 16;
      
      if(binarySearchRecursive(testArray2, searchFor, 0 , length) != expectedIndex) {
        System.out.println("Test 2 in testBinarySearchRecursive failed");
        return false;
      }  
    }
    
    { // Test #3
      searchFor = 1;
      expectedIndex = 0;
      
      if(binarySearchRecursive(testArray2, searchFor, 0 , length) != expectedIndex) {
        System.out.println("Test 3 in testBinarySearchRecursive failed");
        return false;
      }  
    }
    
    { // Test #4
      searchFor = 199;
      expectedIndex = -1;
      
      if(binarySearchRecursive(testArray2, searchFor, 0, length) != expectedIndex) {
        System.out.println("Test 4 in testBinarySearchRecursive failed");
        return false;
      }  
    }
    
    return true;
  } 
}