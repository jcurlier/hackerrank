import java.util.Scanner;

public class GamesOfThrones {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println(Solve(in.nextLine()));
        
        in.close();
    }
    
    private static String Solve(String input){
        
	    char[] chars = input.toCharArray();
	    int[] alphabet = new int[26];
	    
	    for (int i=0; i<chars.length; i++) {

    		int ascii = (int) chars[i];
    		if (ascii >= 97 && ascii<= 122) {
    			ascii = ascii - 97;
    			alphabet[ascii]++;
    		}
	    }
	    
	    boolean hasOneOdd = false;
	    
	    for (int i=0; i<alphabet.length; i++) {
	    	
	    	if ((alphabet[i] % 2) == 0) {
	    		continue;
	    	} else if (!hasOneOdd && ((chars.length % 2) == 1)) {
	    		hasOneOdd = true;
	    	} else {
	    		return "NO";
	    	}
	    }
	    
	    return "YES";
    }
    
    
}
