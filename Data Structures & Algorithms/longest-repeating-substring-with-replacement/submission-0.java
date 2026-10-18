class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer>map = new HashMap<Character,Integer>();
        int winStart = 0;
        int freq = 0;
        int len = 0;
        for(int winEnd = 0;winEnd<s.length();winEnd++){
            char ch = s.charAt(winEnd);
            map.put(ch,map.getOrDefault(ch,0)+1);
            freq = Math.max(freq,map.get(ch));
            if(winEnd-winStart+1-freq>k){
                ch  = s.charAt(winStart++);
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0)
                    map.remove(ch);
            }
            len = Math.max(winEnd-winStart+1,len);
        }
        return len;
    }
}
