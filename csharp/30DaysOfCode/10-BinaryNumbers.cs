using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
class Solution {

    static void Main(String[] args) {
        int n = Convert.ToInt32(Console.ReadLine());

        int maxConsecutiveOne = GetMaxConsecutiveOne(n);
        Console.WriteLine(maxConsecutiveOne.ToString());
    }
    
    static int GetMaxConsecutiveOne(int n)
    {
        if (n == 0) return 0;
        
        int remainder = 0;
        int nbrConsecutiveOne = 0;
        int maxConsecutiveOne = 0;
        //string result = "";
            
        while (n > 0)
        {
            remainder = n % 2;
            n = n / 2;
            
            if (remainder == 1)
            {
                nbrConsecutiveOne++;    
            }
            else
            {
                nbrConsecutiveOne = 0;
            }
            
            if (maxConsecutiveOne < nbrConsecutiveOne) maxConsecutiveOne = nbrConsecutiveOne;
            
            //result = remainder.ToString() + result;
            //Console.WriteLine(result + ":" + maxConsecutiveOne.ToString());
        }
        
        return maxConsecutiveOne;
    }
}