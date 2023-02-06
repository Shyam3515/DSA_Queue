package queue;

public class StackUsingSingleQueue {
	static Queue queue =new Queue();
	
	void push(int input) { //push costly, O(n)
		// Push x first in empty q2 
		if(queue.isEmpty()) {
		  queue.enqueue(input);
		}
		else {
			 queue.enqueue(input);
			 System.out.println("size:"+queue.size());
			 for(int i=0;i<queue.size();i++) {
				queue.enqueue(queue.dequeue());
				//System.out.println(queue.dequeue());
			}
		}
	}
	
	int pop() {
		return  queue.dequeue();		  
}

	public static void main(String[] args) {
		StackUsingSingleQueue s= new StackUsingSingleQueue();
		s.push(7);
		s.push(3);
		s.push(8);
		s.push(13);
		s.push(18);
		
		int p=s.pop();
		System.out.println("popped element: "+p);
		queue.display("Queue1");

	}

}
