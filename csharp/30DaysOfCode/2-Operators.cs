using System;

class Solution 
{
    static void Main(String[] args)
    {
        double mealCost = 0.00;
        int tipPercent = 0;
        int taxPercent = 0;
        
        mealCost = Convert.ToDouble(Console.ReadLine());
        tipPercent = Convert.ToInt32(Console.ReadLine());
        taxPercent = Convert.ToInt32(Console.ReadLine());
        
        double tip = (mealCost * tipPercent) / 100;
        double tax = (mealCost * taxPercent) / 100;

        int totalCost = (int) Math.Round(mealCost + tip + tax, 0);
        Console.WriteLine($"The total meal cost is {totalCost} dollars.");
    }   
}
