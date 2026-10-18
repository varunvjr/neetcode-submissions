class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character>set = new HashSet<>();
        int len = 0;
        StringBuilder sb = new StringBuilder();
        for(char ch:s.toCharArray()){
            if(set.contains(ch)){
                String temp = sb.toString();
                int idx = temp.indexOf(ch);
                sb.delete(0,idx+1);
            }
            sb.append(ch);
            set.add(ch);
            len = Math.max(len,sb.length());
        }
        return len;
    }
}
