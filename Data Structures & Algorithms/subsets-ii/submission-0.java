class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> sub = new ArrayList<>();
        Set<List<Integer>> hash = new HashSet<>();
        subseq(hash, sub, nums, 0);
        return new ArrayList<>(hash);
    }

    public static void subseq(Set<List<Integer>> hash, List<Integer> p, int[] arr, int index) {
        if (index == arr.length) {
            List<Integer> nava = new ArrayList<>(p);
            Collections.sort(nava);
            hash.add(nava);
            return;
        }
        // Include current element
        p.add(arr[index]);
        subseq(hash, p, arr, index + 1);
        
        // Exclude current element
        p.remove(p.size() - 1);
        subseq(hash, p, arr, index + 1);
    }
}
