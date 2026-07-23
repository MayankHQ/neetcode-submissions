class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hash = new HashSet<>();
        int longestStreak = 0;
        for(int num : nums){
            hash.add(num);
        }
        for(int val : hash){
            if(!hash.contains(val-1)){
                int curr = val;
                int currStreak = 1;
                while(hash.contains(curr + 1)){
                    currStreak++;
                    curr++;
                }
                longestStreak = Math.max(longestStreak, currStreak);
            }
        }
        return longestStreak;
    }
}
