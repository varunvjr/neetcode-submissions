class Solution {
    public boolean checkValidString(String s) {
        if(s.length()<2)
            return false;
        return dfs(s,0,0);
    }
    public boolean dfs(String s,int open,int idx){
        if(open<0)
            return false;
        if(idx==s.length())
            return open==0;
      
        if(s.charAt(idx)=='('){
            return dfs(s,open+1,idx+1);
        }else if(s.charAt(idx)==')'){
            return dfs(s,open-1,idx+1);
        }else{
            return dfs(s,open+1,idx+1)||dfs(s,open-1,idx+1)||dfs(s,open,idx+1);
        }
    }
}
