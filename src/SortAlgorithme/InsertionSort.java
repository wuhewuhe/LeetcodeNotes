package SortAlgorithme;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author he.wu insertion sort is a simple sorting algorithm that works the way
 *         we sort playing cards in our hands time o(n^2) space o(1) stable
 * 
 *         insertion sort use when the numbers are small
 */

public class InsertionSort {

	public void sort(int[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			int key = arr[i];
			int j = i - 1;

			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one position
			 * ahead of their current position
			 */
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}

	@Test
	public void test() {
		int arr[] = { 14, 16, 15, 13, 5, 6 };
		sort(arr);
		Arrays.asList(arr).forEach(System.out::println);
	}
}
