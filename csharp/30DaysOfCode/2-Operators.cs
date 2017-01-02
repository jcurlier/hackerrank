using System;

class Solution 
{
    static void Main(String[] args)
    {
        string input = null;
        double mealCost = 0.00;
        int tipPercent = 0;
        int taxPercent = 0;
        
        input = Console.ReadLine();
        Double.TryParse(input, out mealCost);
        
        input = Console.ReadLine();
        Int32.TryParse(input, out tipPercent);
        
        input = Console.ReadLine();
        Int32.TryParse(input, out taxPercent);
        
        double tip = (mealCost * tipPercent) / 100;
        double tax = (mealCost * taxPercent) / 100;

        int totalCost = (int) Math.Round(mealCost + tip + tax, 0);
        Console.WriteLine($"The total meal cost is {totalCost} dollars.");
    }
}
