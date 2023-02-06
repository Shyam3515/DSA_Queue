/*
 * Video : https://www.youtube.com/watch?v=ww5Ac232WEU&t=313s
 * 
 * Method 1 (By making push operation costly): 
     This method makes sure that newly entered element is always at the front of ‘q1’, 
	 so that pop operation just dequeues from ‘q1’. 
	 ‘q2’ is used to put every new element at front of ‘q1’.
	 
   Algorithm: 
	 1)push(s, x) operation’s step are described below: 
	   a)Enqueue x to q2
	   b)One by one dequeue everything from q1 and enqueue to q2.
	   c)Swap the names of q1 and q2
	 2)pop(s) operation’s function are described below: 
	   a)Dequeue an item from q1 and return it.
 
 *Time Complexity / Space Complexity
 *    O(n)	 /   O(n)	
 *
 *Method 2 (By making pop operation costly) 
	 In push operation, the new element is always enqueued to q1. 
	 In pop() operation, if q2 is empty then all the elements except the last, are moved to q2. 
	 Finally the last element is dequeued from q1 and returned.
	 
	Algorithm:
	  1)push(s, x) operation: 
	    a)Enqueue x to q1 (assuming size of q1 is unlimited).
	  2)pop(s) operation: 
	    a)One by one dequeue everything except the last element from q1 and enqueue to q2.
        b)Dequeue the last item of q1, the dequeued item is result, store it.
        c)Swap the names of q1 and q2
        d)Return the item stored in step 2.
        
 * Time Complexity / Space Complexity
 *    O(n)	 /   O(n)	
 */
package queue;

import queue.Queue;

public class StackUsingTwoQueue {
	// Temporary queue for swapping
	static Queue queue =new Queue();
	// Two inbuilt queues 
	static Queue queue1 =new Queue();
	static Queue queue2 =new Queue();
	
	 void push(int input) { //push costly, O(n)
		// Push x first in empty q2 
		  queue2.enqueue(input);
		// Push all the remaining 
		// elements in q1 to q2.
		  while(!queue1.isEmpty()) {
			  queue2.enqueue(queue1.dequeue());
		  } 
		// swap the names of two queues 
		  queue  =  queue1; 
		  queue1 =  queue2; 
		  queue2 =  queue; 
	}
	
	int pop() {
			return  queue1.dequeue();		  
	}

	
	// Pop costly, we can use this when we have more push operations.
	// pop O(n)
	void push1(int input) {
		queue1.enqueue(input);
	}
	
	int pop1() {
		int item=-1;
			if(queue1.isEmpty()) {
				return item;
			}
			// Leave one element in q1 and 
			// push others in q2. 
			while (queue1.size() != 0) 
			{
				 queue2.enqueue(queue1.dequeue());	 
			}
			// Pop the only left element 
			// from q1 
			item=queue1.dequeue();
			// swap the names of two queues 
			  queue  =  queue1; 
			  queue1 =  queue2; 
			  queue2 =  queue; 
	
			return item;
		}
	
/*
	void pop() 
	{ 
		if (q1.empty()) 
			return; 

		// Leave one element in q1 and 
		// push others in q2. 
		while (q1.size() != 1) 
		{ 
			q2.push(q1.front()); 
			q1.pop(); 
		} 

		// Pop the only left element 
		// from q1 
		q1.pop(); 
		curr_size--; 
		// swap the names of two queues 
		queue<int> q = q1; 
		q1 = q2; 
		q2 = q; 
	}
	*/
	
	public static void main(String[] args) {
		StackUsingTwoQueue s=new StackUsingTwoQueue ();
		/*s.push(3);
		s.push(4);
		queue1.display("Queue1");
		queue2.display("Queue2");
		int p=s.pop();
		System.out.println("Rmoved element is: "+p);
		queue1.display("Queue1");
		queue2.display("Queue2");
		s.push(5);
		s.push(6);
		queue1.display("Queue1");
		queue2.display("Queue2");
		int p1=s.pop();
		System.out.println("Rmoved element is: "+p1);
		queue1.display("Queue1");
		queue2.display("Queue2");

*/
		s.push1(7);
		s.push1(3);
		s.push1(8);
		queue1.display("Queue1");
		queue2.display("Queue2");
		int p=s.pop1();
		System.out.println("Rmoved element is: "+p);
		queue1.display("Queue1");
		queue2.display("Queue2");
		s.push1(5);
		s.push1(6);
		queue1.display("Queue1");
		queue2.display("Queue2");
		int p1=s.pop1();
		System.out.println("Rmoved element is: "+p1);
		queue1.display("Queue1");
		queue2.display("Queue2");
	}

}
