class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        for(int i=n-1;i>=0;i--){
            int endPoint = Circuit(gas,cost,n,i);
            if(endPoint == i)
                return endPoint;
        }
        return -1;
    }
    public static int Circuit(int gas[],int cost[],int n,int idx){
        int fuel = gas[idx];
        int startPoint = idx;
        while(fuel>=cost[idx]){
            fuel-=cost[idx];
            idx=(idx+1)%n;
            if(idx==startPoint)
                return idx;  
            fuel+=gas[idx];
           
        }
        return -1;
    }
}
