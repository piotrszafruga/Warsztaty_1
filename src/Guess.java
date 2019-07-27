import java.util.Random;
import java.util.Scanner;

public class Guess {

    public static void main(String[] args) {
        guess();


    }

    static void guess() {
        Random generate = new Random();
        Scanner scan = new Scanner(System.in);

        int rand = generate.nextInt(100) + 1;
        System.out.println(rand);
        System.out.print("Zgadnij liczbę");
        int num = getNum();

        while (true) {

            if (num < rand) {
                System.out.println("Za mało!");
                System.out.print("Zgadnij liczbę");
                num = getNum();
            } else if (num > rand) {
                System.out.println("Za duzo!");
                System.out.print("Zgadnij liczbę");
                num = getNum();
            } else {
                System.out.println("Zgadleś");
                break;
            }
        }
    }

    static int getNum() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.println("To nie jest liczba");
            scanner.next();
        }
        return scanner.nextInt();
    }

}

//    Gra w zgadywanie liczb
//    Napisz prostą grę w zgadywanie liczb. Komputer ma wylosować liczbę w zakresie od 1 do 100.
//        Następnie:
//        1. wypisać: "Zgadnij liczbę" i pobrać liczbę z klawiatury;
//        2. sprawdzić, czy wprowadzony napis, to rzeczywiście liczba i w razie błędu wyświetlić komunikat: "To
//        nie jest liczba", po czym wrócić do pkt. 1;
//        3. jeśli liczba podana przez użytkownika jest mniejsza niż wylosowana, wyświetlić komunikat: "Za
//        mało!", po czym wrócić do pkt. 1;
//        4. jeśli liczba podana przez użytkownika jest większa niż wylosowana, wyświetlić komunikat: "Za
//        dużo!", po czym wrócić do pkt. 1;
//        5. jeśli liczba podana przez użytkownika jest równa wylosowanej, wyświetlić komunikat: "Zgadłeś!",
//        po czym zakończyć działanie programu.
