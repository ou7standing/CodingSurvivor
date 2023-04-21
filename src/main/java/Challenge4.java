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

        Map<Character, Integer> map1 = new HashMap<> ();

        for (char a : firstWordCharArr) {
            if (map1.containsKey (a)) {
                map1.put (a, (map1.get (a) + 1));
                continue;
            }
            map1.put (a, 1);
        }

        Map<Character, Integer> map2 = new HashMap<> ();
        for (char a : secondWordCharArr) {
            if (map2.containsKey (a)) {
                int temp = map2.get (a);
                map2.put (a, (temp + 1));
                continue;
            }
            map2.put (a, 1);
        }

        int result = 0;

        System.out.println (result);

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
}