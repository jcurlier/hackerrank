import java.util.Scanner;

public class FunnyString {

    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    
	    int t = in.nextInt();
	    in.nextLine();

	    for (int test=0; test<t; test++) {
	    	String line = in.nextLine();
	    
	    	//System.out.println(line);
	    	
	    	char[] chars= line.toCharArray();

	    	for (int i=1; i<chars.length; i++) {
	    		
	    		int s = (int) chars[i];
	    		int sminusone = (int) chars[i - 1];
	    		
	    		int r = (int) chars[chars.length - i - 1];
	    		int rminusone = (int) chars[chars.length - i];
	    		
	    		//System.out.println(s + "-" + sminusone + " == " + r + "-" + rminusone);
	    		
	    		if (Math.abs(s - sminusone) == Math.abs(r - rminusone)) {
	    			if (i<chars.length-1) {
	    				continue;
	    			} else {
	    				System.out.println("Funny");
	    				break;
	    			}
	    		} else {
    				System.out.println("Not Funny");
    				break;
	    		}
	    	}
	    }
	    
	    in.close();
    }  
}
