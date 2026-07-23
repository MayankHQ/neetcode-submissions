class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> hash = new HashSet<>(wordDict);
        Boolean[] dp = new Boolean[s.length() + 1];

        return fun(s, 0, hash, dp);
    }
    public boolean fun(String s, int i, Set<String> hash, Boolean[] dp){
        int n = s.length();
        if(i == n) return true;

        if(dp[i] != null) return dp[i];

        for(int j = i; j < n; j++){
            if(hash.contains(s.substring(i, j+1))){
                if(fun(s, j+1, hash, dp)){
                    dp[i] = true;
                    return true;
                }    
            }
        }
        dp[i] = false;
        return false;
    }
}
// if i == n → return true

// if memo[i] is filled → return memo[i]

// for j from i to n-1:
//     if s[i..j] is a dictionary word:
//         if solve(j+1) returns true:
//             memo[i] = true
//             return true

// memo[i] = false
// return false
