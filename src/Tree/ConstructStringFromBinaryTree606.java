package Tree;

import java.util.Stack;

import org.junit.Test;

/**
 * @author he.wu You need to construct a string consists of parenthesis and
 *         integers from a binary tree with the preorder traversing way.
 * 
 *         The null node needs to be represented by empty parenthesis pair "()".
 *         And you need to omit all the empty parenthesis pairs that don't
 *         affect the one-to-one mapping relationship between the string and the
 *         original binary tree.
 * 
 * 
 *         Example 1: Input: Binary tree: [1,2,3,4] 1 / \ 2 3 / 4
 * 
 *         Output: "1(2(4))(3)"
 * 
 *         Explanation: Originallay it needs to be "1(2(4)())(3()())", but you
 *         need to omit all the unnecessary empty parenthesis pairs. And it will
 *         be "1(2(4))(3)". Example 2: Input: Binary tree: [1,2,3,null,4] 1 / \
 *         2 3 \ 4
 * 
 *         Output: "1(2()(4))(3)"
 * 
 *         Explanation: Almost the same as the first example, except we can't
 *         omit the first parenthesis pair to break the one-to-one mapping
 *         relationship between the input and the output.
 * 
 */
public class ConstructStringFromBinaryTree606 {
	// recursion
	public String tree2str(TreeNode t) {
		if (t == null)
			return "";
		if (t.left == null && t.right == null)
			return t.val + "";
		// only one node has value
		if (t.left == null)
			return t.val + "()" + "(" + tree2str(t.right) + ")";
		if (t.right == null)
			return t.val + "(" + tree2str(t.left) + ")";
		return t.val + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";
	}

	// iterative dfs preorder
	public String tree2str2(TreeNode root) {
		if (root == null)
			return "";
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		StringBuilder sb = new StringBuilder();
		Stack<TreeNode> visit = new Stack<TreeNode>();
		while (!stack.isEmpty()) {
			root = stack.peek();
			if (visit.contains(root)) {
				stack.pop();
				sb.append(")");
			} else {
				visit.add(root);
				sb.append("(" + root.val);
				if (root.left == null && root.right != null)
					sb.append("()");
				//fist in last out, so right before left
				if (root.right != null) 
					stack.push(root.right);
				if (root.left != null)
					stack.push(root.left);
			}
		}
		return sb.substring(1, sb.length() - 1);
	}
	
	@Test
	public void test() {
		TreeNode p = new TreeNode(3);
		TreeNode p1 = new TreeNode(9);
		TreeNode p2 = new TreeNode(20);
		TreeNode p3 = new TreeNode(15);
		TreeNode p4 = new TreeNode(7);
		p.left = p1;
		p.right = p2;
		p2.left = p3;
		p2.right = p4;
		System.out.println(tree2str2(p));
	}
}
