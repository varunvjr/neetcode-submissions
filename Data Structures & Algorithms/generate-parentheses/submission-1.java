class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>result = new ArrayList<>();
        subset(n,result,"",0,0);
        return result;
    }
    public void subset(int n,List<String>result,String temp,int open, int close){
        if(temp.length()==2*n){
            result.add(temp);
            return;
        }
        if(open<n){
            subset(n,result,temp+"(",open+1,close);
        }
        if(close<open){
            subset(n,result,temp+")",open,close+1);
        }
    }
}
