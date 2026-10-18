class Solution {
    public int maxArea(int[] heights) {
        int maxarea = 0;
        int left = 0;
        int right = heights.length-1;
        while(left<right){
            int width;
            int height;
            if(heights[left]<heights[right]){
                height = heights[left];
                width = right-left;
                left++;
            }else{
                height = heights[right];
                width = right-left;
                right--;
            }
            maxarea = Math.max(maxarea,width*height);
        }
        return maxarea;
    }
}
