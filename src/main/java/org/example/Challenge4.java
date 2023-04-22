package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Challenge4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.print ("Enter the first word: ");
        String firstWord = scanner.nextLine ().replaceAll ("\\s+", ""); // Read and remove white spaces from the first word
        System.out.print ("Enter the second word: ");
        String secondWord = scanner.nextLine ().replaceAll ("\\s+", ""); // Read and remove white spaces from the second word

        char[] firstWordCharArr = firstWord.toCharArray ();
        char[] secondWordCharArr = secondWord.toCharArray ();

        Map<Character, Integer> map1 = convertToMap (firstWordCharArr);
        Map<Character, Integer> map2 = convertToMap (secondWordCharArr);

        int result = 0;

        for (Map.Entry<Character, Integer> entry : map1.entrySet ()) {
            if (map2.containsKey (entry.getKey ())) {
                int addToSum = Math.abs (entry.getValue () - map2.get (entry.getKey ()));
                result = result + addToSum;
                map2.remove (entry.getKey ());
                continue;
            }
            result = result + entry.getValue ();
        }

        int sum = map2.values ()
                .stream ()
                .mapToInt (Integer::intValue)
                .sum ();

        result = result + sum;

        System.out.println (result);
    }

    public static Map convertToMap(char[] charArray) {
        Map<Character, Integer> map = new HashMap<> ();

        for (char a : charArray) {
            if (map.containsKey (a)) {
                int temp = map.get (a);
                map.put (a, (temp + 1));
                continue;
            }
            map.put (a, 1);
        }
        return map;
    }
}