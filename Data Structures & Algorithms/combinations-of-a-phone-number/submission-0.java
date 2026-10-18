class Solution {
    public List<String> letterCombinations(String digits) {
        String numpad[] = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String>result = new ArrayList<>();
        if(digits.length()==0)
            return result;
        subset(numpad,result,new StringBuilder(),0,digits);
        return result;
    }
    public void subset(String numpad[],List<String>result,StringBuilder temp,int idx,String digits){
        if(temp.length()==digits.length()){
            String s = temp.toString();
            if(!result.contains(s))
                result.add(s);
            return;
        }
        String number = numpad[digits.charAt(idx)-'0'];
        for(int i=0;i<number.length();i++){
            char ch = number.charAt(i);
            temp.append(ch);
            subset(numpad,result,temp,idx+1,digits);
            temp.deleteCharAt(temp.length()-1);
        }
        
    }
}
