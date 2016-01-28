import java.util.Scanner;

public class MakeItAnagram {

    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    
	    String a = in.nextLine();
	    String b = in.nextLine();
	    
	    int[] aCount = buildAlphabet(a);
	    int[] bCount = buildAlphabet(b);
	    
	    int number = 0;
	    for (int i=0; i<26; i++) {
	    	if (aCount[i] != bCount[i]) {
	    		number = number + Math.abs(aCount[i] - bCount[i]);
	    	}
	    }
	    
	    System.out.println(number);
	    in.close();
    }
    
    private static int[] buildAlphabet(String input) { 
    	int[] alphabet = new int[26];
    	
    	char[] chars = input.toCharArray();
    	for (int i=0; i<chars.length; i++) {
    		int ascii = (int) chars[i];
    		if (ascii >= 97 && ascii<= 122) {
    			ascii = ascii - 97;
    			alphabet[ascii]++;
    		}
    	}
    	
    	return alphabet;
    }
    
}
