class Solution {
    public boolean isPalindrome(String s) {
        String newS = s.toLowerCase().replaceAll("[^a-z0-9]","");
        System.out.print(newS);
        int n = newS.length();

        int start = 0,end = n-1;
        while(end > start){
            if(newS.charAt(start) != newS.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
