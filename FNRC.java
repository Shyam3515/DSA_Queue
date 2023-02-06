/*
 * Video : https://www.youtube.com/watch?v=2Z--YYbzigU
 * Question:Given a stream of characters and we have to find first non repeating 
   character each time a character is inserted to the stream. 

	Examples: 
	Input  : a a b c
	Output : a -1 b b
	Input  : a a c
	Output : a -1 c
	
 * Algorithm:
    1.Create a queue of char datatype.
	2.Store each character in queue and increase its frequency in the hash array.
	3.For every character of stream, we check front of the queue.
	4.If the frequency of character at the front of queue is one, then that will be
	  the first non-repeating character.
	5.Else if frequency is more than 1, then we pop that element.
	6.If queue became empty that means there are no non-repeating characters so we will print -1.	
	
 * Time complexity : O(n) 
   Auxiliary Space : O(n)
 */

package queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FNRC {
	static Queue<Character> q = new LinkedList<>();
	
static void FirstNonRepeatingCharacter(String str) {
	HashMap<Character,Integer> map=new HashMap<Character,Integer>();
    
    for(int i = 0; i < str.length(); i++) {
      map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
      
      if(map.get(str.charAt(i)) == 1) {
        q.add(str.charAt(i));
      }
        
      while(!q.isEmpty()) {
        char c = q.peek();
        if(map.get(c) == 1) {
          break;
        } else {
          q.remove();
        }
      }
      
      if(q.isEmpty()) {
        System.out.print(-1 + " ");
      } else {
        System.out.print(q.peek() + " ");
      }
      
    }
    
  }

	public static void main(String[] args) {
		String str="shshyyaam";
		FirstNonRepeatingCharacter(str);
		System.out.println();
		System.out.println("First Non-Repeating character is: "+q.peek() + " ");

	}

}
