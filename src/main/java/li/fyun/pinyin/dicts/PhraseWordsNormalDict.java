package li.fyun.pinyin.dicts;

public class PhraseWordsNormalDict extends AbstractPhraseDict {

    private static volatile PhraseWordsNormalDict singleton = null;

    private PhraseWordsNormalDict() {
        super("dicts/words_normal.txt");
    }

    public static PhraseWordsNormalDict getInstance() {
        if (singleton == null) {
            synchronized (PhraseWordsNormalDict.class) {
                if (singleton == null) {
                    singleton = new PhraseWordsNormalDict();
                }
            }
        }
        return singleton;
    }

}
