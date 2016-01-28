import java.util.Scanner;

class FindDigits {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int t;
        
        t = in.nextInt();
        
        for (int i=0; i<t; i++) {
        	process(in.nextLong());
        }
        
        in.close();
        
    }
    
    static void process(long n) {
    	
    	int count = 0;
    	int[] digitArray = new int[] {0,0,0,0,0,0,0,0,0,0};

    	int digit;
    	
    	long temp = n;
    	
    	// count each digits
    	do {
    	    digit = (int) temp % 10;
    	    digitArray[digit]++;
    	    temp = temp / 10;
    	} while (temp > 0);

    	// for each digits, count if divisible
    	for (int i=1; i<=9; i++) {
        	if (digitArray[i] > 0 && (n % i) == 0) {
        		count = count + digitArray[i];
        	}
    	}
    	
    	System.out.println(count);
    }


}