import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShelockAndAnagrams {

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
        int inputLength = input.length();
        
        Map<String,Integer> substr = new HashMap<String, Integer>();
        
        for (int subLength = 1; subLength < inputLength; subLength++) {
        	
        	int pos = 0;
        	while (pos <= inputLength - subLength) {
        		String str = input.substring(pos, pos + subLength);
        		
        		String key = sort(str);
        		
        		if (substr.containsKey(key)) {
        			int count = substr.get(key);
        			number = number + count;
        			substr.remove(key);
        			substr.put(key, count + 1);
        		} else {
        			substr.put(key, 1);
        		}
        		
        		pos++;
        	}
        	
        }
        

        return number;
    }
    
    private static String sort(String input) { 
    	int[] alphabet = new int[26];
    	
    	char[] chars = input.toCharArray();
    	for (int i=0; i<chars.length; i++) {
    		int ascii = (int) chars[i];
    		if (ascii >= 97 && ascii<= 122) {
    			ascii = ascii - 97;
    			alphabet[ascii]++;
    		}
    	}
    	
    	StringBuilder builder = new StringBuilder();
    	for (int i=0; i<alphabet.length; i++) {
    		for (int j=0; j<alphabet[i]; j++) {
    			builder.append((char) (i + 97));
    		}
    	}
    	
    	return builder.toString();
    }
}
