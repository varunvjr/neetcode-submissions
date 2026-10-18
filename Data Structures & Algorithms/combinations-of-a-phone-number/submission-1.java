class Solution {
    public List<String> letterCombinations(String digits) {
        String keypad[] = {"0","1,","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String>result = new ArrayList<>();
        if(digits.length()==0)
            return result;
        subset(result,keypad,0,digits,new StringBuilder());
        return result;
    }
    private void subset(List<String>result,String keypad[],int idx,String digits,StringBuilder sb){
        if(sb.length()==digits.length()){
            String temp = sb.toString();
            if(!result.contains(temp))
                result.add(temp);
            return;
        }
        String digit = keypad[digits.charAt(idx)-'0'];
        for(int i=0;i<digit.length();i++){
            sb.append(digit.charAt(i));
            subset(result,keypad,idx+1,digits,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
