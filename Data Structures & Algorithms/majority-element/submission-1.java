class Solution {
    public int majorityElement(int[] nums) {
        int maj = 0;
        int count = 0;
        for(int num : nums){
            if(count == 0){
                maj = num;
                count++;
            }
            else if(num == maj){
                count++;
            }
            else{
                count--;
            }
        }
        
        int cnt = 0;
        for(int num : nums){
            if(num == maj) cnt++;
            if(cnt > nums.length/2) return maj;
        }
        return -1;
    }
}