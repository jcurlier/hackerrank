import java.util.Scanner;

public class Pangrams {

    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    
	    String line = in.nextLine();
	    	
	    char[] chars= line.toCharArray();
	    boolean[] alphabet= new boolean[26];

	    for (int i=0; i<chars.length; i++) {
	    		
    		int ascii = (int) chars[i];
    		
    		if (ascii >= 65 && ascii<= 90) {
        		ascii = ascii - 65; 
        		alphabet[ascii] = true;
    		} else if (ascii >= 97 && ascii<= 122) {
        		ascii = ascii - 97;
        		alphabet[ascii] = true;
    		}
    		
	    }
	    
	    for (int i=0; i<alphabet.length; i++) {
	    	if (alphabet[i] == false) {
	    		System.out.println("not pangram");
	    		break;
	    	} else if (i == alphabet.length - 1) {
	    		System.out.println("pangram");
	    		break;
	    	}
	    }
	    
	    
	    in.close();
    }
}
