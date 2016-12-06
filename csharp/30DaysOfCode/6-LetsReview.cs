using System;
using System.Collections.Generic;
using System.IO;

class Solution {

    static void Main(String[] args) 
    {
        int n = 0;
        
        string input = Console.ReadLine();
        int.TryParse(input, out n);
        
        for (int i = 1; i <= n; i++)
        {
            input = Console.ReadLine();
            string output = "";
            
            for (int j = 0; j < input.Length; j = j + 2)
            {
                output = output + input[j];
            }
            output = output + " ";
            for (int j = 1; j < input.Length; j = j + 2)
            {
                output = output + input[j];
            }
            
            Console.WriteLine(output);
        }
    }
}