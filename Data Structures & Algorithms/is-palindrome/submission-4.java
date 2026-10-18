class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        s = s.toLowerCase();
        if(left==right)
            return true;
        char array[] = s.toCharArray();
        while(left<right){
            while(left<=right&&!Character.isLetterOrDigit(s.charAt(left)))
                left++;
            while(right>=left&&!Character.isLetterOrDigit(s.charAt(right)))
                right--;
            if(left>right)
                break;
            if(s.charAt(left)!=s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
