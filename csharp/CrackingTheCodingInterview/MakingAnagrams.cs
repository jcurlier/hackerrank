using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
class Solution {

    static void Main(String[] args) {
        string a = Console.ReadLine();
        string b = Console.ReadLine();
        
        int[] count = new int[26];
        int total = 0;
        a.ToList().ForEach(c => { count[(int) c - (int) 'a']++; });
        b.ToList().ForEach(c => { count[(int) c - (int) 'a']--; });
        count.ToList().ForEach(i => { total += Math.Abs(i); });

        Console.WriteLine(total.ToString());
    }
    
}


==========================


using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
class Solution {

    static void Main(String[] args) {
        string a = Console.ReadLine();
        string b = Console.ReadLine();
        
        int[] counta = Count(a);
        int[] countb = Count(b);
        int total = 0;
        
        for (int i = 0; i < 26; i++)
        {
            int difference = Math.Abs(counta[i] - countb[i]);
            total += difference;
        }
        
        Console.WriteLine(total.ToString());
    }
    
    static int[] Count(string input)
    {
        int[] result = new int[26];
        
        for (int i = 0; i < input.Length; i++)
        {
            char c = input[i];
            int n = (int) c - (int) 'a';
            result[n]++;
        }
        
        return result;
    }
}