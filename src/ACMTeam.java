import java.util.Scanner;

public class ACMTeam {

	
	public static void main(String[] args) {
		
	    Scanner in = new Scanner(System.in);

	    int numberOfPeople = in.nextInt();
	    int numberOfTopics = in.nextInt();
	    
	    boolean[][] knowledge = new boolean[numberOfPeople][numberOfTopics];
	    in.nextLine();

        for(int i=0; i<numberOfPeople; i++){
            String line = in.nextLine();
            for (int j=0; j<numberOfTopics; j++) {
            	knowledge[i][j] = (line.charAt(j)) == '1';
            }
        }
     
        process(knowledge, numberOfPeople, numberOfTopics);
	}

    private static void process(boolean[][] knowledge, int numberOfPeople, int numberOfTopics) {
    	int maximumTopics = 0;
    	int teamCount = 0;
    	
        for(int i=0; i<numberOfPeople - 1; i++) {
        	for(int j=i+1; j<numberOfPeople; j++) {

        		int numberOfTeamTopics = 0;
        		
        		for(int k=0; k<numberOfTopics; k++) {
        			if (knowledge[i][k] || knowledge[j][k]) {
        				numberOfTeamTopics++;
        			}
        		}
        		
        		if (numberOfTeamTopics > maximumTopics) {
        			maximumTopics = numberOfTeamTopics;
        			teamCount = 1;
        		} else if (numberOfTeamTopics == maximumTopics) {
        			teamCount++;
        		}
        	}
        }
        
        System.out.println(maximumTopics);
        System.out.println(teamCount);
        
    }
}
