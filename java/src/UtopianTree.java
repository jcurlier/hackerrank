import java.util.Scanner;

class UtopianTree {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int t;
        
        t = in.nextInt();
        
        for (int i=0; i<t; i++) {
        	process(in.nextInt());
        }
        
        in.close();
        
    }
    
    static void process(int cycle) {
    	int length = 1;
    	
    	for (int i=1; i<=cycle; i++) {
    		if ((i % 2) == 0) {
    			length = length + 1;
    		} else {
    			length = length * 2;
    		}
    	}

    	System.out.println(length);
    }


}