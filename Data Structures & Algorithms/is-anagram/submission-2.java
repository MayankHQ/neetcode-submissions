class Solution {
    public boolean isAnagram(String s, String t) {
        int[] hash = new int[26];
        for(char ch : s.toCharArray()){
            hash[ch-'a']++;
        }
        for(char sh : t.toCharArray()){
            hash[sh-'a']--;
        }
        for(int i = 0; i < hash.length; i++){
            if(hash[i] != 0){
                return false;
            }
        }
        return true;
    }
}
