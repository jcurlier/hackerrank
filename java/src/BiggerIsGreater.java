import java.util.Scanner;

public class BiggerIsGreater {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        
        for(int i = 0; i < t; i++){
            System.out.println(Solve(in.nextLine()));
        }
        in.close();
    }
    
    private static String Solve(String input){
   
    	char[] chars = input.toCharArray();
    	
    	int[] alphabet = new int[26];
    	
    	for (int i=chars.length-1; i>=0; i--) {
    		int ascii = getAscii(chars[i]);
    		for (int j=ascii+1; j<26; j++) {
    			if (alphabet[j] > 0) {
    				alphabet[ascii]++;
    				StringBuilder builder = new StringBuilder();
    				builder.append(input.substring(0, i));
    				builder.append((char) (j + 97));
    				alphabet[j]--;
    				for (int k=0; k<26; k++) {
    					for (int l=0; l<alphabet[k]; l++) {
    						builder.append((char) (k + 97));
    					}
    				}
    				return builder.toString();
    			}
    		}
    		alphabet[ascii]++;	
    	}
    	
    	return "no answer";
    }
    
    
    private static int getAscii(char c) { 

		int ascii = (int) c;
		if (ascii >= 97 && ascii<= 122) {
			ascii = ascii - 97;
		}
    	
    	return ascii;
    }
}
