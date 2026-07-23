class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> sc = new Stack<>();
        for(String c : tokens){
            if(c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")){
                int b = sc.pop();
                int a = sc.pop();
                
                switch(c){
                    case "+": sc.push(a+b); break;
                    case "-": sc.push(a-b); break;
                    case "*": sc.push(a*b); break;
                    case "/": sc.push(a/b); break;
                }
            }
            else{
                sc.push(Integer.parseInt(c));
            }
        }
        return sc.pop();
    }
}
