package array;

import java.util.HashMap;

/*http://www.geeksforgeeks.org/majority-element/
 *
 * Find element in an array A[] of size n which appears more than n/2 times ?
 * 
 * Can be done by running two loops which time complexity would be O(n*n),
 * So I am not consider this solution here.
 */
public class MajorityElement {

	public static void main(String[] args) {
		int[] A = { 3, 3, 4, 2, 4, 4, 2, 4, 4 };
		int output = majorityWithHashMap(A);
		if (output == -1) {
			System.out.println("NONE");
		} else {
			System.out.println(output);
		}
		
		int majOutput = majority(A);
		if (majOutput == -1) {
			System.out.println("NONE");
		} else {
			System.out.println(output);
		}
	}

	/*
	 * One way is to use HashMap, Store the key as no and value as count of that
	 * no. when any no count is > n/2, just return it. Time and space complexity
	 * would be O(n).
	 */
	private static int majorityWithHashMap(int[] input) {
		if (input.length <= 0) {
			return -1;
		}
		int size = input.length;
		int majorityBound = size / 2;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < size; i++) {
			if (map.containsKey(input[i])) {
				map.put(input[i], map.get(input[i]) + 1);
			} else {
				map.put(input[i], 1);
			}

			if (map.get(input[i]) > majorityBound) {
				return input[i];
			}
		}
		return -1;
	}

	/*
	 * Another way to solve this problem is to use Moore's Voting Algorithm This
	 * Algorithm will solve the problem in O(n) time and O(1) space. It is two
	 * phase algorithm, first to find the majority candidate then verify that
	 * candidate and get the output.
	 */
	private static int majority(int[] A){
		int candidate = findMajorityCandidate(A);
		int size = A.length;
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == candidate) {
				count++;
			}
		}
		
		if (count>(size/2)) {
			return candidate;
		}
		return -1;
		
	}
	private static int findMajorityCandidate(int[] input){
		int majCandidate = input[0];
		int count = 1;
		for (int i = 1; i < input.length; i++) {
			if (majCandidate == input[i]) {
				count++;
			}else{
				count--;
			}
			
			if(count == 0){
				majCandidate = input[i];
				count = 1;
			}
		}
		return majCandidate;
	}	
	

}
