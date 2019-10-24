package Tree;

public class BinaryTree {
	TreeNode root;

	public BinaryTree() {
		root = null;
	}

	public void buildTree(TreeNode TreeNode, int data) {
		if (root == null) {
			root = new TreeNode(data);
		} else {
			if (data < TreeNode.val) {
				if (TreeNode.left == null) {
					TreeNode.left = new TreeNode(data);
				} else {
					buildTree(TreeNode.left, data);
				}
			} else {
				if (TreeNode.right == null) {
					TreeNode.right = new TreeNode(data);
				} else {
					buildTree(TreeNode.right, data);
				}
			}
		}
	}

	/**
	 * 前序遍历 root -> left -> right
	 * 
	 * @param TreeNode
	 */
	public void preOrder(TreeNode TreeNode) {
		if (TreeNode != null) {
			System.out.println(TreeNode.val);
			preOrder(TreeNode.left);
			preOrder(TreeNode.right);
		}
	}

	/**
	 * 中序遍历 left -> root -> right
	 * 
	 * @param TreeNode
	 */
	public void inOrder(TreeNode TreeNode) {
		if (TreeNode != null) {
			inOrder(TreeNode.left);
			System.out.println(TreeNode.val);
			inOrder(TreeNode.right);
		}
	}

	/**
	 * 后序遍历 left -> right -> root
	 * 
	 * @param TreeNode
	 */
	public void postOrder(TreeNode TreeNode) {
		if (TreeNode != null) {
			postOrder(TreeNode.left);
			postOrder(TreeNode.right);
			System.out.println(TreeNode.val);
		}
	}
	
	public static void main(String[] args) {
		int[] nums = { 5, 4, 7, 2, 3, 1, 6, 8 };
		BinaryTree bt = new BinaryTree();
		for (int i : nums) {
			bt.buildTree(bt.root, i);
		}
		bt.inOrder(bt.root);
	}

}
