import java.util.Scanner;

public class Anagram {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        
        for(int i = 0; i < t; i++){
            System.out.println(Solve(in.nextLine()));
        }
        in.close();
    }
    
    private static int Solve(String input){
    	int length = input.length();
    	
    	if ((length % 2) == 1) {
    		return -1;
    	}
    	
    	int pos = (length / 2);
    	String s1 = input.substring(0, pos);
    	String s2 = input.substring(pos);
    	
	    int[] s1Count = buildAlphabet(s1);
	    int[] s2Count = buildAlphabet(s2);
	    
	    int number = 0;
	    for (int i=0; i<26; i++) {
	    	number = number + Math.abs(s1Count[i] - s2Count[i]);
	    }

	    number = number / 2;
	    
        return number;
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
