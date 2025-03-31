import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] str = bf.readLine().split(" ");
        int M = Integer.parseInt(str[0]);
        int N = Integer.parseInt(str[1]);

        for (int i = M; i <= N; i++) {
            if (isPrime(i)) {
                sb.append(i).append("\n");
            }
        }

        System.out.print(sb.toString()); 
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false; 
        if (num == 2) return true;
        if (num % 2 == 0) return false; 

        for (int j = 3; j * j <= num; j += 2) {
            if (num % j == 0) {
                return false;
            }
        }
        return true;
    }
}
