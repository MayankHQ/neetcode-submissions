class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];
        int n = s.length(), l = 0, r = 0, maxlen = 0;
        while(r < n){
            char a = s.charAt(r);
            freq[a]++;
            while(freq[a] > 1){
                freq[s.charAt(l)]--;
                l++;
            }
            maxlen = Math.max(maxlen, r - l + 1);
            r++;
        }
        return maxlen;
    }
}
