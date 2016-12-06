using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
class Solution {

    static void Main(String[] args) {
        string S = Console.ReadLine();
        
        try 
        {
          int value = Int32.Parse(S);
          Console.WriteLine(value.ToString());
        }
        catch (Exception)
        {
          Console.WriteLine("Bad String");
        }
    }
}