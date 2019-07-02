import java.lang.reflect.Array;
import java.util.*;

public class loot {

    public static void main(String[] args) {
        lotto();

    }

    static void lotto() {
        int[] choosenNumbers = new int[6];
        int count = 0;

        for (int i = 0; i < 6; i++) {
            System.out.print("Wprowadz liczbe: ");
            choosenNumbers[i] = getNum(choosenNumbers);
        }
        Arrays.sort(choosenNumbers);
        System.out.println(Arrays.toString(choosenNumbers));

        Set drawnSet = getRandoms(6);
        System.out.println(drawnSet);

        for (int num: choosenNumbers) {
            if (drawnSet.contains(num)) {
                count++;
            }
        }
        System.out.println("Gracz trafił " + count + " razy.");
    }

    static int getNum(int[] arr) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.print("To nie jest liczba. Wprowadz liczbę: ");
                scanner.next();
            }
            int num = scanner.nextInt();
            if (Arrays.stream(arr).anyMatch(x->x == num)) {
                System.out.print("Ta liczba juz zostala wprowadzona. Wprowadz inna liczbę: ");
            } else if (num < 1 || num > 49) {
                System.out.print("Liczba spoza zakresu 1-49. Wprowadz inna liczbę: ");
            } else {
                return num;
            }
        }
    }

    static Set getRandoms(int numberOfDraws) {
        Random generate = new Random();
        Set set = new HashSet();
        int count = 0;
        while (count < numberOfDraws) {
            set.add(generate.nextInt(49) + 1);
            count++;
        }
        return set;
    }

}

//    Symulator LOTTO
//    Jak wszystkim wiadomo, LOTTO to gra liczbowa polegająca na losowaniu 6 liczb z zakresu od 1 do 49.
//        Zadaniem gracza jest poprawne wytypowanie losowanych liczb. Nagradzane jest tra enie 3, 4, 5 lub 6
//        poprawnych liczb.
//        Napisz program, który:
//        zapyta o typowane liczby, przy okazji sprawdzi następujące warunki:
//        czy wprowadzony ciąg znaków jest poprawną liczbą,
//        czy użytkownik nie wpisał tej liczby już poprzednio,
//        czy liczba należy do zakresu 1-49,
//        po wprowadzeniu 6 liczb, posortuje je rosnąco i wyświetli na ekranie,
//        wylosuje 6 liczb z zakresu i wyświetli je na ekranie,
//        poinformuje gracza, czy tra ł przynajmniej "trójkę".
