class Solution {
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        StringBuilder s = new StringBuilder(m+n);
        int i = 0, j = 0, k = 0;

        while(i < m && j < n){
            s.append(word1.charAt(i));
            s.append(word2.charAt(j));
            i++;
            j++;
        }
        if(i < m) s.append(word1.substring(i));
        if(j < n) s.append(word2.substring(j));

        return s.toString();
    }
}