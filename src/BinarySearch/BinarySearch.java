package BinarySearch;

import java.util.Arrays;

public class BinarySearch {

	// t(n) = n , p(n) = 1, this is must be sorted array
	public static int BinarySearchNormal(int[] nums, int first, int last, int target) {
		int mid = (first + last) / 2;
		while (first < last) {
			if (nums[mid] < target)
				first = mid + 1;
			else if (nums[mid] == target)
				return mid;
			else
				last = mid - 1;
			mid = (first + last) / 2;
		}
		throw new IllegalArgumentException("No solution");
	}

	public static int BinarySearchRecursion(int[] nums, int first, int last, int target) {
		if (first > last)
			return -1;
		int mid = (first + last) / 2;
		if(nums[mid]<target) return BinarySearchRecursion(nums,mid+1,last,target);
		else if(nums[mid]<target)return BinarySearchRecursion(nums,first,mid-1,target);
		else return mid;
	}

	public static void main(String[] args) {
		byte byteArr[] = { 10, 20, 20, 15, 22, 35 };
		char charArr[] = { 'g', 'p', 'q', 'c', 'i' };
		int intArr[] = { 10, 20, 15, 22, 35 };
		double doubleArr[] = { 10.2, 15.1, 2.2, 3.5 };
		float floatArr[] = { 10.2f, 15.1f, 2.2f, 3.5f };
		short shortArr[] = { 10, 20, 15, 22, 35 };

		Arrays.sort(byteArr);
		Arrays.sort(charArr);
		Arrays.sort(intArr);
		Arrays.sort(doubleArr);
		Arrays.sort(floatArr);
		Arrays.sort(shortArr);

//	        byte byteKey = 20; 
//	        char charKey = 'g'; 
//	        int intKey = 22; 
//	        double doubleKey = 1.5; 
//	        float floatKey = 35; 
//	        short shortKey = 5; 

//	        System.out.println(byteKey + " found at index = "
//	                           +Arrays.binarySearch(byteArr,byteKey)); 
//	        System.out.println(charKey + " found at index = "
//	                           +Arrays.binarySearch(charArr,charKey)); 
//	        System.out.println(intKey + " found at index = "
//	                           +Arrays.binarySearch(intArr,intKey)); 
//	        System.out.println(doubleKey + " found at index = "
//	                           +Arrays.binarySearch(doubleArr,doubleKey)); 
//	        System.out.println(floatKey + " found at index = "
//	                           +Arrays.binarySearch(floatArr,floatKey)); 
//	        System.out.println(shortKey + " found at index = "
//	                           +Arrays.binarySearch(shortArr,shortKey)); 

		int[] nums = { 10, 15, 20, 22, 35 };
		System.out.println(BinarySearchRecursion(nums, 0, nums.length - 1, 20));
	}
}
