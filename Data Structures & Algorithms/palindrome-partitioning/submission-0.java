class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>result = new ArrayList<>();
        List<String>temp = new ArrayList<>();
        subset(result,temp,0,s);
        return result;
    }
    public void subset(List<List<String>>result,List<String>temp,int idx,String s){
        if(idx == s.length()){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx;i<s.length();i++){
            if(isPalin(s,idx,i)){
                temp.add(s.substring(idx,i+1));
                subset(result,temp,i+1,s);
                temp.remove(temp.size()-1);
            }
        }
    }
    public boolean isPalin(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
