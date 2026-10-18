class Solution {
    public int t;
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean cache[] = new Boolean[s.length()];
        t = 0;
        for(String s1 : wordDict){
            t = Math.max(t,s1.length());
        }
        return dfs(s,cache,wordDict,0);
    }
    public boolean dfs(String s,Boolean cache[],List<String>dict,int idx){
        if(idx==s.length()){
            return true;
        }
        if(cache[idx]!=null)
            return cache[idx];
        for(int i=idx;i<Math.min(i+t,s.length());i++){
            String temp = s.substring(idx,i+1);
            if(dict.contains(temp)){
                if(dfs(s,cache,dict,i+1)){
                    cache[idx] = true;
                    return true;
                }
            }
        }
        cache[idx] = false;
        return false;
    }
}
