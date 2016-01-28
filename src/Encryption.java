import java.util.Scanner;

public class Encryption {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        
        line = line.replace(" ", "");
        
        double sqrt = Math.sqrt(line.length());
        
        int rows = (int) Math.floor(sqrt);
        int columns = (int) Math.ceil(sqrt);
        
        while (rows * columns < line.length()) {
        	if (rows < columns) {
        		rows = rows + 1;
        	} else {
        		columns = columns + 1;
        	}
        }
        
        for (int i=0; i<columns; i++) {
        	for (int j=0; j<rows; j++) {
        		int pos = j * columns + i;
        		if (pos < line.length()) {
        			System.out.print(line.substring(pos, pos + 1));
        		}
        	}
    		if (i<columns - 1) System.out.print(" ");
        	
        }
        in.close();
    }	
	
}

