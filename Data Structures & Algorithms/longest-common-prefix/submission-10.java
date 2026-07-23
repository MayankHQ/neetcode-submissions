class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        // StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs[0].length(); i++){
            char ch = strs[0].charAt(i);
            for(String s : strs){
                if(i == s.length() || s.charAt(i) != ch){
                    return s.substring(0, i);
                }     
            }
            // sb.append(ch);
        }
        return strs[0];
    }
}