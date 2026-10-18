class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>result = new ArrayList<>();
        subset(result,s,0,new ArrayList<>());
        return result;
    }
    public void subset(List<List<String>>result,String s,int idx,List<String>temp){
        if(idx==s.length()){
            if(!result.contains(temp))
                result.add(new ArrayList<>(temp));
            return;
        }
        for(int i = idx;i<s.length();i++){
            String str = s.substring(idx,i+1);
            if(isPalin(str)){
                temp.add(str);
                subset(result,s,i+1,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    private boolean isPalin(String str){
        int left = 0;
        int right = str.length()-1;
        while(left<right){
            if(str.charAt(left)!=str.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
