class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        for(int i=0;i<s.length();i++){
            int left = i;
            int right = i;
            res+=countPalin(s,left,right);
            left = i;
            right = i+1;
            res+=countPalin(s,left,right);  //even length string count
        }
        return res;
    }
    public int countPalin(String s,int left,int right){
        int count = 0;
        while(left>=0&&right<s.length()){
            if(s.charAt(left)==s.charAt(right)){
                count++;
                left--;
                right++;
            }else
                break;
        }
        return count;
    }
}
