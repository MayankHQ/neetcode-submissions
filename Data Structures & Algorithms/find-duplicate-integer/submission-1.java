class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> hash = new HashSet<>();
        for(int num : nums){
            if(hash.contains(num)){
                return num;
            }
            hash.add(num);
        }
        return -1;
    }
}
