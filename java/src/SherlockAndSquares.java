import java.util.Scanner;

public class SherlockAndSquares {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int t;
        int low,high;
        int nbrOfSquareIntegers = 0;
        t = in.nextInt();
        for (int i=0;i<t;i++) {
            low = in.nextInt();
            high = in.nextInt();
            nbrOfSquareIntegers = calculateNbrOfSquareIntegers(low, high);
            System.out.println(nbrOfSquareIntegers);
        }
        
        in.close();
    }
    
    static int calculateNbrOfSquareIntegers(int low, int high) {
    	
    	double lowSqrt = Math.sqrt(low);
    	double highSqrt = Math.sqrt(high);
    	
    	int lowestSqrtInt = (int) Math.ceil(lowSqrt);
    	int highestSqrtInt = (int) Math.floor(highSqrt);
    	
    	if (highestSqrtInt >= lowestSqrtInt) {
    		return (highestSqrtInt - lowestSqrtInt + 1);
    	} else {
    		return 0;
    	}
    }
}
