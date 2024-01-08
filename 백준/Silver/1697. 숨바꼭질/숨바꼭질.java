

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		visited = new boolean[1000001];
		
		int N =sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[100001];  
		Queue<Integer> q = new LinkedList();
		q.add(N);
		arr[N] = 0;

		while(!q.isEmpty()) {
			int current = q.poll();
			
			if(current == K) {
				System.out.println(arr[K]);
				break;
			}
			
			int [] nextPositions = {current-1, current+1, current*2 };
			for(int next : nextPositions) {
				if (next >= 0 && next <= 100000 && arr[next] == 0) {
					q.add(next);
					arr[next] = arr[current]+1;
				}
			}
		}
		

	}

}
