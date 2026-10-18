class Solution {
    public int maxProfit(int[] prices) {
        int profit  = Integer.MIN_VALUE;
        int buy = prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]<buy){
                buy = prices[i];
            }else{
                profit = Math.max(profit,prices[i]-buy);
            }
        }
        return profit==Integer.MIN_VALUE?0:profit;
    }
}
