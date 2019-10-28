package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author he.wu
 *Print a binary tree in an m*n 2D string array following these rules:

The row number m should be equal to the height of the given binary tree.
The column number n should always be an odd number.
The root node's value (in string format) should be put in the exactly middle of the first row it can be put. The column and the row where the root node belongs will separate the rest space into two parts (left-bottom part and right-bottom part). You should print the left subtree in the left-bottom part and print the right subtree in the right-bottom part. The left-bottom part and the right-bottom part should have the same size. Even if one subtree is none while the other is not, you don't need to print anything for the none subtree but still need to leave the space as large as that for the other subtree. However, if two subtrees are none, then you don't need to leave space for both of them.
Each unused space should contain an empty string "".
Print the subtrees following the same rules.
Example 1:
Input:
     1
    /
   2
Output:
[["", "1", ""],
 ["2", "", ""]]
Example 2:
Input:
     1
    / \
   2   3
    \
     4
Output:
[["", "", "", "1", "", "", ""],
 ["", "2", "", "", "", "3", ""],
 ["", "", "4", "", "", "", ""]]
Example 3:
Input:
      1
     / \
    2   5
   / 
  3 
 / 
4 
Output:

[["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
 */
public class PrintBinaryTree655 {
	public List<List<String>> printTree(TreeNode root) {
		int height = getHeight(root);
		String[][] res = new String[height][(1 << height) - 1];
		for(String[] arr : res)
			Arrays.fill(arr,"");
		List<List<String>> ans = new ArrayList<List<String>>();
		fill(res,root,0,0,res[0].length);
		for(String[] arr : res)
			ans.add(Arrays.asList(arr));
		return ans;
	}

	private void fill(String[][] res, TreeNode root, int height, int start, int end) {
		if (root == null)
			return;
		res[height][(start + end) / 2] = "" + root.val;
		fill(res, root.left, height + 1, start, (start + end) / 2);
		fill(res, root.right, height + 1, (start + end + 1) / 2, end);
	}

	private int getHeight(TreeNode root) {
		if (root == null)
			return 0;
		int left = getHeight(root.left);
		int right = getHeight(root.right);
		return Math.max(right, left) + 1;
	}

}
