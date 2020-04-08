package Tree;

public class ConstructBinaryTreeFromPreorderInorder105 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null || inorder.length == 0
				|| inorder.length != preorder.length) {
			return null;
		}
		return helperDFS(preorder, inorder, 0, 0, inorder.length);
	}

	private TreeNode helperDFS(int[] preorder, int[] inorder, int pre_start, int in_start, int in_end) {
		if (pre_start > preorder.length-1 || in_start > in_end) {
			return null;
		}
		TreeNode current = new TreeNode(preorder[pre_start]);
		int i = in_start;
		while (i < preorder.length) {
			if (inorder[i] == preorder[pre_start]) {
				break;
			}
			i++;
		}
		current.left = helperDFS(preorder, inorder, pre_start + 1, in_start, i - 1);
		current.right = helperDFS(preorder, inorder, pre_start + 1 + i - in_start, i + 1, in_end);
		return current;
	}
}
