package exam;

public class DictionaryBackTransformer extends WordsTransformerWithList {

    public DictionaryBackTransformer(String fileName) {
        super(fileName);
    }

    @Override
    public String transform(String s) {
        s = s.toLowerCase();
        return s.startsWith("xxx") ? s.substring(3) : (s.matches("\\d{1,8}") ? words.get(Integer.parseInt(s)) : s);
    }

}