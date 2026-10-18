class Solution {
    public int lengthOfLongestSubstring(String s) {
        StringBuilder sb = new StringBuilder();
        int len = 0;
        HashSet<Character>set = new HashSet<>();
        for(char ch:s.toCharArray()){
            if(set.contains(ch)){
                int idx = sb.toString().indexOf(ch);
                sb.delete(0,idx+1);
            }
            sb.append(ch);
            set.add(ch);
            len = Math.max(len,sb.length());
        }
        return len;
    }
}
