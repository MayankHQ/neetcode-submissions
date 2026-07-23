class Solution {
    public String minWindow(String s, String t) {
        int[] hash = new int[128];
        for(char c : t.toCharArray()){
            hash[c]++;
        }
        int r = 0, l = 0, n = s.length(), m = t.length();
        int count = 0, minlen = (int)1e9, strtIdx = -1;
        while(r < n){
            if(hash[s.charAt(r)] > 0){
                count++;
            }
            hash[s.charAt(r)]--;

            while(count == m){
                if(r - l + 1 < minlen){
                    minlen = r-l+1;
                    strtIdx = l;
                }
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)] > 0){
                    count--;
                }
                l++;
            }
            r++;
        }
        return strtIdx == -1?"":s.substring(strtIdx, strtIdx+minlen);
    }
}

