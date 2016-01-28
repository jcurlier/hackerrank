import java.util.Calendar;
import java.util.Scanner;

public class LibraryFine {

	public static void main(String[] args) {
		//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		Scanner scan = new Scanner(System.in);

		int actualDay = scan.nextInt();
		int actualMonth = scan.nextInt() - 1;
		int actualYear = scan.nextInt();

		Calendar actual = Calendar.getInstance();
		actual.set(actualYear, actualMonth, actualDay);
		
		//System.out.println(formatter.format(actual.getTime()));
		
		int expectedDay = scan.nextInt();
		int expectedMonth = scan.nextInt() - 1;
		int expectedYear = scan.nextInt();

		Calendar expected = Calendar.getInstance();
		expected.set(expectedYear, expectedMonth, expectedDay);
		
		//System.out.println(formatter.format(expected.getTime()));
		
		scan.close();
		
		long amount = fine(actual, expected);
		
		System.out.println(amount);
		
	}
	
    static long fine(Calendar actual, Calendar expected) {
    	long amount = 0;
    	
    	// before or equal expected
    	if (actual.before(expected) || actual.equals(expected) ) {
    		amount = 0;
    	}
    	
    	// after but same month, same year
    	else if (actual.get(Calendar.MONTH) == expected.get(Calendar.MONTH)
    			&& (actual.get(Calendar.YEAR) == expected.get(Calendar.YEAR))) {
    		amount = (actual.get(Calendar.DATE) - expected.get(Calendar.DATE)) * 15;
    	}
    	 
    	// after but same year
    	else if (actual.get(Calendar.YEAR) == expected.get(Calendar.YEAR)) {
    		amount = (actual.get(Calendar.MONTH) - expected.get(Calendar.MONTH)) * 500;
    	}
    	
    	// any other case
    	else {
    		amount = 10000;
    	}
    	return amount;
    		
    } 
}