package Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/**
 * @author he.wu Serialization is the process of converting a data structure or
 *         object into a sequence of bits so that it can be stored in a file or
 *         memory buffer, or transmitted across a network connection link to be
 *         reconstructed later in the same or another computer environment.
 * 
 *         Design an algorithm to serialize and deserialize a binary search
 *         tree. There is no restriction on how your
 *         serialization/deserialization algorithm should work. You just need to
 *         ensure that a binary search tree can be serialized to a string and
 *         this string can be deserialized to the original tree structure.
 * 
 *         The encoded string should be as compact as possible.
 * 
 *         Note: Do not use class member/global/static variables to store
 *         states. Your serialize and deserialize algorithms should be
 *         stateless.
 */
public class SerializeandDeserializeBST449 {
	 // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    
    public void serialize(TreeNode root, StringBuilder sb) {
        if (root != null) {
        	   sb.append(root.val).append(",");
               serialize(root.left, sb);
               serialize(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public TreeNode deserialize(Queue<String> q, int lower, int upper) {
        if (q.isEmpty()) return null;
        String s = q.peek();
        int val = Integer.parseInt(s);
        if (val < lower || val > upper) return null;
        q.poll();
        TreeNode root = new TreeNode(val);
        root.left = deserialize(q, lower, val);
        root.right = deserialize(q, val, upper);
        return root;
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
		System.out.println(serialize(p));
		System.out.println(deserialize(serialize(p)));
	}
}
