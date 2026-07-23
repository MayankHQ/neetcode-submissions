class Solution {
    public int count = 0;
    public int countSubstrings(String s) {
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                String check = s.substring(i, j+1);
                if(isPalin(check)) count++;
            }
        }
        return count;
    }
    public boolean isPalin(String s){
        int i = 0, j = s.length() - 1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
