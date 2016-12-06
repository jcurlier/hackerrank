//Write your code here
class Calculator
{
    public int power(int n, int p)
    {
        int result = 1;
        
        if (n < 0 || p < 0)
        {
            throw new Exception("n and p should be non-negative");
        }
        
        for (int i=1; i<=p; i++) result = result * n; 
        
        return result;
    }
    
}