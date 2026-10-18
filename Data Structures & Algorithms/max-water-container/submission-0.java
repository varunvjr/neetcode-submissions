class Solution {
    public int maxArea(int[] heights) {
        int water = Integer.MIN_VALUE;
        int i = 0;
        int j = heights.length-1;
        while(i<j){
            int w;
            if(heights[i]<heights[j]){
                w = j-i;
                water= Math.max(water,heights[i]*w);
                i++;
            }else{
                w = j-i;
                water = Math.max(water,heights[j]*w);
                j--;
            }
        }
        return water;
    }
}
