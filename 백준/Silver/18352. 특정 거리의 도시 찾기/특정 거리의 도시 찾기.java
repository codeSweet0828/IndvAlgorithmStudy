

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static int[] distance;
	static ArrayList<ArrayList<Integer>> graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int INF = Integer.MAX_VALUE/4;
        int N = sc.nextInt(); // 도시의 갯수
        int M = sc.nextInt(); // 도로의 갯수
        int K = sc.nextInt(); // 거리정보 K
        int X = sc.nextInt(); // 출발도시 X
        
        distance = new int[N+1];
        graph = new ArrayList<>();
        
        for(int i = 0 ; i <= N ; i++) {
        	graph.add(new ArrayList<>());
        }
        
        for(int i = 0 ; i < distance.length; i++) {
        	distance[i] = INF;
        }
        
        for(int i = 0; i < M; i++) {
        	int num1 = sc.nextInt();
        	int num2 = sc.nextInt();
        	graph.get(num1).add(num2);
        }
        
        //출발도시 X의 거리정보 초기화
        distance[X] = 0;
        
        //다이스트라 알고리즘 실행
        dijkstra(X);
        
        int cnt = 0;
        
        //만약 K위치의 거리에 있는게 있다면 순서대로 출력.
        for(int i = 1; i <distance.length ; i++) {
        	if(distance[i] == K) {
        		System.out.println(i);
        		cnt++;
        	}
        }
        
        //만약 하나도 없다면 -1 출력
        if(cnt == 0) System.out.println(-1);

        
    }
    public static void dijkstra(int start) {
    	
    	PriorityQueue<Integer> q = new PriorityQueue<>();
    	
    	q.add(start);
    	
    	while(!q.isEmpty()) {
    		int current = q.poll();
    		
    		for(int j = 0 ; j <graph.get(current).size(); j ++) {
    			int cost = distance[current]+1;
    			
    			if(cost < distance[graph.get(current).get(j)]) {
    				distance[graph.get(current).get(j)] = cost;
    				q.add(graph.get(current).get(j));
    			}
    		}
    	}
    }
}
