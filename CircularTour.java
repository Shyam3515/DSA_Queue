//This can be solved by using queue...
/*
* Video:https://www.youtube.com/watch?v=MWTHTDIBN0s
* Time Complexity/Space Complexity:
*    O(n)/O(1)  
*/

package queue;

public class CircularTour {
	
	static int tour(int[] petrol,int[] dist,int n) {
		int remaining_fuel=0,ans=0;
		int total=0;
		
		for(int i=0;i<n;i++) {
			remaining_fuel=petrol[i]-dist[i];
			if(remaining_fuel<0) {
				remaining_fuel=0;
				ans=i+1;
			}
			total=petrol[i]-dist[i];
		}
		
		return total<0?-1:ans;
	}

	public static void main(String[] args) {
		int N = 4;
		int[] Petrol = {4,6,7,6};
		int[] Distance = {6,5,3,5};
		System.out.println("The tour can start from index: "+tour(Petrol,Distance,N));

	}

}

