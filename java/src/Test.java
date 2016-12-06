
public class Test {

	public static void main(String[] args) {

		for (int i=1; i<=100000; i++) {
			if (i % 15 == 0) {
				System.out.println("The number " + i + "is divided by 3 and 5.");
			} else if (i % 5 == 0) {
				System.out.println("The number " + i + "is divided by 5.");
			} else if (i % 3 == 0) {
				System.out.println("The number " + i + "is divided by 3.");
			} 
		}
	}

}
