import java.util.Scanner;

class TheBeast {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int t;
        
        t = in.nextInt();
        
        for (int i=0; i<t; i++) {
        	process(in.nextInt());
        }
        
        in.close();
        
    }
    
    static void process(int n) {

        int numberOfThree = 0;
        int numberOfFive = n;
        
        do {
            if (numberOfFive % 3 == 0) {
        	   printDecent(numberOfThree, numberOfFive);
        	   return;
            }
            
        	numberOfFive = numberOfFive - 5;
        	numberOfThree = numberOfThree + 5;
        		
        }  while (numberOfThree <= n);      
        
        System.out.println("-1");

    }

	static void printDecent(int numberOfThree, int numberOfFive) {
		StringBuilder sb = new StringBuilder();
		
		for (int i=0; i<numberOfFive; i++) {
	    	sb.append("5");
	    }
	    for (int i=0; i<numberOfThree; i++) {
	    	sb.append("3");
	    }
	    System.out.println(sb.toString());
	}
}