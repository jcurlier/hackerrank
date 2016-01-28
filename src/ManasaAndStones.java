import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ManasaAndStones {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int t = in.nextInt();

        for (int i=0; i<t; i++) {

        	int numberOfStones = in.nextInt();
        	int a = in.nextInt();
        	int b = in.nextInt();
        	
        	process(numberOfStones, a, b);
        }
        
        in.close();
    }
    
    static void process(int numberOfStones, int a, int b) {
    	int numberOfDifferences = numberOfStones - 1; //first stone is zero
    	
    	List<Integer> solutions = new ArrayList<Integer>();
    	
    	for(int i = 0; i <= numberOfDifferences; i++) {
    		int solution = i * a + (numberOfDifferences - i) * b;
    		if (!solutions.contains(new Integer(solution))) {
    			solutions.add(new Integer(solution));
    		}
    	}
    	
    	Collections.sort(solutions);
    	
    	for(int i = 0; i < solutions.size(); i++) {
    		if (i>0) System.out.print(" ");
    	    System.out.print(solutions.get(i));
    	}  

    	System.out.println();
    }
}
