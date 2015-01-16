package main;

/**
 * Iterative implementation of the Binary Search algorithm.
 * 
 * @author Thad Eirich
 */
public class BinarySearchIterativeImpl implements BinarySearch {
	/**
	 * Return the index of val in arr.  Return -1 if not found.
	 * @param arr Sorted array to be searched
	 * @param val Value to be searched for
	 * @return Index of 'val' or -1 if not found
	 */
	public int binSearch(int[] arr, int val){
		//index starting points
		int lowIndex = 0;
		int highIndex = arr.length - 1;
		//while the partition's size is at least one
		while(highIndex >= lowIndex){
			//calculate the middle index
			int midIndex = (highIndex + lowIndex) / 2;
			//if the array contains the value at the middle index return the index
			if(arr[midIndex] == val){
				return midIndex;
			}
			//else partition array
			if(val < arr[midIndex]){
				highIndex = midIndex -1;
			}
			else {
				lowIndex = midIndex + 1;
			}
		}
		return -1;
	}
	
}
