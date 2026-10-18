class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int res[][] = new int[position.length][2];
        for(int i=0;i<position.length;i++){
            res[i][0] = position[i];
            res[i][1] = speed[i];
        }
        Arrays.sort(res,(a,b)->b[0]-a[0]);
        Stack<Double>st = new Stack<>();
        for(int ele[]:res){
            int pos = ele[0];
            int spd = ele[1];
            double time = (double)(target-pos)/spd;
            st.push(time);
            if(st.size()>=2&&st.peek()<=st.get(st.size()-2))
                st.pop();
        }
        return st.size();
    }
}
