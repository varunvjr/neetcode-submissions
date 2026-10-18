class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer>stack = new Stack<>();
        int res[] = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty()&&(temperatures[stack.peek()]<=temperatures[i]))
                stack.pop();
            int days = stack.isEmpty()?0:stack.peek()-i;
            res[i] = days;
            stack.push(i);
        }
        return res;

    }
}
