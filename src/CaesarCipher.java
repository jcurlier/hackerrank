import java.util.Scanner;

public class CaesarCipher {

    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    
	    in.nextInt();
	    in.nextLine();
	    
	    String input = in.nextLine();
	    
	    int key = in.nextInt();
	    
	    System.out.println(Cypher(input, key));
	    	
	    in.close();
    }    
    // 65 - 90 lowercsase
    // 97 - 122 uppercase
    private static String Cypher(String input, int key) {
    	
    	String output = null;
    	key = key % 26;
    	
    	char[] chars= input.toCharArray();
    	for (int i=0; i<chars.length; i++) {
    		int ascii = (int) chars[i];
    		
    		if (ascii >= 65 && ascii<= 90) {
        		ascii = ascii + key;
        		if (ascii > 90) {
        			ascii = ascii - 26; 
        		}
        		chars[i] = (char) ascii;
    		} else if (ascii >= 97 && ascii<= 122) {
        		ascii = ascii + key;
        		if (ascii > 122) {
        			ascii = ascii - 26; 
        		}
        		chars[i] = (char) ascii;
    		}
    	}
    	
    	output = String.valueOf(chars);
    	
    	return output;
    }
}
