class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do{
            slow = square(slow);
            fast = square(square(fast));
            if(slow!=1&&fast == slow)
                return false;
        }while(slow!=1);
        return true;

    }
    public int square(int num){
        int res = 0;
        while(num!=0){
            int rem = num%10;
            res+=Math.pow(rem,2);
            num = num/10;
        }
        return res;
    }
}
