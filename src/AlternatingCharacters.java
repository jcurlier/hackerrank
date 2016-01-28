import java.util.Scanner;

public class AlternatingCharacters {

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
        int number = 0;
        
	    char[] chars = input.toCharArray();
	    char previousChar = '0';
	    
	    for (int i=0; i<chars.length; i++) {
	    	if (chars[i] == previousChar) {
	    		number++;	
	    	}
	    	previousChar = chars[i];
	    }
        return number;
    }
    
}
