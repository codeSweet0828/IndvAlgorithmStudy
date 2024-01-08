

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] arr;
    static int[] count;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        arr = new int[100001];
        count = new int[100001];
        visited = new boolean[100001];

        bfs(N, K);
        
        System.out.println(arr[K]);
        System.out.println(count[K]);
    }

    public static void bfs(int start, int target) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        arr[start] = 0;
        count[start] = 1;

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int next : new int[]{current - 1, current + 1, current * 2}) {
                if (next >= 0 && next <= 100000) {
                    if (!visited[next]) {
                        q.offer(next);
                        visited[next] = true;
                        arr[next] = arr[current] + 1;
                        count[next] = count[current];
                    } else if (arr[next] == arr[current] + 1) {
                        count[next] += count[current];
                    }
                }
            }
        }
    }
}
