class Solution {
    public boolean isValid(String s) {
        HashMap<Character,Integer>map = new HashMap<>();
        map.put('(',1);
        map.put(')',-1);
        map.put('{',2);
        map.put('}',-2);
        map.put('[',3);
        map.put(']',-3);
        Stack<Character>st = new Stack<>();
        char arr[] = s.toCharArray();
        for(char ch:arr){
            if(st.isEmpty()){
                if(map.get(ch)<0)
                    return false;
            }
            if(map.get(ch)>0)
                st.push(ch);
            else{
                if(map.get(st.peek())+map.get(ch)!=0)
                    return false;
                st.pop();
            }
        }
        return st.isEmpty()?true:false;
    }
}
