package Tree;

import org.junit.Test;

public class BinarySearchTree {

	@Test
	public void test() {
		TreeNode p = new TreeNode(12);
		TreeNode p1 = new TreeNode(9);
		TreeNode p2 = new TreeNode(20);
		TreeNode p3 = new TreeNode(15);
		TreeNode p4 = new TreeNode(11);
		p.left = p1;
		p1.right = p4;
		p.right = p2;
		p2.left = p3;

		System.out.println(searchNode(p));
	}

	static int i = 100;

	private boolean searchNode(TreeNode p) {
		if (p == null)
			return false;
		return isHelper(p);
	}

	private boolean isHelper(TreeNode p) {
		if (p == null)
			return false;
		if (p.val == i)
			return true;
		else if (p.val > i) {
			return isHelper(p.left);
		} else {
			return isHelper(p.right);
		}
	}
}
