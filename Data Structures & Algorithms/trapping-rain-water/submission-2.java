class Solution {
    public int trap(int[] height) {
        if(height==null||height.length==0)
            return 0;
        int l = 0;
        int r = height.length-1;
        int water = 0;
        int leftmax = height[l];
        int rightmax = height[r];
        while(l<r){
            if(leftmax<rightmax){
                l++;
                leftmax = Math.max(leftmax,height[l]);
                water+= leftmax-height[l];
            }else{
                r--;
                rightmax = Math.max(rightmax,height[r]);
                water+= rightmax-height[r];
            }
        }
        return water;
        
    }
}
