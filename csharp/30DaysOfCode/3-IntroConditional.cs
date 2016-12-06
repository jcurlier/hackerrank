using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
class Solution {

    static void Main(String[] args) {
        
        int N = Convert.ToInt32(Console.ReadLine());
        bool isWeird = false;
        
        if (N % 2 != 0) 
        {
            isWeird = true;   
        }
        else if (N >= 6 && N <= 20) 
        {
            isWeird = true;    
        }
        
        Console.WriteLine((isWeird)?"Weird":"Not Weird");
    }
}