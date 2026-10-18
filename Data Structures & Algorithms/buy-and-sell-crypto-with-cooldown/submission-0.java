class Solution {
    private HashMap<String,Integer>map = new HashMap<>();
    public int maxProfit(int[] prices) {
        return dfs(0,true,prices);
    }
    public int dfs(int i,boolean buy,int prices[]){
        if(i>=prices.length)
            return 0;
        String key = i+"-"+buy;
        if(map.containsKey(key))
            return  map.get(key);

        int cooldown = dfs(i+1,buy,prices);
        if(buy){
            int buying = dfs(i+1,false,prices)-prices[i];
            map.put(key,Math.max(buying,cooldown));
        }else{
            int sell = dfs(i+2,true,prices)+prices[i];
            map.put(key,Math.max(sell,cooldown));
        }
        return map.get(key);
        
    }

}
