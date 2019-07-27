import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Browser {
    public static void main(String[] args) {
        browser();

    }

    public static void browser() {
        browseWordsToFile();
        createFile("src/filtered_popular_words.txt");
        String[] excludedWords = {"a","i","o","w","z","na","za","ale","lub","pod","albo","oraz","dlatego","ponieważ"};
        filterWordsToFile(excludedWords);
    }

    public static void browseWordsToFile() {
        Connection connect = Jsoup.connect("http://www.onet.pl/");
        try {
            FileWriter fileWriter = new FileWriter("src/popular_words.txt", false);
            Document document = connect.get();
            Elements links = document.select("span.title");

            for (Element elem : links) {
                Pattern pattern = Pattern.compile("[a-ząćęłóśóżź]+", Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(elem.text());

                while (matcher.find()) {
                    String word = matcher.group();
                    if (word.length() >= 3) {
                        fileWriter.append(word + "\n");
                    }
                }
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createFile(String pathStr) {
        Path path = Paths.get(pathStr);
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
            }
        }
    }

    public static void filterWordsToFile(String[] excludedWords) {
        File file = new File("src/popular_words.txt");
        try {
            Scanner scan = new Scanner(file);
            FileWriter fileWriter = new FileWriter("src/filtered_popular_words.txt", false);
            while (scan.hasNextLine()) {
                String word = scan.nextLine().toLowerCase();
                if (!Arrays.asList(excludedWords).contains(word)) {
                    fileWriter.append(word + "\n");
                }
            }
            fileWriter.close();
        } catch (FileNotFoundException e1) {
            System.out.println("Lack of file.");
        } catch (IOException e2) {
            System.out.println("Writing to file error.");
        }
    }
}

//    Wyszukiwarka najpopularniejszych słów
//        Zaimportuj do projektu bibliotekę jsoup, możesz ją pobrać z adresu: https://jsoup.org/download
//        Wyszukaj w popularnych serwisach internetowych nagłówków artykułów, a następnie zapisz
//        pojedyncze słowa w nich występujące do pliku o nazwie popular_words.txt . Przykład pobrania
//        tytułów z tagu html span z atrybutem class o wartości title.
//
//        Wywołaj pobieranie dla wybranych serwisów internetowych.
//        Pomiń wszystkie elementy krótsze niż 3-znakowe.
//        Utwórz tablicę elementów wykluczonych np. oraz, ponieważ
//        Wczytaj utworzony plik popular_words.txt i na jego podstawie utwórz plik
//        filtered_popular_words.txt , który zawierać będzie wszystkie znalezione słowa,
//        pomijając słowa wykluczone.