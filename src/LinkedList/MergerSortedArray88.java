package LinkedList;

import org.junit.Test;

public class MergerSortedArray88 {
	public void merge(int[] A, int m, int[] B, int n) {
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;
		while (i >= 0 && j >= 0) {
			if (A[i] > B[j])
				A[k--] = A[i--];
			else
				A[k--] = B[j--];
		}
		while (j >= 0)
			A[k--] = B[j--];

	}

	@Test
	public void test() {
		int[] nums1 = { 1, 2, 3, 0, 0, 0 }, nums2 = { 2, 5, 6 };
		int m = 3, n = 3;
		merge(nums1, m, nums2, n);
		System.out.println(nums1);
	}

}
