class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(i>0 && nums[i] == nums[i-1]) continue; //avoid dublicates
            int left = i+1;
            int right = n-1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if(sum > 0) right--;
                else if(sum < 0) left++;
                else{
                    List<Integer> arr = Arrays.asList(nums[i], nums[left], nums[right]);
                    ans.add(arr);
                    left++;right--;

                    while(left < right && nums[left] == nums[left-1]){ //avoid duplicates
                        left++;
                    }
                    while(left < right && nums[right] == nums[right+1]){ //avoid duplicates
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}
