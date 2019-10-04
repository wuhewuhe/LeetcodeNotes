package Array;

/**
 * @author he.wu
 * 
 *         Given n non-negative integers a1, a2, ..., an , where each represents
 *         a point at coordinate (i, ai). n vertical lines are drawn such that
 *         the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
 *         which together with x-axis forms a container, such that the container
 *         contains the most water.
 * 
 *         Note: You may not slant the container and n is at least 2.1
 */
public class ContainerWithMostWater11 {
	public int maxArea(int[] height) {
		if (height == null || height.length < 2)
			return 0;
		else {
			int left = 0, right = height.length - 1, area = 0;
			while(left<right) {
				area = Math.max(area, Math.min(height[left], height[right])*(right-left));
				if(height[left] < height[right])
					left++;
				else 
					right--;
				return area;
			}
		}
		return 0;
	}
	
	public int maxArea2(int[] height) {
        int maxarea = 0;
        for (int i = 0; i < height.length; i++)
            for (int j = i + 1; j < height.length; j++)
                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
        return maxarea;
    }
}
