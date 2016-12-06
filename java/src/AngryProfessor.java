import java.util.Scanner;
	
public class AngryProfessor {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int t = in.nextInt();
        TestCase[] testCases = new TestCase[t];
        
        for (int i=0; i<t; i++) {
        	testCases[i] = new TestCase();
        	
        	int numberOfStudents = in.nextInt();
        	testCases[i].setNumberOfStudents(numberOfStudents);
        	
        	int minimumNumberOfStudents = in.nextInt();
        	testCases[i].setMimimumNumberOfStudents(minimumNumberOfStudents);
        	
        	int[] studentArrivalTimes = testCases[i].getStudentArrivalTimes();
        	for (int j=0; j<numberOfStudents; j++) {
        		studentArrivalTimes[j] = in.nextInt();
        	}
        }
        
        processData(testCases);
        
        in.close();
    }
	
    static void processData(TestCase[] testCases) {
    	int size = testCases.length;
    	
    	for (int i=0; i<size; i++) { 
    		TestCase testCase = testCases[i];
    		
    		int numberOfStudents = testCase.getNumberOfStudents();
    		int numberOfStudentsNotLate = 0;
    		int[] studentArrivalTimes = testCase.getStudentArrivalTimes();
    		
        	for (int j=0; j<numberOfStudents; j++) {
        		if (studentArrivalTimes[j] <= 0) {
        			numberOfStudentsNotLate++;
        		}
        	}
        	
        	if (numberOfStudentsNotLate < testCase.getMimimumNumberOfStudents()) {
        		System.out.println("YES");
        	} else {
        		System.out.println("NO");
        	}
    	}
    }
    
    static private class TestCase {
    	private int numberOfStudents = 0;
    	private int mimimumNumberOfStudents = 0;
    	private int[] studentArrivalTimes;

		public int getNumberOfStudents() {
			return numberOfStudents;
		}
		
		public void setNumberOfStudents(int numberOfStudents) {
			this.numberOfStudents = numberOfStudents;
			studentArrivalTimes = new int[numberOfStudents];
		}
		
		public int getMimimumNumberOfStudents() {
			return mimimumNumberOfStudents;
		}
		
		public void setMimimumNumberOfStudents(int mimimumNumberOfStudents) {
			this.mimimumNumberOfStudents = mimimumNumberOfStudents;
		}
		
		public int[] getStudentArrivalTimes() {
			return studentArrivalTimes;
		}
		
    }
}