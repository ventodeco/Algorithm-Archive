class MinStack {

    Stack<Integer> stack;
    PriorityQueue<Integer> queue;

    public MinStack() {
        stack = new Stack<>();
        queue = new PriorityQueue<>();
    }

    public void push(int val) {

        System.out.println("push: " + val);

        queue.add(val);
        stack.push(val);
    }

    public void pop() {
        if (queue.contains(stack.peek())) {
            queue.remove(stack.peek());
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return (int) queue.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */