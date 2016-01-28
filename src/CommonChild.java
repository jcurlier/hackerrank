import java.util.Scanner;

public class CommonChild {
	public final static boolean DEBUG = false;
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();

        long startTime = System.currentTimeMillis();

        Solve(s1, s2);

        long endTime = System.currentTimeMillis();

        System.out.println("That took " + (endTime - startTime) + " milliseconds");
        
        in.close();
    }
    
    private static String Solve(String s1, String s2) {
    	if (DEBUG) debug("s1:" + s1);
    	if (DEBUG) debug("s2:" + s2);
    	
    	int[] alphabet1 = buildAlphabet(s1);
    	int[] alphabet2 = buildAlphabet(s2);
    	
    	int[] alphabet = buildCommonAlphabet(alphabet1, alphabet2);
    	
    	String clean1 = clean(s1, alphabet);
    	String clean2 = clean(s2, alphabet);
    			
    	System.out.println(process(clean1, clean2, alphabet));
    	
    	return "";
    }
    
    private static int process(String clean1, String clean2, int[] alphabet) {
    	int result = -1;
    	
    	if (DEBUG) debug("clean1:" + clean1);
    	if (DEBUG) debug("clean2:" + clean2);
    	
    	if (clean1.length() == 0 && clean2.length() == 0) {
    		return 0;
    	}
    	
    	String text = run(clean1, clean2, 0, 0, "");
    	
    	if (DEBUG) debug("solution: " + text);
    	result = text.length();
    	
    	return result;
    }
    
    private static String run(String clean1, String clean2, int index1, int index2, String str) {
    	
    	if (DEBUG) debug(index1 + ":" + index2 + ":" + str);
    	
    	// end of the s1 string
    	if (index1 >= clean1.length()) {
    		return str;
    	}
    	
    	// pick up the current character
    	char c = clean1.charAt(index1);
    	
    	String str1 = null;
    	String str2 = null;
    	
		// find it in string2
		int pos = clean2.substring(index2).indexOf(c);
		if (pos >= 0) {
			
    		// take it
			str1 = run(clean1, clean2, index1 + 1, index2 + pos + 1, str + c);
		
		// end of the s2 string
		} else {
			str1 = str;
		}
    	
   		// leave it
		str2 = run(clean1, clean2, index1 + 1, index2, str);
    	
		if (str1 == null && str2 == null) {
			return null;
		} else if (str1 == null && str2 != null) {
			return str2;
		}else if (str1 != null && str2 == null) {
			return str1;
		} else if (str1.length() > str2.length()) {
			return str1;
		} else {
			return str2;
		}
    }
    
    
    private static void debug(String s) {
    		System.out.println(s);
    }
    
    private static int[] buildAlphabet(String input) { 
    	int[] alphabet = new int[26];
    	
    	char[] chars = input.toCharArray();
    	for (int i=0; i<chars.length; i++) {
    		int ascii = getIndex(chars[i]);
    		alphabet[ascii] = alphabet[ascii] + 1;
    	}
    	
    	return alphabet;
    }
    
    private static int getIndex(char c) { 
		int ascii = (int) c;
		if (ascii >= 65 && ascii<= 90) {
			ascii = ascii - 65;
		} else {
			throw new RuntimeException("ascii not found " + ascii);
		}
		return ascii;
    }
    
    private static int[] buildCommonAlphabet(int[] a1, int[] a2) { 
    	int[] alphabet = new int[26];
    	
    	for (int i=0; i<alphabet.length; i++) {
    		alphabet[i] = Math.min(a1[i], a2[i]);
    	}
    	
    	return alphabet;
    }
    
    private static String clean(String s, int[] alphabet) {
    	char[] chars = s.toCharArray();
    	StringBuilder builder = new StringBuilder();
    	
    	for (int i=0; i<chars.length; i++) {
    		int ascii = getIndex(chars[i]);
    		if ((alphabet[ascii] > 0)) {
    			builder.append(chars[i]);
    		}
    	}
    	
    	return builder.toString();
    	
    }
}
