class Solution {
    public double myPow(double x, int n) {
        int times = Math.abs(n);
        if(n<0){
            x = 1/x;
        }
        double ans = 1.0;
        for(int i=0;i<times;i++){
            ans = ans*x;
            System.out.println(ans+" -- >"+i);
        }
        return ans;

    }
}
