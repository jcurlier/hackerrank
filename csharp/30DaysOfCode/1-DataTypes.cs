        // Declare second integer, double, and String variables.
        int j = 0;
        double e = 0.0;
        string t = null;

        // Read and save an integer, double, and String to your variables.
        string input = Console.ReadLine();
        Int32.TryParse(input, out j);

        input = Console.ReadLine();
        Double.TryParse(input, out e);

        t = Console.ReadLine();

        // Print the sum of both integer variables on a new line.
        int sumInt = i + j;
        Console.WriteLine($"{sumInt}");

        // Print the sum of the double variables on a new line.
        double sumDouble = d + e;
        Console.WriteLine($"{sumDouble:F1}");

        // Concatenate and print the String variables on a new line
        // The 's' variable above should be printed first.
        string concatenated = s + t;
        Console.WriteLine($"{concatenated}");