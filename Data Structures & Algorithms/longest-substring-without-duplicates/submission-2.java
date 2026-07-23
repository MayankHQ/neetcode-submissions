class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> hash = new HashMap<>();
        int left = 0;
        int n = s.length();
        int longest = 0;
        for(int right = 0; right<n; right++){
            char a = s.charAt(right);
            if(hash.containsKey(a)){
                left = Math.max(left, hash.get(a)+1);
            }
            hash.put(a, right);
            longest = Math.max(longest, right-left+1);
        }
        return longest;
    }
    // public int lengthOfLongestSubstring(String s) {
    //     Set<Character> hash = new HashSet<>();
    //     int left = 0;
    //     int n = s.length();
    //     int longest = 0;
    //     for(int right = 0; right<n; right++){
    //         char a = s.charAt(right);
    //         while(hash.contains(a)){
    //             hash.remove(s.charAt(left));
    //             left++;
    //         }
    //         hash.add(a);
    //         longest = Math.max(longest, right-left+1);
    //     }
    //     return longest;
    // }
}
