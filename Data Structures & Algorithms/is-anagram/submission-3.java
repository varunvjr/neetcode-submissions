class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        char array1[] = s.toCharArray();
        char array2[] = t.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        String t1 = new String(array1);
        String t2 = new String(array2);
        return t1.equals(t2);
    }
}
