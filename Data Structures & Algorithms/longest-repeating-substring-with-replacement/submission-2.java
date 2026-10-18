class Solution {
    public int characterReplacement(String s, int k) {
        int winStart = 0;
        int maxFreq = 0;
        int len = 0;
        HashMap<Character,Integer>map = new HashMap<>();
        for(int winEnd = 0; winEnd<s.length();winEnd++){
            char right = s.charAt(winEnd);
            map.put(right,map.getOrDefault(right,0)+1);
            maxFreq = Math.max(maxFreq,map.get(right));
            if(winEnd-winStart+1-maxFreq>k){
                char left = s.charAt(winStart++);
                map.put(left,map.get(left)-1);
            }
            len = Math.max(len,winEnd-winStart+1);
        }
        return len;
    }
}
