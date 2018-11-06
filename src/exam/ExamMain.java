package exam;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class ExamMain {
    public static void main(String[] args) {
        changeText("text.txt", "p1.txt", s -> s.toUpperCase());
//        WordTransformer rule2 = s -> String.valueOf(s.length());
//        WordTransformer rule2 = s -> Integer.toString(s.length());
//        WordTransformer rule2 = s -> s.length() + "";
//        WordTransformer rule2 = s -> ((Integer) s.length()).toString();
        changeText("text.txt", "p4.txt", s -> String.valueOf(s.length()));
        DictionaryTransformer dict = new DictionaryTransformer("words_alpha.txt");
        changeText("text.txt", "p5.txt", dict);
        DictionaryBackTransformer dict_back = new DictionaryBackTransformer("words_alpha.txt");
        changeText("p5.txt", "text_back.txt", dict_back);
    }

    public static void changeText(String nameIn, String nameOut, WordTransformer w) {
        File fileIn = new File(nameIn);
        File fileOut = new File(nameOut);
        try (
                Scanner in = new Scanner(fileIn, "UTF-8");
                PrintStream out = new PrintStream(fileOut, "UTF-8")
        ) {
            in.useDelimiter("[^A-Za-z0-9]+");
            while (in.hasNext())
                out.println(w.transform(in.next()));
        } catch (Exception e) {
            System.out.println("Error lol" + e);
        }
    }
}
