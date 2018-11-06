package exam;

public class DictionaryTransformer extends WordsTransformerWithList {

    public DictionaryTransformer(String fileName) {
        super(fileName);
    }

    @Override
    public String transform(String s) {
        s = s.toLowerCase();
        int ind = words.indexOf(s);
        return ind != -1 ? words.get(ind) : "xxx" + s;
    }

}
