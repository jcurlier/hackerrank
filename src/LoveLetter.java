import java.util.Scanner;

public class LoveLetter {

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
        int number = 0;
        
		if (isPalindrome(input)) {
			return 0;
		}
		
        char[] chars = input.toCharArray();
        
       	for (int i=0; i<chars.length/2; i++) {
       		char c1 = chars[i];
       		char c2 = chars[chars.length - i - 1];
       		
    		if (c1 != c2) {
    			
    			number = number + Math.abs(((int) c1) - ((int) c2));
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
}
