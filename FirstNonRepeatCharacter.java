package queue;

import java.util.HashMap;

public class FirstNonRepeatCharacter {
	static HashMap<Character,Integer> map=new HashMap<Character,Integer>();
	static Queue queue =new Queue();
	static void FirstNonRepeatingCharacter(String str) {
		
		for(int i=0;i<str.length();i++) {
			 //map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
			if(map.containsKey(str.charAt(i))) {			
				map.put(str.charAt(i),map.get(str.charAt(i))+1);
			}
			else {				
				map.put(str.charAt(i), 1);
			}
			 
			 if(map.get(str.charAt(i))==1){
				 queue.enqueue(i);
			 }
			 
			 while(queue.isEmpty()==false) {
			       char c = (char)queue.top();
			        if(map.get(c) == 1) {
			          break;
			        } 
			        else {
			          queue.dequeue();
			        }
			      }
			      
			      if(queue.isEmpty()) {
			        System.out.print(-1 + " ");
			      }
			      else if(queue.isEmpty()==false){
			        System.out.print((char)queue.top() + " ");
			      }
		}
	}


	public static void main(String[] args) {
		String str="shyam";
		FirstNonRepeatingCharacter(str);

	}

}
