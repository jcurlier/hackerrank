using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
class Solution {

    static void Main(String[] args) {
        Console.ReadLine();

        Dictionary<string,int> magazine = new Dictionary<string,int>();
        Console.ReadLine().Split(' ').ToList()
            .ForEach(word => {
                                if (magazine.ContainsKey(word))
                                {
                                    magazine[word]++;
                                }
                                else
                                {
                                    magazine.Add(word, 1);
                                }
                             });

        bool found = true;
 
        string[] ransom = Console.ReadLine().Split(' ');
        foreach (string word in ransom)
        {
            if (magazine.ContainsKey(word)) 
            {
                magazine[word]--;
                if (magazine[word] == 0) magazine.Remove(word);
            }
            else
            {
                found = false;      
                break;
            }
        }
        Console.WriteLine(found?"Yes":"No");
    }
}