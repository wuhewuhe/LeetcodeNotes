package Tree;

/**
 * @author he.wu
 *Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1
Note:
The size of the given array will be in the range [1,1000].
 */
public class MaximamBinaryTree654 {

	public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null) {
            return null;
        }
        return constructMaxUtil(nums, 0, nums.length - 1);
    }
    
    public TreeNode constructMaxUtil(int[] nums, int low, int high) {
        if(low > high) {
            return null;
        }
        int max = Integer.MIN_VALUE, maxIndex = 0;
        for(int i = low; i <= high; i++) {
            maxIndex = nums[i] > max ? i : maxIndex;
            max = Math.max(max, nums[i]);
        }
        TreeNode root = new TreeNode(max);
        root.left = constructMaxUtil(nums, low, maxIndex - 1);
        root.right = constructMaxUtil(nums, maxIndex + 1, high);
        return root;
    }
	
	
}
