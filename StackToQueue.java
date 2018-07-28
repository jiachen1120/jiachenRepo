package jiachen.algorithm;

import java.util.Stack;

public class StackToQueue {
	Stack<Integer> stk1 = new Stack<>();
	Stack<Integer> stk2 = new Stack<>();

//	public void enqueue(int data) {
//		stk1.push(data);
//	}
//
//	public boolean isEmpty() {
//		return stk1.size() + stk2.size() == 0;
//	}
//
//	public int dequeue() throws Exception {
//		if (isEmpty()) {
//			throw new Exception("Queue is Empty");
//		}
//		if (stk2.isEmpty()) {
//			while (stk1.size() > 0) {
//				stk2.push(stk1.pop());
//			}
//		}
//		int temp = stk2.pop();
//		return temp;
//	}
	
	public void enqueue(int data) {
		while (!stk1.isEmpty()) {
			stk2.push(stk1.pop());
		}
		stk1.push(data);
		while (!stk2.isEmpty()) {
			stk1.push(stk2.pop());
		}
	}
	public boolean isEmpty() {
		return stk1.size() + stk2.size() == 0;
	}
	public int dequeue() {
		return stk1.pop();
	}
}