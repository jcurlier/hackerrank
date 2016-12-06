import java.util.Scanner;

class DiagonalDifference {

    static int sumDiagonal(int[][] intMatrix) {
    	int sum = 0;
    	int diag1 = 0;
    	int diag2 = 0;
    	
    	int size = intMatrix.length;
    	
    	for (int i=0; i<size; i++) { 
    		diag1 = diag1 + intMatrix[i][i];
    		diag2 = diag2 + intMatrix[size - i -1][i];
    	}
    	
    	sum = Math.abs(diag1 - diag2);
    	
    	return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int t = in.nextInt();
        int[][] intMatrix = new int[t][t];
        
        for (int i=0; i<t; i++) {
        	for (int j=0; j<t; j++) {
        		intMatrix[i][j] = in.nextInt();
        	}
        }

        int sum = sumDiagonal(intMatrix);
        System.out.println(sum);
        
        in.close();
    }
}
