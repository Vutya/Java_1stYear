package exam;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class WordsTransformerWithList implements WordTransformer{
    protected List<String> words;

    public WordsTransformerWithList(String fileName) {
        File fileIn = new File(fileName);
        words = new ArrayList<>();
        try (Scanner in = new Scanner(fileIn)) {
            while (in.hasNextLine())
                this.words.add(in.nextLine());
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }
}
