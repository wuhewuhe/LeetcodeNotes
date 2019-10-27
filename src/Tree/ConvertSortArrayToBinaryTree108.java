package Tree;

import org.junit.Test;

public class ConvertSortArrayToBinaryTree108 {
	public TreeNode sortArrayToBST(int[] arr) {
		return helper(arr, 0, arr.length - 1);
	}

	private TreeNode helper(int[] arr, int start, int end) {
		if (start > end)
			return null;
		int mid = start + (end - start) / 2;
		TreeNode root = new TreeNode(arr[mid]);
		root.left = helper(arr, start, mid - 1);
		root.right = helper(arr, mid + 1, end);
		return root;
	}

	@Test
	public void test() {
		int[] arr = { 1, 2, 3, 4, 5 };
		TreeNode root = sortArrayToBST(arr);
		System.out.println(root);
	}
}
