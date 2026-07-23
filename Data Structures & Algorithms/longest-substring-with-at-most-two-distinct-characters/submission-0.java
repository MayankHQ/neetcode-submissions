class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        //your code goes here
        Map<Character, Integer> hash = new HashMap<>();
        int left = 0, maxLen = 0;
        for(int right = 0; right < s.length(); right++){
            hash.put(s.charAt(right), hash.getOrDefault(s.charAt(right), 0) + 1);
            if(hash.size() > 2){
                hash.put(s.charAt(left), hash.getOrDefault(s.charAt(left), 0) - 1);
                if(hash.get(s.charAt(left)) == 0) hash.remove(s.charAt(left));
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}