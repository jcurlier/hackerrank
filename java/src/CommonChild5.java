import java.util.Scanner;

public class CommonChild5 {
	public final static boolean DEBUG = false;
	public final static boolean TIME = false;
	
	public static int[][] rowWeightCache;
	public static int[][] columnWeightCache;
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();

        long startTime = System.currentTimeMillis();

        Solve(s1, s2);

        long endTime = System.currentTimeMillis();

        if (TIME) debug("That took " + (endTime - startTime) + " milliseconds");
        
        in.close();

    }
    
    private static void Solve(String s1, String s2) {
    	if (DEBUG) debug("s1:" + s1);
    	if (DEBUG) debug("s2:" + s2);
    	
    	int result = 0;
    	
    	int n = s1.length();
    	
    	char[] c1 = s1.toCharArray();
    	char[] c2 = s2.toCharArray();
    	
    	int[][] weight = new int[n][n];
    	
    	rowWeightCache = new int[n][n];
    	columnWeightCache = new int[n][n];
    	
    	for (int i=n-1; i>=0; i--) { // columns
    		for (int j=n-1; j>=0; j--) { // rows
    			int extraWeight = 0;
    			if (i<n-1 && j<n-1) {
    				extraWeight = findBiggestWeight(weight, i+1, j+1);
    			}
    			if (c1[i] == c2[j]) extraWeight++;
    			
    			weight[j][i] = extraWeight;
    			result = Math.max(result, extraWeight);
    		}
    	}
    	
    	if (DEBUG)  displayWeightMatrix(weight);
    	
    	System.out.println(result);
    }
    
    private static void debug(String s) {
    		System.out.println(s);
    }
    
    private static void displayMatrix(boolean[][] matrix) {
    	int n = matrix.length;
    	
    	for (int i=0; i<n; i++) {
    		for (int j=0; j<n; j++) {
    			if (matrix[j][i]) {
    				System.out.print("X");
    			} else {
    				System.out.print(" ");
    			}
    		}
    		System.out.println();
    	}
    }

    private static int findBiggestWeight(int[][] weight, int col, int row) {
    	int n = weight.length;
    	int max = 0;
    	// rows
    	int rowWeight = 0;
    	if (row < n - 1) {
    		rowWeight = rowWeightCache[row+1][col];
    	}
    	max = rowWeight;
    	
       	int columnWeight = 0;
    	if (col < n - 1) {
    		columnWeight = columnWeightCache[row][col+1];
    	}
    	max = Math.max(max, columnWeight);
    	
    	int cellWeight = weight[row][col];
    	max = Math.max(max, cellWeight);
    	
    	rowWeightCache[row][col] = Math.max(rowWeight,cellWeight);
    	columnWeightCache[row][col] = Math.max(columnWeight, cellWeight);
    			
    	if (DEBUG) debug(col + ":" + row + "=" + max);
    	return max;
    }
    
    private static void displayWeightMatrix(int[][] matrix) {
    	int n = matrix.length;
    	
    	for (int i=0; i<n; i++) {
    		for (int j=0; j<n; j++) {
    			System.out.print(matrix[i][j]);
    		}
    		System.out.println();
    	}
    }
}
