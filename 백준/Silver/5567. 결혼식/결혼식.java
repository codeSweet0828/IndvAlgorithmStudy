import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static int[][] arr;
    static boolean[] visited;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 학생 수
        arr = new int[n + 1][n + 1]; // 친구 관계를 저장할 배열
        visited = new boolean[n + 1]; // 방문 여부를 저장할 배열

        int m = sc.nextInt(); // 친구 관계 수

        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            int num2 = sc.nextInt();

            arr[num][num2] = 1;
            arr[num2][num] = 1;
        }

        DFS(1, 0);

        System.out.println(set.size()); // 상근이를 포함하지 않고 친구와 친구의 친구까지만 초대할 사람의 수를 출력
    }

    public static void DFS(int i, int depth) {
        if (depth == 2) // 상근이의 친구의 친구까지만 초대
            return;

        visited[i] = true;

        for (int k = 1; k < arr[i].length; k++) {
            if (!visited[k] && arr[i][k] == 1) {
                set.add(k);
                DFS(k, depth + 1);
            }
        }
    }
}
