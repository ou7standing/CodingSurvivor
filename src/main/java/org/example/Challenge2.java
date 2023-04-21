package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Challenge2 {
    public static void main(String[] args) {
        ArrayList<Integer> ballsInBox = new ArrayList<> ();

        Scanner scanner = new Scanner (System.in);
        System.out.println ("Enter ball count in the format 'Color: count' (or 'End' to finish): ");
        while (true) {
            String input = scanner.nextLine ();
            if (input.equalsIgnoreCase ("End")) {
                break;
            }

            String[] parts = input.split (": ");
            int count = Integer.parseInt (parts[1]);

            ballsInBox.add (count);

        }

        if (ballsInBox.size () == 0) {
            System.out.println ("No balls");
            return;
        }

        int smallestCount = ballsInBox.stream ()
                .sorted (Comparator.reverseOrder ())
                .mapToInt (Integer::intValue)
                .skip (1)
                .sum ();

        System.out.println (smallestCount);
        System.out.println ("The smallest count of balls, that need to be taken out to ensure only one color is left is " + smallestCount);

    }
}