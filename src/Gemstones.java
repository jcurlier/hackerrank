import java.util.Scanner;

public class Gemstones {

    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    
	    int n = in.nextInt();
	    in.nextLine();
	    
	    boolean[][] alphabet = new boolean[n][26];

	    for (int i=0; i<n; i++) {
	    	String line = in.nextLine();
	    	alphabet[i] = buildAlphabet(line);
	    }
	    
	    int number = 0;
	    for (int i=0; i<26; i++) {
	    	for (int j=0; j<n; j++) {
	    		if (alphabet[j][i]) {
	    			if (j == n-1) {
	    				number++;
	    			}
	    		} else {
	    			break;
	    		}
	    	}
	    }
	    
	    System.out.println(number);
	    in.close();
    }
    
    private static boolean[] buildAlphabet(String input) { 
    	boolean[] alphabet = new boolean[26];
    	
    	char[] chars = input.toCharArray();
    	for (int i=0; i<chars.length; i++) {
    		int ascii = (int) chars[i];
    		if (ascii >= 97 && ascii<= 122) {
    			ascii = ascii - 97;
    			alphabet[ascii] = true;
    		}
    	}
    	
    	return alphabet;
    }
    
}
