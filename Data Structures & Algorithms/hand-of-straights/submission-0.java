class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n%groupSize!=0)
            return false;
        TreeMap<Integer,Integer>map = new TreeMap<>();
        for(int ele:hand){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        while(!map.isEmpty()){
            List<Integer>temp = new ArrayList<>(map.keySet());
            int firstKey = temp.get(0);
            int k = groupSize;
            while(k>0){
                if(map.containsKey(firstKey)){
                    map.put(firstKey,map.get(firstKey)-1);
                    if(map.get(firstKey)==0)
                        map.remove(firstKey);
                  
                }else{
                    return false;
                }
                k--;
                firstKey++;
                System.out.println(firstKey);
            }
        }
        return true;
    }
}
