class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int res[] = new int[n];
        int idx = n-1;
        Stack<Integer>st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&&temperatures[st.peek()]<=temperatures[i])
                st.pop();
            int val = st.isEmpty()?0:st.peek()-i;
            res[idx--] = val;
            st.push(i);
        }
        return res;
    }
}
