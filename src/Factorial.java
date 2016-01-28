import java.math.BigInteger;
import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		
		 BigInteger result = new BigInteger("1");
		
		for (int i=1; i <= n; i++) {
			result = result.multiply(new BigInteger("" + i));
		}

		System.out.println(result);
	}
	
}
