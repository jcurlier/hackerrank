using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
class Solution {

    static void Main(String[] args) {
        string[] tokens_n = Console.ReadLine().Split(' ');
        int n = Convert.ToInt32(tokens_n[0]); // array size
        int k = Convert.ToInt32(tokens_n[1]); // left rotation
        string[] a_temp = Console.ReadLine().Split(' ');
        int[] a = Array.ConvertAll(a_temp,Int32.Parse); // array
        
        int[] r = new int[n];
        for (int i = 0; i < n; i++)
        {
            int index = (i + k) % n;
            r[i] = a[index];
        }    
        Console.WriteLine(string.Join(" ", r));
    }
}