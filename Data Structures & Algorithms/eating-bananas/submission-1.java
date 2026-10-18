class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 1;
        for(int pile:piles){
            high = Math.max(high,pile);
        }
        int ans = high;
        while(low<=high){
            int mid = low+(high-low)/2;
            int totalHours = 0;
            for(int pile:piles){
                totalHours+= Math.ceil((double)pile/mid);
            }
            if(totalHours<=h){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}
