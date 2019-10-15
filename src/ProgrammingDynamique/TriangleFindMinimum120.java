package ProgrammingDynamique;

import java.util.List;

/**
 * @author mac Given a triangle, find the minimum path sum from top to bottom.
 *         Each step you may move to adjacent numbers on the row below.
 * 
 *         For example, given the following triangle
 * 
 *         [ [2], [3,4], [6,5,7], [4,1,8,3] ]
 */
public class TriangleFindMinimum120 {
	public int minimumTotal(List<List<Integer>> triangle) {
		return findMinPath(triangle, 0, Integer.MAX_VALUE, 0, 0);
	}

	public int findMinPath(List<List<Integer>> triangle, int curSum, int min, int index, int level) {
		curSum += triangle.get(level).get(index);
		if (level == triangle.size() - 1)
			return Math.min(min, curSum);
		return Math.min(findMinPath(triangle, curSum, min, index, level + 1),
				findMinPath(triangle, curSum, min, index + 1, level + 1));
	}
	
	//dp
	public int minimumTotal2(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()+1];
        for(int i = triangle.size() - 1; i >= 0; i--)
            for(int j = 0; j < triangle.get(i).size(); j++)
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
        return dp[0];
    }


}
