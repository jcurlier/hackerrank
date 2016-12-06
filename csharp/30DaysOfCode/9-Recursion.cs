using System;
using System.Collections.Generic;
using System.IO;
class Solution {
    
    static void Main(String[] args) 
    {
        string input = Console.ReadLine();
        int n = 0;
        int.TryParse(input, out n);
        
        int result = Factorial(n);
        Console.WriteLine(result.ToString());
    }
    
    static int Factorial(int n)
    {
        if (n == 0 || n == 1) 
        {
            return 1;    
        }
        else
        {
            return n * Factorial(n - 1);        
        }
    }
}