using System;
using System.Collections.Generic;
using System.IO;

class Solution {
    static void Main(String[] args) {
        int i = 4;
        double d = 4.0;
        string s = "HackerRank ";
        
        // Declare second integer, double, and String variables.
        int j = 0;
        double e = 0.0;
        string t = null;

        // Read and save an integer, double, and String to your variables.
        j = Convert.ToInt32(Console.ReadLine());
        e = Convert.ToDouble(Console.ReadLine());
        t = Console.ReadLine();

        // Print the sum of both integer variables on a new line.
        Console.WriteLine($"{i + j}");

        // Print the sum of the double variables on a new line.
        Console.WriteLine($"{(d + e):F1}");

        // Concatenate and print the String variables on a new line
        // The 's' variable above should be printed first.
        Console.WriteLine($"{(s + t)}");
    }
}
