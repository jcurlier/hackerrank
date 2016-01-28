import java.util.Scanner;

public class ReverseShuffleMerge2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println(Solve(in.nextLine()));

		in.close();
	}

	private static int[] letters = new int[26]; // letters in the word
	private static int[] garbage = new int[26]; // letters to be disregarded
	private static int[] ignored = new int[26]; // letters already ignored
	private static int[] ignoredSinceLastAdd = new int[26]; // letter ignored since last add
	private static String ignoredSinceLastAddStr = "";
	private static int[] remaining = new int[26]; // letter still needed
	private static StringBuilder builder = new StringBuilder();
	private static char[] reverseChars;
	private static int cursor = 0;
	
	private static String Solve(String input) {
		
		buildLetterCount(input);

		String reverse = new StringBuilder(input).reverse().toString();
		reverseChars = reverse.toCharArray();
		////System.out.println("reverse:" + reverse);
		int inputLength = reverseChars.length;
		
		while (cursor < inputLength) {
			
			////System.out.println("processing " + reverseChars[i]);
			
			int ascii = getIndex(reverseChars[cursor]);
			
			// did not ignored all for this letter
			// not required to add it
			if (ignored[ascii] < garbage[ascii]) {
			
				// look if there is something smaller still coming
				boolean didIgnore = false;
				for (int j=0; j<ascii; j++) {
					if (remaining[j] > 0) {
						//System.out.println("ignoring " + reverseChars[cursor] + " ignored already " + (ignored[ascii] + ignoredSinceLastAdd[ascii]) + "/" + remaining[j]);
						didIgnore = true;
						ignored[ascii]++;
						ignoredSinceLastAdd[ascii]++;
						ignoredSinceLastAddStr = ignoredSinceLastAddStr + reverseChars[cursor];
						break;
					}
				}
				if (!didIgnore) {
					//System.out.println("add " + reverseChars[cursor]);
					add(ascii);
				}
			
			// we are required to add it - no more to ignore
			// and still some to be added
			} else if (remaining[ascii] > 0) {
			
				// add some lower letters ignored first
				for (int j=0; j<ascii; j++) {
					char c = getAscii(j);
					
					if (ignoredSinceLastAdd[j] > 0 && ignoredSinceLastAddStr.indexOf(c) >= 0) {
						for (int k=0; k<ignoredSinceLastAdd[j]; k++) {
							if (remaining[j] > 0) {
								remaining[j]--;
								ignored[j]--;
								builder.append(c);
								//System.out.println("add previously ignored (" + j + ") rem: " + remaining[j] + " " + c);
							}
						}
					
						int currentPos = ignoredSinceLastAddStr.lastIndexOf(c);
						ignoredSinceLastAddStr = ignoredSinceLastAddStr.substring(currentPos + 1);
						ignoredSinceLastAdd = buildAlphabet(ignoredSinceLastAddStr);
					}
				}

				// check if there is the same char in the ignored string
				int currentPos = ignoredSinceLastAddStr.indexOf(reverseChars[cursor]);
				if (currentPos >= 0) {
					// there is one - add this one instead
					cursor = cursor - (ignoredSinceLastAddStr.length() - currentPos);
					ignored[ascii]--;
					ignoredSinceLastAddStr = ignoredSinceLastAddStr.substring(currentPos + 1);
					ignoredSinceLastAdd = buildAlphabet(ignoredSinceLastAddStr);
					for (int j=0; j<26; j++) {
						ignored[j] = ignored[j] - ignoredSinceLastAdd[j];
					}
					add(ascii);
				}
				else 
				{
					add(ascii);
					//System.out.println("must add " + reverseChars[cursor]);
				}
			}
	
			cursor++;
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
	
	private static void buildLetterCount(String input) {
		// get the letter count for the input
		int[] alphabet = buildAlphabet(input);
		
		for (int i = 0; i < alphabet.length; i++) {
			letters[i] = alphabet[i] / 2;
			remaining[i] = alphabet[i] / 2;
			garbage[i] = alphabet[i] / 2;
		}
	}
	
	private static char getAscii(int index) {
		return (char) (index + 97);
	}
	
	private static int getIndex(char c) {
		int ascii = (int) c;
		ascii = ascii - 97;
		
		return ascii;
	}
	
	private static void add(int ascii) {
		if (remaining[ascii] > 0) {
			remaining[ascii]--;
			builder.append(reverseChars[cursor]);
			
			// clear the ignore
			for (int i = 0; i < 26; i++) {
				ignoredSinceLastAdd[i] = 0;
			}
			ignoredSinceLastAddStr = "";
		}
		
	}
}
