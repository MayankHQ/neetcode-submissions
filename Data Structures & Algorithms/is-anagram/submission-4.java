class Solution {
    public boolean isAnagram(String s, String t) {
        int sn = s.length();
        int tn = t.length();
        int[] hash = new int[26];

        if(sn != tn) return false;
        for(int i = 0; i < sn; i++){
            hash[s.charAt(i) - 'a']++;
            hash[t.charAt(i) - 'a']--;
        }

        for(int i = 0; i < hash.length; i++){
            if(hash[i] != 0) return false;
        }
        return true;
    }
}
