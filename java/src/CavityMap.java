import java.util.Scanner;

public class CavityMap {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        
        char[][] grid = new char[n][n];
        
        for(int i=0; i<n; i++){
            String line = in.nextLine();
            for (int j=0; j<line.length(); j++) {
            	grid[i][j] = line.charAt(j);
            }
        }
        
        Process(grid, n);
        
    	for (int i=0; i<n; i++) {
        	for (int j=0; j<n; j++) {
        		System.out.print(grid[i][j]);
        	}
        	System.out.println();
    	}
        in.close();
    }
    
    private static void Process(char[][] grid, int n) {
  	
    	for (int i=1; i<n-1; i++) {
        	for (int j=1; j<n-1; j++) {

        		int depth = getDepth(grid[i][j]);
        		
        		int eastDepth = getDepth(grid[i-1][j]);
        		int westDepth = getDepth(grid[i+1][j]);
        		int southDepth = getDepth(grid[i][j+1]);
        		int northDepth = getDepth(grid[i][j-1]);
        		
        		if (depth > eastDepth && depth > westDepth && depth > southDepth && depth > northDepth) {
        			grid[i][j] = 'X';
        		}
        		
        	}
    	}
    }
    
    private static int getDepth(char c) {
    	int depth;
    	
    	if (c == 'X') {
    		depth = 9;
    	} else {
    		depth = (((int) c) - 48);
    	}
    	
    	return depth;
    }
}
