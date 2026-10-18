class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer>st=new Stack<Integer>();
        int idx=0,max=0;
        while(idx<heights.length){
            if(st.isEmpty()||heights[st.peek()]<=heights[idx]){
                st.push(idx);
                idx++;
            }else{
                int pos=st.pop();
                int h=heights[pos];
                int w=st.isEmpty()?idx:(idx-st.peek()-1);
                max=Math.max(max,h*w);
            }
        }
        while(!st.isEmpty()){
            int pos=st.pop();
            int h=heights[pos];
            int w=st.isEmpty()?idx:(idx-st.peek()-1);
            max=Math.max(max,h*w);
        }
        return max;
    }
}