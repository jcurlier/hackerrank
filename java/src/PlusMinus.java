import java.util.Scanner;

class PlusMinus {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int t = in.nextInt();
        int[] intMatrix = new int[t];
        
        for (int i=0; i<t; i++) {
        	intMatrix[i] = in.nextInt();
        }

        double numberPositive = numberPositive(intMatrix);
        double numberNegative = numberNegative(intMatrix);
        double numberZeros= numberZeros(intMatrix);

        double fractionPositive = numberPositive / t;
        double fractionNegative = numberNegative / t;
        double fractionZeros = numberZeros / t;
        
        System.out.println(String.format("%.3f",fractionPositive));
        System.out.println(String.format("%.3f",fractionNegative));
        System.out.println(String.format("%.3f",fractionZeros));
        
        
        in.close();
    }
	
    static int numberPositive(int[] intMatrix) {
    	int n = 0;
    	int size = intMatrix.length;
    	
    	for (int i=0; i<size; i++) { 
    		if (intMatrix[i] > 0) n++;
    	}
    	
    	return n;
    }
    
    static int numberNegative(int[] intMatrix) {
    	int n = 0;
    	int size = intMatrix.length;
    	
    	for (int i=0; i<size; i++) { 
    		if (intMatrix[i] < 0) n++;
    	}
    	
    	return n;
    }
    
    static int numberZeros(int[] intMatrix) {
    	int n = 0;
    	int size = intMatrix.length;
    	
    	for (int i=0; i<size; i++) { 
    		if (intMatrix[i] == 0) n++;
    	}
    	
    	return n;
    }
}
