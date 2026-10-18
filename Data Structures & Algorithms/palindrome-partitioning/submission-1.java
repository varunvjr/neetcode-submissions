class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>result = new ArrayList<>();
        subsets(s,result,new ArrayList<>(),new StringBuilder(),0);
        return result;
    }
    public void subsets(String s,List<List<String>>result,List<String>temp,StringBuilder sb,int idx){
        if(idx==s.length()){
            if(!result.contains(temp)){
                result.add(new ArrayList<>(temp));
            }
            return;
        }
        for(int i=idx;i<s.length();i++){
            String t = s.substring(idx,i+1);
            if(isPalin(t)){
                temp.add(t);
                subsets(s,result,temp,sb,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
    public boolean isPalin(String s){
        int left = 0;
        int right = s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
