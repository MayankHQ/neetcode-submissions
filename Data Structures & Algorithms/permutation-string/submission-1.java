class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n > m) return false;
        int[] winF = new int[26];
        int[] patF = new int[26];

        for(int i = 0; i < n; i++){
            winF[s2.charAt(i)-'a']++;
            patF[s1.charAt(i)-'a']++;
        }
        if(Arrays.equals(winF, patF)) return true;

        for(int i = n; i < m; i++){
            winF[s2.charAt(i)-'a']++;
            winF[s2.charAt(i-n)-'a']--;
            if(Arrays.equals(winF, patF)) return true;
        }
        return false;
    }
}
