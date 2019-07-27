import java.util.Arrays;
import java.util.Scanner;

public class Guess2 {

    public static void main(String[] args) {
        guess2();


    }

    static void guess2() {
        int min = 0;
        int max = 1000;
        Scanner scan = new Scanner(System.in);

        System.out.print("Podaj liczbę od 1 do 1000: ");
        int num = getNum();

        while (true) {
            int guess = (min + max)/2;

            System.out.println("Zgaduję " + guess);
            System.out.print("Podaj odpowiedź (za dużo, za mało, zgadłeś: ");
            String answer = scan.nextLine();
            if (answer.toLowerCase().equals("za dużo")) {
                max = guess;
            } else if (answer.toLowerCase().equals("za mało")) {
                min = guess;
            } else if (answer.toLowerCase().equals("zgadłeś")) {
                System.out.println("Wygrałem!");
                break;
            } else {
                System.out.println("Nie oszukuj");
            }
        }
    }

    static int getNum() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println("To nie jest liczba. Wprowadz liczbę:");
                scanner.next();
            }
            Integer num = scanner.nextInt();
            if (num < 1 || num > 1000) {
                System.out.println("Liczba spoza zakresu 1-1000. Wprowadz inna liczbę:");
            } else {
                return num;
            }
        }
    }

}

//    Gra w zgadywanie liczb 2
//        Odwróćmy teraz sytuację z warsztatu "Gra w zgadywanie liczb": to użytkownik pomyśli sobie liczbę z
//        zakresu 1-1000, a komputer będzie zgadywał i zrobi to maksymalnie w 10 ruchach (pod warunkiem,
//        że gracz nie będzie oszukiwał).
//        Zadaniem gracza będzie udzielanie odpowiedzi "więcej", "mniej", "trafiłeś".
