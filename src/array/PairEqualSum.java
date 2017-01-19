package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*http://www.geeksforgeeks.org/write-a-c-program-that-given-a-set-a-of-n-numbers-and-another-number-x-determines-whether-or-not-there-exist-two-elements-in-s-whose-sum-is-exactly-x/
 * 
 * Given an array A[] of n numbers and another number x, determines whether
 * or not there exist two elements in S whose sum is exactly x.
 */
public class PairEqualSum {

	public static void main(String[] args) {
		int[] A = {1, 4, 45, 6, 10, -8};
		int x = 16;
		printPair(A, x);
		printPairByMap(A, x);
	}
	

	/*
	 * Using sorting way Complexity depends on which sorting algorithms you are
	 * using I am considering quicksort for sorting which have time complexity
	 * O(nlogn) in average case for detailed code of quicksort search for sorting
	 * package/quicksort class
	 * Complexity of this method is same as quicksort
	 */
	private static void printPair(int[] input, int x) {
		if (input.length<=0) {
			System.out.println("Array is empty");
			return;
		}
		Arrays.sort(input); // Consider it as quicksort
		// Array is now sorted
		boolean pairFound = false;
		int start = 0, end = input.length - 1;
		while (start < end) {
			int sum = input[start] + input[end];
			if (sum == x) {
				System.out.println("First no is : " + input[start] + " and second no is : " + input[end]);
				pairFound = true;
				break;
			} else if (sum < x) {
				start++;
			} else {
				end--;
			}

		}
		if (!pairFound) {
			System.out.println("No such pair exist");
		}
	}
	
	/*
	 * Another way of solving this problem is by using Set
	 * Time complexity would be O(n)
	 * Space complexity would be O(n)
	 * Check set implementation
	 */
	
	private static void printPairByMap(int[] input, int x){
		if (input.length<=0) {
			System.out.println("Array is empty");
			return;
		}
		Set<Integer> store = new HashSet<>();
		for (int i = 0; i < input.length; i++) {
			if (store.contains(input[i])) {
				System.out.println("No is : " + input[i] + " and second no is : " + (x-input[i]));
				return;
			}
			store.add(x-input[i]);
		}
		System.out.println("No such pair exist");
	}
}
