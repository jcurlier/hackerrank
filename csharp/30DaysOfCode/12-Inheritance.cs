class Student : Person
{
    private int[] testScores;  
  
	public Student(string firstName, string lastName, int identification, int[] scores) : 
                base(firstName, lastName, identification) 
    {
        this.testScores = scores;
	}   
    
    public char calculate() 
    {
        int sum = 0;
        for (int i=0; i<testScores.Length; i++)
        {
            sum = sum + testScores[i]; 
        }
        double average = sum / testScores.Length;
        
        if (average >= 90) return 'O';
        if (average >= 80 && average <90) return 'E';
        if (average >= 70 && average <80) return 'A';
        if (average >= 55 && average <70) return 'P';
        if (average >= 40 && average <55) return 'D';
        
        return 'T';
    }
}