import java.util.Scanner;

public class ServiceLane {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int nbrCases = 0;
        int roadSize = 0;
        
        roadSize = in.nextInt();
        nbrCases = in.nextInt();

        int[] laneWidths = new int[roadSize];
        for (int i=0; i<roadSize; i++) {
        	laneWidths[i] = in.nextInt();
        }
        
        for (int i=0; i<nbrCases; i++) {
        	int entry = in.nextInt();
        	int exit = in.nextInt();
        	
        	process(entry, exit, laneWidths);
        }
        
        in.close();
        
    }
    
    static void process(int entry, int exit, int[] laneWidths) {
    	
    	int minimum = laneWidths[entry];
    	
    	for (int i=entry+1; i<=exit; i++) {
    		if (laneWidths[i] < minimum) {
    			minimum = laneWidths[i];
    		}
    	}

    	System.out.println(minimum);
    }
}
