class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length())
            return "";
        HashMap<Character,Integer>map = new HashMap<>();
        for(char ch:t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int substart = 0;
        int len = s.length()+1;
        int match = 0;
        int winStart = 0;
        for(int winEnd = 0;winEnd<s.length();winEnd++){
            char rightChar = s.charAt(winEnd);
            if(map.containsKey(rightChar)){
                map.put(rightChar,map.get(rightChar)-1);
                if(map.get(rightChar)==0){
                    match++;
                }
            }
            while(map.size()==match){
                char leftChar = s.charAt(winStart);
                if(map.containsKey(leftChar)){
                    substart = winStart;
                    if(len>winEnd-winStart+1){
                        len = winEnd - winStart+1;
                    }
                    if(map.get(leftChar)==0){
                        match--;
                    }
                    map.put(leftChar,map.get(leftChar)+1);
                }
                winStart++;
            }
        }
        return len>s.length()?"":s.substring(substart,len+substart);
    }
}
