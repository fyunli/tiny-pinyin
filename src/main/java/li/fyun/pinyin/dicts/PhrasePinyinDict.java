package li.fyun.pinyin.dicts;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;

public class PhrasePinyinDict extends AbstractPhraseDict {

    private static volatile PhrasePinyinDict singleton = null;

    private PhrasePinyinDict() {
        super("dicts/pinyin.txt");
    }

    public static PhrasePinyinDict getInstance() {
        if (singleton == null) {
            synchronized (PhrasePinyinDict.class) {
                if (singleton == null) {
                    singleton = new PhrasePinyinDict();
                }
            }
        }
        return singleton;
    }

    @Override
    protected void init() {
        try (BufferedReader reader = getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("#")) {
                    continue;
                }
                // process the line.
                String[] keyAndValue = StringUtils.split(line, ":# ");
                if (keyAndValue != null && keyAndValue.length > 2) {
                    String key = keyAndValue[keyAndValue.length - 1];
                    String value = keyAndValue[keyAndValue.length - 2];
                    String[] pinyinValues = value.split(",");
                    mDict.put(key, new String[]{pinyinValues[0]});
                }
            }
        } catch (IOException e) {
            //
        }
    }
}
