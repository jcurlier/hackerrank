using System;
using System.Collections.Generic;
using System.IO;
class Solution 
{
    static void Main(String[] args) 
    {
        int T = Int32.Parse(Console.ReadLine());
        while (T-->0)
        {
            int n = Int32.Parse(Console.ReadLine());
            bool isPrime = true;
            
            if (n == 1)
            {
                isPrime = false;        
            }
            else
            {
                for (int i=2; i*i<=n; i++)
                {
                    if (n % i == 0)
                    {
                        isPrime = false;
                        break;
                    }
                }
            }
            
            Console.WriteLine(isPrime ? "Prime" : "Not prime");
        }
    }
}