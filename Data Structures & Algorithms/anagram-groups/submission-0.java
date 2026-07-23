class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> finalAns = new ArrayList<>();
        boolean[] isVisited = new boolean[strs.length];
        for(int i = 0; i < strs.length; i++){
            if(isVisited[i]) continue;
            String str = strs[i];
            List<String> ans = new ArrayList<>();
            ans.add(str);
            isVisited[i] = true;

            for(int j = i+1; j < strs.length; j++){
                String arr = strs[j];
                if((!isVisited[j]) && (isAnagram(str,arr))){
                    ans.add(arr);
                    isVisited[j] = true;
                }
                
            }
            finalAns.add(ans);
        }
        return finalAns;

    }
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
