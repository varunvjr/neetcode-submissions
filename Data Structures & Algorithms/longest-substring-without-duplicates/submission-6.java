class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        HashSet<Character>set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(char ch:s.toCharArray()){
            if(!set.contains(ch)){
                set.add(ch);
            }else{
                int idx = sb.toString().indexOf(ch);
                sb.delete(0,idx+1);
            }
            sb.append(ch);
            maxLen = Math.max(maxLen,sb.length());
        }
        return maxLen;
    }
}
