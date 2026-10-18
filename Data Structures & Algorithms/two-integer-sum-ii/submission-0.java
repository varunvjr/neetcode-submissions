class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int res[] = new int[2];
        int i = 0;
        int j = numbers.length-1;
        while(i<j){
            int csum = numbers[i]+numbers[j];
            if(csum==target){
                res[0] = i+1;
                res[1] = j+1;
                break;
            }else if(csum<target){
                i++;
            }else{
                j--;
            }
        }
        return res;
    }
}
