class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        int n = digits.length-1;
        for(int i=n;i>=0;i--){
            if(digits[i]<9){
                if(carry!=0){
                    digits[i] = digits[i]+carry;
                    carry = 0;
                }
                else
                    digits[i] = digits[i]+1;
                break;
            }else{
                if(carry!=0){
                    carry = (digits[i]+carry)/10;
                }else{
                    carry = (digits[i]+1)/10;
                }
                digits[i] = 0;
            }
        }
        if(carry!=0){
            int res[] = new int[digits.length+1];
            res[0] = carry;
            for(int i=0;i<=n;i++){
                res[i+1] = digits[i];
            }
            return res;
        }
        return digits;
    }
}
