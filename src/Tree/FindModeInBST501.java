package Tree;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author he.wu Given a binary search tree (BST) with duplicates, find all the
 *         mode(s) (the most frequently occurred element) in the given BST.
 * 
 *         Assume a BST is defined as follows:
 * 
 *         The left subtree of a node contains only nodes with keys less than or
 *         equal to the node's key. The right subtree of a node contains only
 *         nodes with keys greater than or equal to the node's key. Both the
 *         left and right subtrees must also be binary search trees.
 * 
 * 
 *         For example: Given BST [1,null,2,2],
 * 
 *         1 \ 2 / 2
 * 
 * 
 *         return [2].
 * 
 *         Note: If a tree has more than one mode, you can return them in any
 *         order.
 * 
 *         Follow up: Could you do that without using any extra space? (Assume
 *         that the implicit stack space incurred due to recursion does not
 */
public class FindModeInBST501 {
	Integer prev = null;
    int count = 1;
    int max = 0;
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) res[i] = list.get(i);
        return res;
    }
    
    private void traverse(TreeNode root, List<Integer> list) {
        if (root == null) return;
        traverse(root.left, list);
        if (prev != null) {
            if (root.val == prev)
                count++;
            else
                count = 1;
        }
        if (count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        } else if (count == max) {
            list.add(root.val);
        }
        prev = root.val;
        traverse(root.right, list);
    }
	@Test
	public void test() {
		TreeNode p = new TreeNode(3);
		TreeNode p1 = new TreeNode(9);
		TreeNode p2 = new TreeNode(3);
		TreeNode p3 = new TreeNode(9);
		TreeNode p4 = new TreeNode(7);
		p.left = p1;
		p.right = p2;
		p2.left = p3;
		p2.right = p4;
		System.out.println(findMode(p));
	}
}
