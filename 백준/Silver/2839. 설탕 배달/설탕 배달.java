import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Main ma = new Main();
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int data = ma.greedy(num);
		System.out.println(data);
	}

	public int greedy(int num) {
	   int orginalNum = num;
		
	    int maxIndex = num/5 ;
	    
	    if(num %5 == 0)
	    	return num/5;
	    
	    for(int i = maxIndex; i >0 ; i--) {
	    	num = orginalNum;
	    	
	    	num = num - i*5;
	    	
	    	if(num %3 == 0)
	    		return i + (num/3);
	    }
	    
	    if(orginalNum %3 == 0)
	    	return orginalNum/3;
			
		return -1;
	}

}
