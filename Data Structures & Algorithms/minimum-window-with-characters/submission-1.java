
class Solution {
    public String minWindow(String s, String t) {
        
        int n = s.length();
        int m = t.length();
        int[] hash = new int[256];
        int strtIndex = -1;
        int minLen = (int)1e9;
        int cnt = 0;
        int l = 0, r = 0;
 
        for(int i = 0; i < m; i++){
            hash[t.charAt(i)]++;
        }
        while(r < n){
            if(hash[s.charAt(r)] > 0){
                cnt++;
            }
            hash[s.charAt(r)]--;

            while(cnt == m){
                if(r - l + 1 < minLen){
                    minLen = r-l+1;
                    strtIndex = l;
                }
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)] > 0){
                    cnt--;
                }
                l++;
            }
            r++;
        }
        if(strtIndex == -1) return "";
        return s.substring(strtIndex, strtIndex + minLen);
    }
    
}
