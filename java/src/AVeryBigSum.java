import java.util.Scanner;

class AVeryBigSum {

    static long sumArray(int[] intArray) {
        
    	long sum = 0;
    	
    	for (int i=0; i<intArray.length; i++) {
    		sum = sum + intArray[i];
        }
    	
    	return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int t;
        long sum;
        
        t = in.nextInt();
        int[] intArray = new int[t];
        
        for (int i=0; i<t; i++) {
        	intArray[i] = in.nextInt();
        }
        
        in.close();
        
        sum = sumArray(intArray);
        System.out.println(sum);

    }
}