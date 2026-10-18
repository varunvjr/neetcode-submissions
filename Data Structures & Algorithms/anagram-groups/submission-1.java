class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>>result = new ArrayList<>();
        HashMap<String,List<String>>map = new HashMap<>();
        for(String string:strs){
            char array[] = string.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            if(map.containsKey(key)){
                List<String>temp = map.get(key);
                temp.add(string);
                map.put(key,temp);
            }else{
                List<String>list = new ArrayList<>();
                list.add(string);
                map.put(key,list);
            }
        }
        for(List<String>value:map.values()){
            result.add(value);
        }
        return result;
    }
}
