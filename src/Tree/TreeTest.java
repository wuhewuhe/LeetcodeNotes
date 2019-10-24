package Tree;

public class TreeTest {
	public static void main(String[] args) {
		int[] nums = { 5, 4, 7, 2, 3, 1, 6, 8 };
		BinaryTree bt = new BinaryTree();
		for (int i : nums) {
			bt.buildTree(bt.root, i);
		}
		bt.inOrder(bt.root);
	}
}
