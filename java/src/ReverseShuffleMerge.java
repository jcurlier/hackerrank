import java.util.Scanner;

public class ReverseShuffleMerge {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println(Solve(in.nextLine()));

		in.close();
	}

	private static String Solve(String input) {
		int[] alphabet = buildAlphabet(input);
		
		int[] word = new int[26]; // letter in the word
		int[] ignored = new int[26]; // letter already ignored
		int[] ignoredSinceLastAdd = new int[26]; // letter ignored since last add
		String ignoredSinceLastAddStr = "";
		int[] remaining = new int[26]; // letter still needed
		
		for (int i = 0; i < alphabet.length; i++) {
			word[i] = alphabet[i] / 2;
			remaining[i] = alphabet[i] / 2;
		}

		String reverse = new StringBuilder(input).reverse().toString();
		char[] reverseChars = reverse.toCharArray();

		//System.out.println("reverse:" + reverse);
		
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < reverseChars.length; i++) {
			
			//System.out.println("processing " + reverseChars[i]);
			
			int ascii = (int) reverseChars[i];
			ascii = ascii - 97;
			
			// ignored all for this letter already
			if (ignored[ascii] == word[ascii]) {
				if (remaining[ascii] > 0) {
					
					// add some lower letters ignored first
					for (int j=0; j<ascii; j++) {
						char c = (char) (j + 97);
						if (ignoredSinceLastAdd[j] > 0 && ignoredSinceLastAddStr.indexOf(c) >= 0) {
							for (int k=0; k<ignoredSinceLastAdd[j]; k++) {
								if (remaining[j] > 0) {
									remaining[j]--;
									ignored[j]--;
									builder.append(c);
									System.out.println("add previously ignored (" + j + ") rem: " + remaining[j] + " " + c);
								}
							}
						
							int currentPos = ignoredSinceLastAddStr.lastIndexOf(c);
							ignoredSinceLastAddStr = ignoredSinceLastAddStr.substring(currentPos + 1);
							ignoredSinceLastAdd = buildAlphabet(ignoredSinceLastAddStr);
						}
					}
					
					System.out.println("must add ignoredSinceLastAdd " + ignoredSinceLastAddStr);
					remaining[ascii]--;
					builder.append(reverseChars[i]);
					ignoredSinceLastAddStr = "";
					ignoredSinceLastAdd = new int[26]; 
					System.out.println("must add " + reverseChars[i]);
				}
			} else {
				boolean didIgnore = false;
				for (int j=0; j<ascii; j++) {
					if (remaining[j] > 0) {
						//System.out.println("ignoring " + reverseChars[i]);
						didIgnore = true;
						ignored[ascii]++;
						ignoredSinceLastAdd[ascii]++;
						ignoredSinceLastAddStr = ignoredSinceLastAddStr + reverseChars[i];
						break;
					}
				}
				if (!didIgnore && remaining[ascii] > 0) {
					remaining[ascii]--;
					builder.append(reverseChars[i]);
					ignoredSinceLastAdd = new int[26];
					ignoredSinceLastAddStr = "";
					System.out.println("add " + reverseChars[i]);
				}
			}
		}

		
		return builder.toString();
	}

	private static int[] buildAlphabet(String input) {
		int[] alphabet = new int[26];

		char[] chars = input.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			int ascii = (int) chars[i];
			if (ascii >= 97 && ascii <= 122) {
				ascii = ascii - 97;
				alphabet[ascii]++;
			}
		}

		return alphabet;
	}
}
