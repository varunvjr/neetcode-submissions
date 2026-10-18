class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer>map = new HashMap<>();
        for(char ch:s1.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int winStart = 0;
        int match = 0;
        for(int winEnd = 0;winEnd<s2.length();winEnd++){
            char right = s2.charAt(winEnd);
            if(map.containsKey(right)){
                map.put(right,map.get(right)-1);
                if(map.get(right)==0){
                    match++;
                }
            }
            if(winEnd>=s1.length()-1){
                if(map.size()==match)
                    return true;
                char left = s2.charAt(winStart++);
                if(map.containsKey(left)){
                    if(map.get(left)==0)
                        match--;
                    map.put(left,map.get(left)+1);
                }
            }
        }
        return false;
    }
}
