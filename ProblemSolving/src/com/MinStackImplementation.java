package com;

import java.util.Stack;
/* Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */
public class MinStackImplementation {
	/* The idea is to use two stacks. One for storing the normal values
	 * and other for storing min values. We only need to store values that will
	 * affect the min value. For eg, if we have to push 2,2,3,2,1,0 - we only need to add
	 * 2,2,3 to the second stack. Now we remove 3 from stack two when stack.pop() gives 3
	 */
	class MinStack {
		//Can also use deque for implementing stack which may be faster.
		Stack <Integer> stack1;
		Stack <Integer> stack2;
	    /** initialize your data structure here. */
	    public MinStack() {
	    	stack1 = new Stack<>();
	    	stack2 = new Stack<>();
	    }
	    
	    public void push(int x) {
	         stack1.push(x);
	         if(stack2.isEmpty() || x<= stack2.peek()) {
	        	 stack2.push(x);
	         }
	    }
	    
	    public void pop() {
	    	int x=0;
	    	if(!stack1.isEmpty()) {
	    	x= stack1.pop();
	    	}
	    	if(!stack2.isEmpty() && x== stack2.peek()) {
	        	 stack2.pop();
	         }
	    }
	    
	    public int top() {
	    	return stack1.peek();
	    }
	    
	    public int getMin() {
	    	return stack2.peek();
	    }
	}

	/**
	 * Your MinStack object will be instantiated and called as such:
	 * MinStack obj = new MinStack();
	 * obj.push(x);
	 * obj.pop();
	 * int param_3 = obj.top();
	 * int param_4 = obj.getMin();
	 */
}
