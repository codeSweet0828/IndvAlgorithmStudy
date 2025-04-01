import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static long[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(bf.readLine());
		arr = new long[117];
		
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 1;
		
		for(int i = 4 ; i < num+1 ; i++) {
			arr[i] = arr[i-1]+ arr[i-3];
		}
			
		System.out.println(arr[num]);
	}
	
}
