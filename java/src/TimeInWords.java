import java.util.Scanner;

public class TimeInWords {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int hours = in.nextInt();
        int minutes = in.nextInt();
        
        System.out.println(translate(hours, minutes));
        
        in.close();
    }
    
    static String translate(int hours, int minutes) {

    	String translation = null;
    	
    	if (minutes == 0) {
    		translation = translateNumber(hours) + " o' clock";
    	} else if (minutes == 1) {
    		translation = "one minute past " + translateNumber(hours);
    	} else if (minutes == 15) {
    		translation = "quarter past " + translateNumber(hours);
    	} else if (minutes > 1 && minutes < 30) {
    		translation = translateNumber(minutes) + " minutes past " + translateNumber(hours);
    	} else if (minutes == 30) {
    		translation = "half past " + translateNumber(hours);
    	} else if (minutes == 45) {
    		translation = "quarter to " + translateNumber((hours + 1));
    	} else if (minutes >= 31 && minutes <= 59) {
    		translation = translateNumber((60 - minutes)) + " minutes to " + translateNumber((hours + 1));
    	}
    	
    	return translation;
    }
    
    static String translateNumber(int number) {
    	String result = "";

    	switch (number) {
    		case 1:  result = "one"; break;
    		case 2:  result = "two"; break;
    		case 3:  result = "three"; break;
    		case 4:  result = "four"; break;
    		case 5:  result = "five"; break;
    		case 6:  result = "six"; break;
    		case 7:  result = "seven"; break;
    		case 8:  result = "eight"; break;
    		case 9:  result = "nine"; break;
    		case 10:  result = "ten"; break;
    		case 11:  result = "eleven"; break;
    		case 12:  result = "twelve"; break;
    		case 13:  result = "thirteen"; break;
    		case 14:  result = "fourteen"; break;
    		case 15:  result = "fifteen"; break;
    		case 16:  result = "sixteen"; break;
    		case 17:  result = "seventeen"; break;
    		case 18:  result = "eighteen"; break;
    		case 19:  result = "nineteen"; break;
    		case 20:  result = "twenty"; break;
    		case 21:  result = "twenty one"; break;
    		case 22:  result = "twenty two"; break;
    		case 23:  result = "twenty three"; break;
    		case 24:  result = "twenty four"; break;
    		case 25:  result = "twenty five"; break;
    		case 26:  result = "twenty six"; break;
    		case 27:  result = "twenty seven"; break;
    		case 28:  result = "twenty eight"; break;
    		case 29:  result = "twenty nine"; break;
    	}
    	
    	return result;
    }
}
