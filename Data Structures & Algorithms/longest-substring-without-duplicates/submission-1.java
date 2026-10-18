class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character>set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        int len = 0;
        for(char ch:s.toCharArray()){
            if(set.contains(ch)){
                String temp = sb.toString();
                int idx = temp.indexOf(ch);
                sb.delete(0,idx+1);
                set.remove(ch);
            }
            set.add(ch);
            sb.append(ch);
            len = Math.max(len,sb.length());
        }
        return len;
        
    }
}
