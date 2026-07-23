class Solution {
    public boolean isValid(String s) {
        Stack<Character> sc = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                sc.push(ch);
            }
            else{
                if(sc.isEmpty()) return false;

                char top = sc.pop();
                if((ch == ')' && top != '(') ||
                (ch == '}' && top != '{') ||
                (ch == ']' && top != '[')) return false;

            }
        }
        return sc.isEmpty();
    }
}
