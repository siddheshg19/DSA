package DSA.Arrays;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prefix[] = new int[nums.length];
        int postfix[] = new int[nums.length];

        for(int i = 0, temp =1; i<nums.length; i++){
            prefix[i] = temp;
            temp *= nums[i];
        }

        for(int i = nums.length-1, temp = 1; i >= 0 ; i--){
            postfix[i] = temp;
            temp *= nums[i];
        }

        int res[] = new int[nums.length];
        for(int i =0; i< nums.length; i++){
            res[i] = prefix[i]*postfix[i];
        }
        return res;
    }
}