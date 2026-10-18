class Solution {
    public int minEatingSpeed(int[] piles, int h) {
      
        int ans = -1;
        Arrays.sort(piles);
        int high = piles[piles.length-1];
        int low = 1;
        while(low<=high){
            int mid = low+(high-low)/2;
            long totalTime = 0;
            for(int pile:piles){
                totalTime += Math.ceil((double) pile / mid);
            }
            if(totalTime<=h){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}
