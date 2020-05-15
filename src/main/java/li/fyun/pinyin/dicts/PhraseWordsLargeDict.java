package li.fyun.pinyin.dicts;

public class PhraseWordsLargeDict extends AbstractPhraseDict {

    private static volatile PhraseWordsLargeDict singleton = null;

    private PhraseWordsLargeDict() {
        super("dicts/words_large.txt");
    }

    public static PhraseWordsLargeDict getInstance() {
        if (singleton == null) {
            synchronized (PhraseWordsLargeDict.class) {
                if (singleton == null) {
                    singleton = new PhraseWordsLargeDict();
                }
            }
        }
        return singleton;
    }

}
