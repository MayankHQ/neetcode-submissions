class Solution {
    public void sortColors(int[] nums) {
        int zero = 0, one = 0, two = 0;
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] == 0) zero++;
            else if(nums[i] == 1) one++;
            else{
                two++;
            }
        }
        int count = 0;
        while(zero > 0){
            nums[count] = 0;
            count++;
            zero--;
        }
        while(one > 0){
            nums[count] = 1;
            count++;
            one--;
        }
        while(two > 0){
            nums[count] = 2;
            count++;
            two--;
        }
    }
}