	// Add your code here
    public Difference(int[] elements)
    {
        this.elements = elements;
    }

    public void computeDifference()
    {
        int min = elements.Min();
        int max = elements.Max();
        
        this.maximumDifference = max - min;
    }