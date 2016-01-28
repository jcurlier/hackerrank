import java.util.Scanner;

public class CutTheSticks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int nbrSticks = 0;
        
        nbrSticks = in.nextInt();

        int[] sticks = new int[nbrSticks];
        for (int i=0; i<nbrSticks; i++) {
        	sticks[i] = in.nextInt();
        }
        process(sticks);
        
        in.close();
        
    }
    
    static void process(int[] sticks) {
    	
    	int length = getLowestLength(sticks);
    	int nbrCuts = 0;
    	
    	
    	while (length != 0) {
    		
    		nbrCuts = 0;
    		
        	for (int i=0; i<sticks.length; i++) {
        		if (sticks[i] > 0) {
        			sticks[i] = sticks[i] - length;
        			nbrCuts++;
        		}
        	}
    		
        	System.out.println(nbrCuts);
        	
    		length = getLowestLength(sticks);
    	};

    }
    
    static int getLowestLength(int[] sticks) {
    	int length = 0;
    	
    	for (int i=0; i<sticks.length; i++) {
    		if (sticks[i] > 0) {
    			if (sticks[i] < length) {
    				length = sticks[i];
    			} else if (length == 0) {
    				length = sticks[i];
    			}
    		}
    	}

    	return length;
    }
}
