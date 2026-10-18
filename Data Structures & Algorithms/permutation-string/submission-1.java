class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length())
            return false;
        int winStart = 0;
        HashMap<Character,Integer>map = new HashMap<>();
        for(char ch:s1.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int k = s1.length();
        int match = 0;
        for(int winEnd = 0;winEnd<s2.length();winEnd++){
            char ch = s2.charAt(winEnd);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0)
                    match++;
            }
            if(match==map.size())
                return true;
            if(winEnd>=k-1){
                ch = s2.charAt(winStart++);
                if(map.containsKey(ch)){
                    if(map.get(ch)==0)
                        match--;
                    map.put(ch,map.get(ch)+1);
                }
            }
        }
        return false;
    }
}
