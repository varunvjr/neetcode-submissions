class Solution {
    public int trap(int[] height) {
        int water = 0;
        if(height.length==0)
            return water;
        int lmax = height[0];
        int rmax = height[height.length-1];
        int l = 0;
        int r = height.length-1;
        while(l<r){
            if(lmax<rmax){
                l++;
                lmax = Math.max(height[l],lmax);
                water+=lmax-height[l];
            }else{
                r--;
                rmax = Math.max(height[r],rmax);
                water+=rmax-height[r];
            }
        }
        return water;
    }
}
