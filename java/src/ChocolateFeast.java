import java.util.Scanner;

public class ChocolateFeast {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            System.out.println(Solve(in.nextInt(), in.nextInt(), in.nextInt()));
        }
        in.close();
    }
    
    private static int Solve(int N, int C, int M){
        int number = 0;
        
        // how many does he buy?
        number = (int) Math.floor(N / C);
        
        // exchanging wrappers
        int numberOfWrappers = number;
        int newChocolates = (int) Math.floor(numberOfWrappers / M);
        
        while (newChocolates > 0) {
        	number = number + newChocolates;
        	numberOfWrappers = numberOfWrappers + newChocolates - (newChocolates * M);
        	newChocolates = (int) Math.floor(numberOfWrappers / M);
        }
        
        return number;
    }
    
    
}
