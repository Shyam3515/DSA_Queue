/*
 * Video: https://www.youtube.com/watch?v=l_CFMVPKv2Q
 * Link:https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
 * 
 * Question : Given an array and an integer K, find the maximum for each and every 
              contiguous subarray of size K.
	Examples : 	
	Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3 
	Output: 3 3 4 5 5 5 6
 * 
 * Algorithm:
 * Follow the given steps to solve the problem:
	1.Create a deque to store K elements.
	2.Run a loop and insert the first K elements in the deque. Before inserting the 
	  element, check if the element at the back of the queue is smaller than the current
	  element, if it is so remove the element from the back of the deque until all 
	  elements left in the deque are greater than the current element. Then insert the
	  current element, at the back of the deque.
	3.Now, run a loop from K to the end of the array.
	4.Print the front element of the deque.
	5.Remove the element from the front of the queue if they are out of the current window.
	6.Insert the next element in the deque. Before inserting the element, check if the
	  element at the back of the queue is smaller than the current element, if it is 
	  so remove the element from the back of the deque until all elements left in the 
	  deque are greater than the current element. Then insert the current element, 
	  at the back of the deque.
	7.Print the maximum element of the last window.
	
 * Time Complexity: O(N). It seems more than O(N) at first look. 
		 It can be observed that every element of the array is added and removed at most once. 
		 So there are total of 2n operations.
 * Auxiliary Space: O(K). Elements stored in the dequeue take O(K) space.	
 */
package queue;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class SlidingWindow {

	// A Dequeue (Double ended queue)
    // based method for printing
    // maximum element of
    // all subarrays of size K
    static void printMax(int arr[], int N, int K)
    {
 
        // Create a Double Ended Queue, Qi
        // that will store indexes of array elements
        // The queue will store indexes of
        // useful elements in every window and it will
        // maintain decreasing order of values
        // from front to rear in Qi, i.e.,
        // arr[Qi.front[]] to arr[Qi.rear()]
        // are sorted in decreasing order
        Deque<Integer> Qi = new LinkedList<Integer>();
 
        /* Process first k (or first window)
        elements of array */
        int i;
        for (i = 0; i < K; ++i) {
 
            // For every element, the previous
            // smaller elements are useless so
            // remove them from Qi
            while (!Qi.isEmpty()
                   && arr[i] >= arr[Qi.peekLast()])
 
                // Remove from rear
                Qi.removeLast();
 
            // Add new element at rear of queue
            Qi.addLast(i);
        }
 
        // Process rest of the elements,
        // i.e., from arr[k] to arr[n-1]
        for (i=K; i < N; ++i) {
 
            // The element at the front of the
            // queue is the largest element of
            // previous window, so print it
            System.out.print(arr[Qi.peek()] + " ");
 
            // Remove the elements which
            // are out of this window
            
            System.out.println(" I:"+i+" K:"+K);
            while ((!Qi.isEmpty()) && Qi.peek() <= i - K)
                Qi.removeFirst();
 
            // Remove all elements smaller
            // than the currently
            // being added element (remove
            // useless elements)
            while ((!Qi.isEmpty())
                   && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();
 
            // Add current element at the rear of Qi
            Qi.addLast(i);
        }
        
        // Print the maximum element of last window
        System.out.println(arr[Qi.peek()]);
        
     // Returns an iterator over the elements in this deque
        System.out.println("Remainig Elements in Deque:");
        Iterator<Integer> it = Qi.iterator();
        // prints [3, 2, 1]
        while (it.hasNext()) {
            System.out.print(arr[it.next()]+" ");
        }
    }
 
    // Driver's code
    public static void main(String[] args)
    {
        int arr[] = { 12, 1, 78, 90, 57, 89, 53 };
        int K = 3;
       
          // Function call
        printMax(arr, arr.length, K);
    }
}


