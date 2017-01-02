using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

static class Solution 
{
    static void Main(String[] args) 
    {
       int N = Convert.ToInt32(Console.ReadLine());
       Console.WriteLine((N.IsWeird())?"Weird":"Not Weird");
    }

    static bool IsWeird(this int n)
    {
        bool isWeird = false;
        
        if (IsOdd(n)) 
        {
            isWeird = true;   
        }
        else if (n >= 6 && n <= 20) 
        {
            isWeird = true;    
        }
        
        return isWeird;
    }
    
    static bool IsOdd(this int n)
    {
        return (n % 2 != 0);
    }
}
