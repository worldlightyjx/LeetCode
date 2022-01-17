class Solution {
   public int maxArea(int[] height) {
	        int left = 0;
	        int right = height.length - 1;
	        int area = (right - left)*Math.min(height[left], height[right]);
	        while(left<right) {
	        	int tmp_area = (right - left)*Math.min(height[left], height[right]);
	        	if(tmp_area>area) {
	        		area = tmp_area;
	        	}
	        	if(height[left]<height[right])
	        		left++;
	        	else
	        		right--;
	        }
	        return area;
	        
	    }
}