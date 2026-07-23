class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> sub = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        subseq(result, sub, nums, 0);
        return result;
    }

    public static void subseq(List<List<Integer>> result, List<Integer> p, int[] arr, int index) {
        result.add(new ArrayList<>(p));
        
        for(int i = index; i < arr.length; i++){
            if(i != index && arr[i] == arr[i-1]) continue;

            p.add(arr[i]);
            subseq(result, p, arr, i + 1);
            p.remove(p.size() - 1);
        }

    }
}
