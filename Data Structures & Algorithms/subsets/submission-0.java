class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List <List<Integer>> result = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        subseq(result, sub, nums, 0);
        return result;
    }

    public static void subseq(List<List<Integer>> res, List<Integer> p, int[] arr, int index) {
        if (index == arr.length) {
            res.add(new ArrayList<>(p));
            return;
        }
        // Include current element
        p.add(arr[index]);
        subseq(res, p, arr, index + 1);
        
        // Exclude current element
        p.remove(p.size() - 1);
        subseq(res, p, arr, index + 1);
    }

}
