import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

public class TwoStrings {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        
        for(int i = 0; i < t; i++){
            System.out.println(Solve(in.nextLine(), in.nextLine()));
        }
        in.close();
    }
    
    private static String Solve(String a, String b) {
    	ArrayList<String> alreadySearched = new ArrayList<String>();
    	
    	for (int i=0; i<a.length(); i++) {
    		String sub = a.substring(i, i + 1);
    		if (!alreadySearched.contains(sub) && b.indexOf(sub) >= 0) {
    			return "YES";
    		}
    		alreadySearched.add(sub);
    	}
    	
    	return "NO";
    }
    
}
