using System;
using System.Collections.Generic;
using System.IO;

class Solution {
    
    static void Main(String[] args) {
        int n = Convert.ToInt32(Console.ReadLine());
        MyQueue myQueue = new MyQueue();
        
        for (int i=0; i<n; i++)
        {
            int[] input = Array.ConvertAll(Console.ReadLine().Split(' '), Int32.Parse);
            switch (input[0])
            {
                case 1:
                    myQueue.Enqueue(input[1]);
                    break;
                case 2:
                    myQueue.Dequeue();
                    break;
                case 3:
                    Console.WriteLine(myQueue.Peek());
                    break;
            }
        }
    }
}

class MyQueue 
{
    private Stack<int> inStack = new Stack<int>();
    private Stack<int> outStack = new Stack<int>();
    
    public void Enqueue(int value) 
    {
        inStack.Push(value);
    }
    
    public int Dequeue()
    {
        if (outStack.Count > 0)
        {
            return outStack.Pop();
        }
        
        if (inStack.Count > 0)
        {
            while (inStack.Count > 0)
            {
                outStack.Push(inStack.Pop());
            }
            return outStack.Pop();
        }
        
        throw new InvalidOperationException();
    }
    
    public int Peek()
    {
        if (outStack.Count > 0)
        {
            return outStack.Peek();
        }
        
        if (inStack.Count > 0)
        {
            while (inStack.Count > 0)
            {
                outStack.Push(inStack.Pop());
            }
            return outStack.Peek();
        }
        
        throw new InvalidOperationException();  
    }
    
}