class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(char ch:s.toCharArray()){
            if(Character.isLetter(ch)||Character.isDigit(ch)){
                sb.append(ch);
            }
        }
        String temp = sb.toString();
        String res = sb.reverse().toString();
        if(temp.equals(res))
            return true;
        return false;
    }
}
