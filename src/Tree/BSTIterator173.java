package Tree;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.Test;

/**
 * @author he.wu Implement an iterator over a binary search tree (BST). Your
 *         iterator will be initialized with the root node of a BST.
 * 
 *         Calling next() will return the next smallest number in the BST.
 * 
 * 
 * 
 *         Example:
 * 
 * 
 * 
 *         BSTIterator iterator = new BSTIterator(root); iterator.next(); //
 *         return 3 iterator.next(); // return 7 iterator.hasNext(); // return
 *         true iterator.next(); // return 9 iterator.hasNext(); // return true
 *         iterator.next(); // return 15 iterator.hasNext(); // return true
 *         iterator.next(); // return 20 iterator.hasNext(); // return false
 * 
 * 
 *         Note:
 * 
 *         next() and hasNext() should run in average O(1) time and uses O(h)
 *         memory, where h is the height of the tree. You may assume that next()
 *         call will always be valid, that is, there will be at least a next
 *         smallest number in the BST when next() is called.
 */
public class BSTIterator173 {
	class BSTIterator {

		private ArrayList<Integer> nodesSorted;
		private int index;

		public BSTIterator(TreeNode root) {

			// Array containing all the nodes in the sorted order
			this.nodesSorted = new ArrayList<Integer>();

			// Pointer to the next smallest element in the BST
			this.index = -1;

			// Call to flatten the input binary search tree
			this._inorder(root);
		}

		private void _inorder(TreeNode root) {

			if (root == null) {
				return;
			}

			this._inorder(root.left);
			this.nodesSorted.add(root.val);
			this._inorder(root.right);
		}

		/**
		 * @return the next smallest number
		 */
		public int next() {
			int i = this.nodesSorted.get(++this.index);
			System.out.println(i);
			return i;
		}

		/**
		 * @return whether we have a next smallest number
		 */
		public boolean hasNext() {
			boolean bool = this.index + 1 < this.nodesSorted.size();
			System.out.println(bool);
			return bool;
		}
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
		BSTIterator iterator = new BSTIterator(p);
		iterator.next(); // return 3
		iterator.next(); // return 7
		iterator.hasNext(); // return true
		iterator.next(); // return 9
		iterator.hasNext(); // return true
		iterator.next(); // return 15
		iterator.hasNext(); // return true
		iterator.next(); // return 20
		iterator.hasNext(); // return false
	}
	
	
	class BSTIteratorStack {

		  private Stack<TreeNode> stack;
		    public BSTIteratorStack(TreeNode root) {
		        stack = new Stack<>();
		        TreeNode cur = root;
		        while(cur != null){
		            stack.push(cur);
		            if(cur.left != null)
		                cur = cur.left;
		            else
		                break;
		        }
		    }

		    /** @return whether we have a next smallest number */
		    public boolean hasNext() {
		        return !stack.isEmpty();
		    }

		    /** @return the next smallest number */
		    public int next() {
		        TreeNode node = stack.pop();
		        TreeNode cur = node;
		        // traversal right branch
		        if(cur.right != null){
		            cur = cur.right;
		            while(cur != null){
		                stack.push(cur);
		                if(cur.left != null)
		                    cur = cur.left;
		                else
		                    break;
		            }
		        }
		        return node.val;
		    }
		}
}
