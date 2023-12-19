import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int data = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int F = sc.nextInt(); // 총 F개의 층
        int S = sc.nextInt(); // 현재 위치 S층
        int G = sc.nextInt(); // 스타트 링크 위치 G층
        int U = sc.nextInt(); // 위로 U씩 몇 칸 이동
        int D = sc.nextInt(); // 아래로 D씩 몇 칸 이동

        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[F + 1]; // 방문 여부를 체크하는 배열

        queue.add(S);
        visited[S] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 스타트링크 위치에 도착하는 경우
            if (current == G) {
                data = visited[current] - 1;
                break;
            }

            int[] nextPositions = { current + U, current - D };

            for (int next : nextPositions) {
                if (next >= 1 && next <= F && visited[next] == 0) {
                    queue.add(next);
                    visited[next] = visited[current] + 1;
                }
            }
        }

        if (data != -1) {
            System.out.println(data);
        } else {
            System.out.println("use the stairs");
        }
    }
}
