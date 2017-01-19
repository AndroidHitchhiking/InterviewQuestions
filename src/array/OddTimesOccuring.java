package array;
/*
 * http://www.geeksforgeeks.org/find-the-number-occurring-odd-number-of-times/
 * 
 * Given an array of positive integers. All numbers occur even number 
 * of times except one number which occurs odd number of times.
 */

import java.util.HashMap;
import java.util.Map;

public class OddTimesOccuring {

	public static void main(String[] args) {
		int[] A = {2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2 };
		int hashOutput = findOddOccuring(A);
		if (hashOutput == -1) {
			System.out.println("NONE");
		} else {
			System.out.println(hashOutput);
		}
		
		int xorOutput = findOddOccuringXOR(A);
		if (xorOutput == 0) {
			System.out.println("NONE");
		} else {
			System.out.println(xorOutput);
		}
	}

	/*
	 * One way to solve this problem using HashMap. Space and Time complexity
	 * would on O(n)
	 */
	private static int findOddOccuring(int[] A) {
		if (A.length <= 0) {
			return -1;
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			if (map.containsKey(A[i])) {
				map.put(A[i], map.get(A[i]) + 1);
			} else {
				map.put(A[i], 1);
			}
		}
		
		for ( Map.Entry<Integer, Integer> entry : map.entrySet()) {
		    if (entry.getValue()%2 != 0) {
				return entry.getKey();
			}
		    // do something with key and/or tab
		}
		return -1;
		
	}
	
	/*
	 * A simple and efficient solution is to use bitwise XOR operation.
	 * Time complexity O(n), SPace complexity O(1).
	 * 
	 * XOR of two elements is 0 if both elements are same and XOR of a number x with 0 is x
	 */
	private static int findOddOccuringXOR(int[] A) {
		int result = 0;
		for (int i = 0; i < A.length; i++) {
			result = result^A[i];
		}
		return result;
	}
}
