class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int cache[][] = new int[text1.length()][text2.length()];
        for(int i = 0;i<text1.length();i++){
            for(int j = 0;j<text2.length();j++){
                cache[i][j] = -1;
            }
        }
        return dfs(text1,text2,cache,0,0);
    }
    private int dfs(String text1,String text2,int cache[][],int i,int j){
        if(i>=text1.length()||j>=text2.length())
            return 0;
        if(cache[i][j]!=-1)
            return cache[i][j];
        if(text1.charAt(i)==text2.charAt(j)){
            cache[i][j] = 1+dfs(text1,text2,cache,i+1,j+1);
        }else{
            cache[i][j] = Math.max(dfs(text1,text2,cache,i+1,j),dfs(text1,text2,cache,i,j+1));
        }
        return cache[i][j];
    }
}
