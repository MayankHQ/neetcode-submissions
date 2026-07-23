class Solution {
    private List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        backtrack(n, new StringBuilder(), 0, 0);
        return ans;
    }
    public void backtrack(int n, StringBuilder sb, int open, int close){
        if(sb.length() == 2*n){
            ans.add(sb.toString());
            return;
        }

        if(open < n){
            sb.append("(");
            backtrack(n, sb, open+1, close);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(close < open){
            sb.append(")");
            backtrack(n, sb, open, close+1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
