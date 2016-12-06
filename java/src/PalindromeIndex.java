import java.util.Scanner;

public class PalindromeIndex {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        
        for(int i = 0; i < t; i++) {
            System.out.println(Solve(in.nextLine()));
        }
        in.close();
    }
    
    private static int Solve(String input){
        int number = -2;
        
		if (isPalindrome(input)) {
			return -1;
		}
		
        char[] chars = input.toCharArray();
        
       	for (int i=0; i<chars.length/2+1; i++) {
    		if (chars[i] != chars[chars.length - i - 1]) {
    			
    			String s1 = removePos(input, i);
    			if (isPalindrome(s1)) {
    				return i;
    			}
    			String s2 = removePos(input, chars.length - i - 1);
    			if (isPalindrome(s2)) {
    				return chars.length - i - 1;
    			}
    			
    			
    		}
    	}

        return number;
    }
    
    private static boolean isPalindrome(String input) {
    	char[] chars = input.toCharArray();
    	
    	for (int i=0; i<chars.length/2+1; i++) {
    		if (chars[i] != chars[chars.length - i - 1]) {
    			return false;
    		}
    	}
    	    	
    	return true;
    }
    
    private static String removePos(String input, int pos) {
    	if (pos==0) {
    		return input.substring(1);
    	} else if (pos == input.length() - 1) {
    		return input.substring(0, input.length() - 2);
    	} else {
    		return input.substring(0, pos) + input.substring(pos + 1);
    	}
    }
}
