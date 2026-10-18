class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>map = new HashMap<>();
        List<List<String>>result = new ArrayList<>();
        for(String word:strs){
            char arr[] = word.toCharArray();
            Arrays.sort(arr);
            String temp = String.valueOf(arr);
            if(!map.containsKey(temp)){
                List<String>res  = new ArrayList<>();
                res.add(word);
                map.put(temp,res);
            }else{
                List<String>storedList = map.get(temp);
                storedList.add(word);
                map.put(temp,storedList);
            }
        }
        for(String key:map.keySet()){
            result.add(new ArrayList<>(map.get(key)));
        }
        return result;
    }
}
