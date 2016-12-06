import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TimeConversion {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		scan.close();
		
		String output = convert(input);
		
		System.out.println(output);
		
	}
	
    static String convert(String input) {
    	SimpleDateFormat inputParser = new SimpleDateFormat("hh:mm:ssa");
    	SimpleDateFormat outputParser = new SimpleDateFormat("HH:mm:ss");
    	
    	String output = null;
    	
    	Date time;
		try {
			
			time = inputParser.parse(input);    	
			output = outputParser.format(time);
		
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return output;
    }

}