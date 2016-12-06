using System;
using System.Collections.Generic;
using System.IO;
class Solution 
{
    static void Main(String[] args) 
    {
        int fine = 0;
        
        int[] arrActual = Array.ConvertAll(Console.ReadLine().Split(' '), Int32.Parse);
        int[] arrExpected = Array.ConvertAll(Console.ReadLine().Split(' '), Int32.Parse);
        
        DateTime actual = new DateTime(arrActual[2], arrActual[1], arrActual[0]);
        DateTime expected = new DateTime(arrExpected[2], arrExpected[1], arrExpected[0]);
        
        if (actual.Year > expected.Year)
        {
            fine  = 10000;
        }
        else if (actual.Year == expected.Year && actual.Month > expected.Month)
        {
            fine = 500 * (actual.Month - expected.Month);
        }
        else if (actual.Year == expected.Year && actual.Month == expected.Month && actual.Day > expected.Day)
        {
            fine = 15 * (actual.Day - expected.Day);
        }
        
        Console.WriteLine(fine);
    }
}