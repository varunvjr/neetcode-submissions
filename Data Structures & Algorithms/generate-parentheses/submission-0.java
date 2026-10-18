class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>res = new ArrayList<>();
        generate(res,"",0,0,n);
        return res;
    }
    public static void generate(List<String>res,String temp,int open,int close,int n){
        if(temp.length()==n*2){
            res.add(temp);
            return;
        }
        if(open<n){
            generate(res,temp+"(",open+1,close,n);
        }
        if(close<open){
            generate(res,temp+")",open,close+1,n);
        }
    }
}
