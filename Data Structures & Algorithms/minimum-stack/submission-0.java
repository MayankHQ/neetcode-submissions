class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    public void push(int val) {
        if(minStack.isEmpty()){
            minStack.push(val);
        }
        else{
            minStack.push(Math.min(val, minStack.peek()));
        }
        stack.push(val);
    }
    
    public void pop() {
        if(!minStack.isEmpty() && !stack.isEmpty()){
            minStack.pop();
            stack.pop();
        }
    }
    
    public int top() {
        // if(stack.isEmpty()){
        //     throw new NoSuchElementException("Stack is Empty");
        // }
        return stack.peek();
    }
    
    public int getMin() {
        // if (minStack.isEmpty()) {
        //     throw new NoSuchElementException("Stack is empty");
        // }        
        return minStack.peek();
    }
}
