class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        
        while (left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];
            int width = right - left;
            
            if (leftHeight < rightHeight) {
                int area = leftHeight * width;
                if (area > maxArea) maxArea = area;
                left++;
            } else {
                int area = rightHeight * width;
                if (area > maxArea) maxArea = area;
                right--;
            }
        }
        
        return maxArea;
    }
}