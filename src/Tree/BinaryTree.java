package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

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

	public void inOrderStore(TreeNode TreeNode) {
		if (TreeNode != null) {
			inOrder(TreeNode.left);
			//System.out.println(TreeNode);
			res.add(TreeNode.val);
			inOrderStore(TreeNode.right);
		}
	}

	public static List<Integer> res = new ArrayList<>();
	
	
	public static int binarySearch(int i) {
		return binarySearch(res,0,res.size(),i);
	}

	public static int binarySearch(List<Integer> list, int fromIndex, int toIndex, int key) {
		int low = fromIndex;
        int high = toIndex - 1;
        
        while (low <= high) {
            int mid = low +(high-low);
            int midVal = list.get(mid);

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
	}

	public static void main(String[] args) {
		//int[] nums = { 5, 4, 7, 2, 3, 1, 6, 8 };
		BinaryTree bt = new BinaryTree();
		Set<Integer> set = new TreeSet<>();
		Random rm = new Random();
		while (set.size() < 5) {
			int next = rm.nextInt(10) + 1;
			set.add(next);
		}
		for (int i : set) {
			bt.buildTree(bt.root, i);
		}
		bt.inOrderStore(bt.root);
		int ans = binarySearch(5);
		res.forEach(x -> System.out.print(x + " "));
		System.out.println();
		System.out.println(ans);
//		BinaryTree bt = new BinaryTree();
//		for (int i : nums) {
//			bt.buildTree(bt.root, i);
//		}
//		bt.inOrder(bt.root);
	}

}
