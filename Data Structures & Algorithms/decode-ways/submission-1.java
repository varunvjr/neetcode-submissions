class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return dfs(dp,0,s);
    }
    public int dfs(int dp[],int i,String s){
        if(i==s.length())
            return 1;
        if(s.charAt(i)=='0')
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        dp[i] = dfs(dp,i+1,s);
        if(i+1<s.length()&&(s.charAt(i)=='1'||(s.charAt(i)=='2'&&s.charAt(i+1)<='6'))){
            dp[i]+= dfs(dp,i+2,s);
        }
        return dp[i];
    }
}
