import java.util.Scanner;

public class GridSearch {

	public static void main(String[] args) {
		
	    Scanner in = new Scanner(System.in);
	    int t = in.nextInt();

	    for(int i=0; i<t; i++) {
	    	
	    	int gridheight = in.nextInt();
	    	in.nextInt();

	    	String[] grid = new String[gridheight];
	    	in.nextLine();
	    	
	    	for(int j=0; j<gridheight; j++) {
	    		grid[j] = in.nextLine();
	    	}
	    	
	    	int patternHeight = in.nextInt();
	    	in.nextInt();
	    	
	    	String[] pattern = new String[patternHeight];
	    	in.nextLine();
	    	
	    	for(int j=0; j<patternHeight; j++) {
	    		pattern[j] = in.nextLine();
	    	}
	    	
	    	if (hasPattern(grid, pattern)) {
	    		System.out.println("YES");
	    	} else {
	    		System.out.println("NO");
	    	}
	    	
	    }
	    
	    in.close();
	}    
	
    static boolean hasPattern(String[] grid, String[] pattern) {
    	boolean result = false;
    	
    	for (int i=0; i < grid.length-pattern.length + 1; i++) {
    		
    		int position = grid[i].indexOf(pattern[0]);
    		
    		while (position >= 0) {
    			for (int j=1; j<pattern.length; j++) {
    				String search = grid[i + j].substring(position);
    				if (search.indexOf(pattern[j]) == 0) {
    					if (j == pattern.length - 1) {
    						return true;
    					}
    					continue;
    				} else {
    					break;
    				}
    			}
    			position = grid[i].indexOf(pattern[0],position + 1);
    		}
    	}
    	
    	return result;
    }
}
