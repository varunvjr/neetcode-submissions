class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer>map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),i);
        }
        int size = 0;
        int end = 0;
        List<Integer>res = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            size++;
            int lastPos = map.get(s.charAt(i));
            end = Math.max(end,lastPos);
            if(i==end){
                res.add(size);
                size = 0;
            }
        }
        return res;
    }
}
