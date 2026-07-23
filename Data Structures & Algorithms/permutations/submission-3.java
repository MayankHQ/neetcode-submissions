class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        recurse(nums, 0);
        return res;
    }
    public void recurse(int[] nums, int idx){
        if(idx == nums.length){
            List<Integer> arr = new ArrayList<>();
            for(int n : nums) arr.add(n);
            res.add(arr);
            return;
        }

        for(int i = idx; i < nums.length; i++){
            swap(nums, i, idx);
            recurse(nums, idx+1);
            swap(nums, i, idx);
        }
    }
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
