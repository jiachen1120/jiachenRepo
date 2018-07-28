package jiachen.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class QueueToStack {
	Queue<Integer> q1 = new LinkedList<> ();
	Queue<Integer> q2 = new LinkedList<> ();
//	public void push(int data) {
//		q1.offer(data);
//	}
//	public boolean isEmpty() {
//		return q1.isEmpty();
//	}
//	public int pop() throws Exception {
//		if (isEmpty()) {
//			throw new Exception("Stack is Empty");
//		}
//		while (q1.size() > 1) {
//			q2.offer(q1.remove());
//		}
//		int val = q1.remove();
//		Queue<Integer> temp = q1;
//		q1 = q2;
//		q2 = temp;
//		return val;
//	}
	public void push(int data) {
		if (q1.isEmpty()) {
			q1.offer(data);
		} else {
			q2.offer(data);
			while (!q1.isEmpty()) {
				q2.offer(q1.remove());
			}
			Queue<Integer> temp = q1;
			q1 = q2;
			q2 = temp;
		}
	}
	public boolean isEmpty() {
		return q1.isEmpty();
	}
	public int pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("stack is Empty");
		}
		return q1.remove();
	}
}
