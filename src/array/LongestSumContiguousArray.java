package array;

/*
 * http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 * 
 * find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum.
 */

public class LongestSumContiguousArray {

	public static void main(String[] args) {
		int[] A = {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println("Max sum = "+ longestSum(A));
		printLongestSumIndex(A);
	}
	
	/*
	 * Dynamic Programming
	 * Time complexity is O(n), Space complexity is O(1)
	 */
	
	private static int longestSum(int[] input){
		if (input.length<=0) {
			return 0;
		}
		int maxSum = input[0];
		int currentMax = input[0];
		for (int i = 1; i < input.length; i++) {
			currentMax = Math.max(input[i], currentMax+input[i]);
			maxSum = Math.max(maxSum, currentMax);
		}
		
		return maxSum;
	}
	
	/*
	 * If you also want to print the start and end index of 
	 * the maximum sum contiguous array
	 */
	
	private static void printLongestSumIndex(int[] input){
		int maxSum = input[0];
		int currentMax = input[0];
		int start = 0, end = 0;
		for (int i = 1; i < input.length; i++) {
			if (input[i]>currentMax+input[i]) {
				start = i;
				currentMax = input[i];
			}else{
				currentMax = currentMax+input[i];
			}
			
			if (currentMax>maxSum) {
				maxSum = currentMax;
				end = i;
				
			}
			
		}
		
		System.out.println("Max Sum = "+ maxSum + " Start index = "+ start + ", End index = "+ end);
	}
}
