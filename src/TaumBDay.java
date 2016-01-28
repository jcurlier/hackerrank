import java.util.Scanner;

public class TaumBDay {

    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    
	    int t = in.nextInt();
	    
	    for (int i=0; i<t; i++) {
	    	int b = in.nextInt();
	    	int w = in.nextInt();
	    	
	    	int x = in.nextInt();
	    	int y = in.nextInt();
	    	int z = in.nextInt();
	    	
	    	System.out.println(process(b,w,x,y,z));
	    }
	    
	    in.close();
    } 
    
    private static long process(long b, long w, long x, long y, long z) {
    	long cost = 0;
    	
    	// white
    	if (x <= y + z) {
    		cost = cost + b * x;
    	} else {
    		cost = cost + b * (y + z);
    	}

    	// black
    	if (y <= x + z) {
    		cost = cost + w * y;
    	} else {
    		cost = cost + w * (x + z);
    	}

    	
    	return cost;
    }
}
