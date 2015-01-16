package main;

/**
 * Binary Search interface.
 * 
 * It is necessary for an array to be sorted before a binary search can be performed. Implementations of
 * this algorithm will assume the arrays passed to it are already sorted.  Failure to pass in a sorted 
 * array will lead to unpredictable results.
 * 
 * @author Thad Eirich
 */
public interface BinarySearch {
	/**
	 * Return the index of val in arr.  Return -1 if not found.
	 * @param arr Sorted array to be searched
	 * @param val Value to be searched for
	 * @return Index of 'val' or -1 if not found
	 */
	public abstract int binSearch(int[] arr, int val);
}
