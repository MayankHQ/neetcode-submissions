class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        backtrack(0, s, new ArrayList<>());
        return res;
    }
    public void backtrack(int index, String s, List<String> path){
        if(index == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = index; i < s.length(); i++){
            if(isPalindrome(s, index, i)){
                path.add(s.substring(index, i+1));
                backtrack(i+1, s, path);
                path.remove(path.size() - 1);
            }
        }
    }
    public boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++; end--;
        }
        return true;
    }
}