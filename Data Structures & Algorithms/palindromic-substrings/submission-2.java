class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i=0;i<s.length();i++){
            int p1 = expandFromMiddle(s,i,i);
            int p2 = expandFromMiddle(s,i,i+1);
            count+= p1+p2;
        }
        return count;
    }
    private int expandFromMiddle(String s,int left,int right){
        int count = 0;
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
            count++;
        }
        return count;
    }
}
