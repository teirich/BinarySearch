package main;

/**
 * Recursive implementation of the Binary Search algorithm not using the keyword "if".
 * 
 * @author Thad Eirich
 */
public class BinarySearchRecursiveImpl implements BinarySearch {
	/**
	 * Return the index of val in arr.  Return -1 if not found.
	 * @param arr Sorted array to be searched
	 * @param val Value to be searched for
	 * @return Index of searched val or -1 if not found
	 */
	public int binSearch(int[] arr, int val){
		return binSearchHelper(arr, val,0,arr.length-1);
	}
	
	private static int binSearchHelper(int[] arr, int val, int lowIndex, int highIndex){
		int midIndex = (lowIndex + highIndex) / 2;
		return (highIndex < lowIndex) ? -1 : 	//base case - value not found
				(arr[midIndex] == val) ? midIndex :	//base case - value found
						(val < arr[midIndex]) ? binSearchHelper(arr, val, lowIndex, midIndex-1) : 	//partition remaining array
								binSearchHelper(arr, val, midIndex+1, highIndex); 
	}
}
