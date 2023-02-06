//Queue is an ADT(Abstract Data Type)
/*
 * Link : https://www.youtube.com/watch?v=zp6pBNbUB2U
 */
package queue;

import java.util.ArrayList;
public class Queue {
	int size=15;
	int rear=-1,front=-1;
	ArrayList<Integer> queue=new ArrayList<>();
	void enqueue(int input) {
		try{
			if(front==-1 &&rear==-1) {
				front=0;
				rear=0;
				queue.add(rear,input);
				//System.out.println("Rear: "+rear+", "+queue.get(rear));
				//System.out.println("Front: "+front);	
			}
			else if(rear<size-1) {
				//System.out.println("rear: "+rear);
				rear++;
				queue.add(rear,input);
				//System.out.println("Rear: "+rear+", "+queue.get(rear));
				//System.out.println("Front: "+front);	
			}
			else {
				throw new ArrayIndexOutOfBoundsException("Overflow Condition...");
			}
		}	
		catch(ArrayIndexOutOfBoundsException e) {
	    	System.out.println("Caught the exception");  
            // Print the message from MyException object  
            System.out.println(e.getMessage());  
            //e.printStackTrace();  
		}
	}
	
	int dequeue() {
		int r=-1;
		//System.out.println("Dequeue:");
		try {
			
			 if(front==0 && rear==0) {
					r=queue.remove(front);
					//System.out.println("Removed element is: "+r);
					front=-1;
					rear=-1;
			}
			else if(front>=0 && rear>=0) {
				//In arraylist size adjusts itself
				//System.out.println("Front: "+front);
				//System.out.println("rear: "+rear);
				r=queue.remove(front);
				//System.out.println("Removed element is: "+r);
				rear--;
			}	
			else {
				throw new ArrayIndexOutOfBoundsException("Underflow Condition...");
			}
			 
	      }
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Caught the exception");  
			System.out.println(e.getMessage());
		}
		return r;
	}
	
	void peek() {
		System.out.println("Peek Method:");
		if(front==-1 && rear==-1) {
			System.out.println("Queue is empty...");
		}
		else {
			System.out.println("The top element is: "+queue.get(front));
		}
	}
	
	Object top() {
		//System.out.println("Peek Method:");
		if(front==-1 && rear==-1) {
			return null;
		}
		else
		 return queue.get(front);
	}
	
	boolean isEmpty() {
		return (front==-1 && rear==-1)? true : false;
	}
	
	void display(String name) {
		System.out.println("Elements in "+name+" are: ");
		for(Object ele:queue)
			System.out.print(ele+" ");
		System.out.println();
	}
	
	int size() {
		return rear;
	}

	public static void main(String[] args) {
		Queue q=new Queue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.display("queue");
		int y=q.dequeue();
		System.out.println("Dequeue: "+y);
		int y1=q.dequeue();
		System.out.println("Dequeue: "+y1);
		int c=(int) q.top();
		System.out.println("Top: "+c);
		
	}

}



/*
 * import java.util.ArrayList;
public class Queue {
	int size=3;
	int rear=-1,front=-1;
	ArrayList<Integer> queue=new ArrayList<>();
	void enqueue(int input) {
		//System.out.println("Enqueue:");
		try{
			if(front==-1 &&rear==-1) {
				front=0;
				rear=0;
				queue.add(rear,input);
				//System.out.println("Rear: "+rear+", "+queue.get(rear));
				//System.out.println("Front: "+front);	
			}
			else if(rear<size-1) {
				//System.out.println("rear: "+rear);
				rear++;
				queue.add(rear,input);
				//System.out.println("Rear: "+rear+", "+queue.get(rear));
				//System.out.println("Front: "+front);	
			}
			else {
				throw new ArrayIndexOutOfBoundsException("Overflow Condition...");
			}
		}	
		catch(ArrayIndexOutOfBoundsException e) {
	    	System.out.println("Caught the exception");  
            // Print the message from MyException object  
            System.out.println(e.getMessage());  
            //e.printStackTrace();  
		}
	}
	
	int dequeue() {
		int r1=-1;
		System.out.println("Dequeue:");
		try {
			
			 if(front==0 &&rear==0) {
					r1=queue.remove(front);
					System.out.println("Rmoved element is: "+r1);
					front=-1;
					rear=-1;
			}
			else if(front>=0 && rear>=0) {
				System.out.println("Front: "+front);
				System.out.println("rear: "+rear);
				r1=queue.remove(front);
				System.out.println("Rmoved element is: "+r1);
				rear--;
			}	
			else {
				throw new ArrayIndexOutOfBoundsException("Underflow Condition...");
			}
			 
	      }
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Caught the exception");  
			System.out.println(e.getMessage());
		}
		return r1;
	}
	
	void peek() {
		System.out.println("Peek Method:");
		if(front==-1 && rear==-1) {
			System.out.println("Queue is empty...");
		}
		else {
			System.out.println("The top element is: "+queue.get(front));
		}
	}
	
	void display() {
		System.out.println("Elements in queue are: ");
		for(int ele:queue)
			System.out.print(ele+" ");
		System.out.println();
	}

	public static void main(String[] args) {
		Queue q=new Queue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		//q.enqueue(4);
		//q.display();
		int y=q.dequeue();
		System.out.println("Dequeue111: "+y);
		q.peek();
		
	}

 */
