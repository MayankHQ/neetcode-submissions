class Solution {
    String[] hash = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return res;
        backtrack(digits, 0, new StringBuilder());
        return res;
    }
    public void backtrack(String digits, int idx, StringBuilder sb){
        if(idx == digits.length()){
            res.add(sb.toString());
            return;
        }
        int d = digits.charAt(idx) - '0';
        String letters = hash[d];
        int len = sb.length();
        for(char c : letters.toCharArray()){
            sb.append(c);
            backtrack(digits, idx+1, sb);
            sb.setLength(len);
        }
    }
}
