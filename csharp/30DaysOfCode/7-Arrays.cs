using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
class Solution {

    static void Main(String[] args) 
    {
        int n = Convert.ToInt32(Console.ReadLine());
        string[] arr_temp = Console.ReadLine().Split(' ');
        int[] arr = Array.ConvertAll(arr_temp,Int32.Parse);
        
        string result = arr[n - 1].ToString();
        for (int i = n - 2; i >= 0; i--)
        {
            result = result + " " + arr[i].ToString();
        }
        
        Console.WriteLine(result);
    }
}