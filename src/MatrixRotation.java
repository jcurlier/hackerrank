import java.util.Scanner;

public class MatrixRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int rows = in.nextInt();
        int columns = in.nextInt();
        int rotations = in.nextInt();
        
        int[][] matrix = new int[rows][columns];

        for (int i=0; i<rows; i++) {
        	for (int j=0; j<columns; j++) {
        		matrix[i][j] = in.nextInt();
        	}
        }
        
    	int numberPivots = (int) rows/2;
    	if (((int) columns/2) < numberPivots) numberPivots = ((int) columns/2);
    	
        int[] pivot = buildCycleForPivot(rows, columns, numberPivots);
        
        for (int i=0; i<numberPivots; i++) {
        	int pivotRotation = (int) (rotations % pivot[i]);
        	rotate(matrix, rows, columns, i, pivotRotation, pivot[i]);
        }

        StringBuilder builder = new StringBuilder(); 
        for (int i=0; i<rows; i++) {
        	for (int j=0; j<columns; j++) {
        		if (j > 0) builder.append(" ");
        		builder.append(matrix[i][j]);
        	}
        	builder.append(System.getProperty("line.separator"));
        }
        
        System.out.println(builder.toString());
        
        in.close();
    }
    
    static void rotate(int[][] matrix, int rows, int columns, int pivot, int rotation, int numberOfCells) {
    	
    	int[] values = new int[numberOfCells];

    	// read the pivot numbers
    	int k = 0;
    	for (int i=pivot; i<rows-pivot; i++) {
    		values[k] = matrix[i][pivot];
    		k++;
    	}
    	for (int i=pivot+1; i<columns-pivot; i++) {
    		values[k] = matrix[rows-pivot-1][i];
    		k++;
    	}
    	for (int i=rows-pivot-2; i>=pivot; i--) {
    		values[k] = matrix[i][columns-pivot-1];
    		k++;
    	}
    	for (int i=columns-pivot-2; i>pivot; i--) {
    		values[k] = matrix[pivot][i];
    		k++;
    	}
    	
    	int[] newValues = new int[numberOfCells];
    	for (int i=0; i<numberOfCells; i++) {
    		int newIndex = i - rotation;
    		if (newIndex < 0) newIndex = newIndex + numberOfCells;
    		newValues[i] = values[newIndex];
    	}
    	
    	// fill the pivot numbers
    	k = 0;
    	for (int i=pivot; i<rows-pivot; i++) {
    		matrix[i][pivot] = newValues[k];
    		k++;
    	}
    	for (int i=pivot+1; i<columns-pivot; i++) {
    		matrix[rows-pivot-1][i] = newValues[k];
    		k++;
    	}
    	for (int i=rows-pivot-2; i>=pivot; i--) {
    		matrix[i][columns-pivot-1] = newValues[k];
    		k++;
    	}
    	for (int i=columns-pivot-2; i>pivot; i--) {
    		matrix[pivot][i] = newValues[k];
    		k++;
    	}
    }
    
    static int[] buildCycleForPivot(int rows, int columns, int numberPivots) {
    	int[] pivot = new int[numberPivots];
    	
        for (int i=0; i<numberPivots; i++) {
        	int count = 0;
        	
        	// row
        	count = count + 2 * (columns - 2 * i);

        	// columns
        	count = count + 2 * (rows - 2 * i);
        	
        	// remove duplicates
        	count = count - 4;
        	
        	pivot[i] = count;
        }
        
    	return pivot;
    }
}
