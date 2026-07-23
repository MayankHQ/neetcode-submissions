class Solution {
    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        int n = s.length();
        int l = 0, r = 0;
        int[] counts = new int[26];
        int maxFreq = 0;

        while (r < s.length()){
             // Frequency map for characters A-Z
            counts[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, counts[s.charAt(r) - 'A']);

            if((r - l + 1) - maxFreq > k){
                counts[s.charAt(l) - 'A']--;
                l++;
            }
            if((r-l+1) - maxFreq <= k){
                maxLength = Math.max(maxLength, r-l+1);
            }
            r++;
        }
        return maxLength;
    }
}