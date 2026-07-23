class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hash = new HashMap<>();
        int[] arr = new int[k];
        for(int i = 0; i < nums.length; i++){
            hash.put(nums[i], hash.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer> ans = new ArrayList<>(hash.keySet());
        ans.sort((a,b) -> hash.get(b) - hash.get(a));

        for(int i = 0; i < k; i++){
            arr[i] = ans.get(i);
        }
        return arr;
    }
}
