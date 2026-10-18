class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s:strs){
            int len=s.length();
            sb.append(len+"#"+s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i=0;
        int n = str.length();
        while(i<n){
            int j = i;
            while(str.charAt(j)!='#'){
                j++;
            }
            int len = Integer.parseInt(str.substring(i,j));
            result.add(str.substring(j+1,j+1+len));
            i=j+1+len;
        }
        return result;
    }
}
