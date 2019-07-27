import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dice {
    public static void main(String[] args) {

    }

    static double dice(String str) {
        String[] arr = new String[5];
        int i = 0;

        Pattern pattern = Pattern.compile("^\\d+|(?<=D)\\d+|\\+|\\-|\\*|\\/|\\d+$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            arr[i] = matcher.group();
            i++;
        }

        double numOfThrows = Double.parseDouble(arr[0]);
        double diceSize = Double.parseDouble(arr[1]);
        int throwResult = (int)(Math.random() * diceSize + 1);
        double modificator = Double.parseDouble(arr[3]);

        if (arr[2].equals("+")) {
            return numOfThrows * throwResult + modificator;
        } else if (arr[2].equals("-")) {
            return numOfThrows * throwResult - modificator;
        } else if (arr[2].equals("*")) {
            return numOfThrows * throwResult * modificator;
        } else {
            return numOfThrows * throwResult / modificator;
        }
    }
}

//Kostka do gry
//        Napisz funkcję, która:
//        1. przyjmie w parametrze taki kod w postaci String,
//        2. rozpozna wszystkie dane wejściowe:
//        rodzaj kostki,
//        liczbę rzutów,
//        mody kator,
//        3. wykona symulację rzutów i zwróci wynik.
