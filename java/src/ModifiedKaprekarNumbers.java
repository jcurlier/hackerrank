import java.util.Scanner;

public class ModifiedKaprekarNumbers {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int low = in.nextInt();
        int high = in.nextInt();
        
        boolean hasModifiedKaprekarNumbers = false;
        
        for (int i=low; i<=high; i++) {
        	if (isModifiedKaprekarNumbers(i)) {
        		if (hasModifiedKaprekarNumbers) {
        			System.out.print(" ");
        		}
        		System.out.print(i);
        		hasModifiedKaprekarNumbers = true;
        	}
        }
        
        in.close();
        
        if (hasModifiedKaprekarNumbers) { 
        	System.out.println();        	
        } else {
        	System.out.println("INVALID RANGE");
        }
        
	}
	
	public static boolean isModifiedKaprekarNumbers(long number) {
		boolean result = false;
		
		long square = number * number;

		int d = getNumberOfDigits(number);
		
		long diviser = (long) Math.pow(10, d);
		 
		long r = square / diviser;
		long l = square % diviser;
		
    	if ((r + l) == number) {
    		result = true;
    	}
    	
		return result;
	}
	
	public static int getNumberOfDigits(long number) {
		int numberOfDigits = 0;
		
		long temp = number;
    	do {
    	    numberOfDigits++;
    	    temp = temp / 10;
    	} while (temp > 0);
    	
    	return numberOfDigits;
	}
}
