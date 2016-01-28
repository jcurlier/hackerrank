import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommonChild2 {
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
    	
    	Node root = new Node();
    	
    	run(clean1, clean2, 0, 0, root);
    	
    	//if (DEBUG) debug("solution: " + text);
    	//result = text.length();
    	
    	return result;
    }
    
    private static void run(String clean1, String clean2, int index1, int index2, Node parent) {
    	
    	if (DEBUG) debug(index1 + ":" + index2);
    	
    	// end of the s1 string
    	if (index1 >= clean1.length()) {
    		return;
    	}
    	
    	// pick up the current character
    	char c = clean1.charAt(index1);
    	
		// find it in string2
		int pos = clean2.substring(index2).indexOf(c);
		if (pos >= 0) {
			
    		// take it
			Node node = new Node(c, parent);
			run(clean1, clean2, index1 + 1, index2 + pos + 1, node);
		
		// end of the s2 string
		}
    	
   		// leave it
		run(clean1, clean2, index1 + 1, index2, parent);
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
    
    public static class Node {
        private char c;
        private Node parent;
        private List<Node> children = new ArrayList<Node>();
        
        public Node() {
        	this.parent = null;
        }
        
        public Node(char c, Node parent) {
        	this.c = c;
        	this.parent = parent;
        	this.parent.addChild(this);
        }
        
        public Node getParent() {
        	return this.parent;
        }
        
        public char getChar() {
        	return this.c;
        }
        
        public List<Node> getChildren() {
        	return this.children;
        }
        
        public void addChild(Node node) {
        	this.children.add(node);
        }
    } 
}
