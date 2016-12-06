using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

static class Solution {

    static void Main(String[] args) 
    {
        int t = Convert.ToInt32(Console.ReadLine());
        for(int a0 = 0; a0 < t; a0++)
        {
            string expression = Console.ReadLine();
            Console.WriteLine(expression.IsBalanced());
        }
    }
     
    static String IsBalanced(this String str)
    {
        Stack<char> stack = new Stack<char>(); 

        foreach (char c in str)    
        {
            if (c == '{' || c == '(' || c == '[') 
            {
                stack.Push(c);
            }
            else
            {
                if (stack.Count == 0) return "NO";
                
                char s = stack.Pop();
                if (    (c == '}' && s != '{') || 
                        (c == ')' && s != '(') || 
                        (c == ']' && s != '['))
                    return "NO";
            }
        }
        
        return (stack.Count == 0)?"YES":"NO";
    }
}