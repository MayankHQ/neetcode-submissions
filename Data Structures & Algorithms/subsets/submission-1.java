class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> subsets(int[] nums) {
        list = new ArrayList<>();
        recurse(new ArrayList<>(), 0, nums);
        return list;
    }
    public void recurse(List<Integer> res, int idx, int[] arr){
        if(idx == arr.length){
            list.add(new ArrayList<>(res));
            return;
        }

        res.add(arr[idx]);
        recurse(res, idx+1, arr);

        res.remove(res.size() - 1);
        recurse(res, idx+1, arr);
    }
}
