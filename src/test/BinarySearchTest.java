package test;

import main.BinarySearch;
import main.BinarySearchIterativeImpl;
import main.BinarySearchRecursiveImpl;

/**
 * Test class for the Binary Search interface. 
 * 
 * @author Thad Eirich
 */
public class BinarySearchTest {
	
	public static void main(String[] args){
		System.out.println("====BINARY SEARCH UNIT TEST START====");

		System.out.println("Recursive Algorithm Tests");
		BinarySearch bsRecursive = new BinarySearchRecursiveImpl();
		int recursiveTestsPassed = runTests(bsRecursive);
		System.out.println(recursiveTestsPassed + "/4 tests passed");
		
		System.out.println();

		System.out.println("Iterative Algorithm Tests");
		BinarySearch bsIterative = new BinarySearchIterativeImpl();
		int iterativeTestsPassed = runTests(bsIterative);
		System.out.println(iterativeTestsPassed + "/4 tests passed");

	}

	/**
	 * Runs all tests for BinarySearch implementation
	 * @param bs BinarySearch instance to be tested
	 * @return Number of tests passed
	 */
	public static int runTests(BinarySearch bs){
		int passedCount = 0;
		if(testValueNotFound(bs)) passedCount++;
		if(testEdgeCases(bs)) passedCount++;
		if(testOrderedArray(bs)) passedCount++;
		if(testDuplicates(bs)) passedCount++;
		return passedCount;
	}
	/**
	 * Binary search should still find duplicate values within the array, however order cannot be guaranteed.
	 * @param bs BinarySearch instance to be tested
	 * @return Test passed?
	 */
	private static boolean testDuplicates(BinarySearch bs){
		int testArray[] = { 79, 114, 227, 227, 298, 314, 444, 495, 694, 701, 702, 998 };
		int resultIndex = bs.binSearch(testArray, 227);
		if(resultIndex != 2 && resultIndex != 3){
			System.out.println("[FAILURE] Duplicate value not found within array.");
			return false;
		}
		System.out.println("[SUCCESS] Duplicate value found within array.");
		return true;
	}
	
	/**
	 * Binary search should handle the three edge cases presented:
	 * 		- Lowest index value
	 * 		- Middle index value (first detected)
	 * 		- Highest index value
	 * @param bs BinarySearch instance to be tested
	 * @return Test passed?
	 */
	private static boolean testEdgeCases(BinarySearch bs){
		int testArray[] = new int[1000];
		for(int i = 0; i < 1000; i++){
			testArray[i] = i;
		}
		
		if(bs.binSearch(testArray, 0) != 0){
			System.out.println("[FAILURE] Low extreme value not found.");
			return false;
		}
		System.out.println("[SUCCESS] Low extreme value found.");
		
		if(bs.binSearch(testArray, 499) != 499){
			System.out.println("[FAILURE] Mid value not found.");
			return false;
		}
		System.out.println("[SUCCESS] Mid value found.");
		if(bs.binSearch(testArray, 999) != 999){
			System.out.println("[FAILURE] High extreme value not found.");
			return false;
		}
		System.out.println("[SUCCESS] High extreme value not found.");
		return true;
	}
	
	/**
	 * Binary search should correctly report a missing index with the value -1
	 * @param bs BinarySearch instance to be tested
	 * @return Test passed?
	 */
	private static boolean testValueNotFound(BinarySearch bs){
		int emptyArray [] = {};
		if(bs.binSearch(emptyArray, 25) >= 0){
			System.out.println("[FAIL] Value reported as found in empty array");
		}
		System.out.println("[SUCCESS] Value reported as not found in empty array");
		
		int testArray[] = {0, 11, 22, 33, 44, 55, 66, 77, 88, 99};
		if(bs.binSearch(testArray, 15) >= 0){
			System.out.println("[FAIL] Missing value was reported as found.");
			return false;
		}
		System.out.println("[SUCCESS] Missing value was reported as missing.");
		
		return true;
	}
	
	/**
	 * Binary search should only succeed for ordered arrays.
	 * @param bs BinarySearch instance to be tested
	 * @return Test passed?
	 */
	private static boolean testOrderedArray(BinarySearch bs){
		
		// generate orderedCount ordered array and reverseCount unordered array
		int orderedCount[] = new int[1000];
		int reverseCount[] = new int[1000];
		
		for(int i = 0; i < 1000; i++){
			orderedCount[i] = i * 2;
			reverseCount[i] = 1000 - i;
		}
		
		//The search should succeed in finding a value in a forwards ordered array
		int orderedResult = bs.binSearch(orderedCount, 22);
		if(orderedResult == -1){
			System.out.println("[FAIL] Value not found in ordered array, index: " + orderedResult + ".");
			return false;
		}
		System.out.println("[SUCCESS] Value found in ordered array, index: " + orderedResult + ".");
		
		//The search should always fail to find a value in a reverse ordered array
		int reverseResult = bs.binSearch(reverseCount, 25);
		if(reverseResult >= 0){
			System.out.println("[FAIL] Value found in reversed array, index: " + reverseResult + ".");
			return false;
		}
		System.out.println("[SUCCESS] Value found in ordered array, index: " + reverseResult + ".");
		return true;
	}
	
	
}
