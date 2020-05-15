package li.fyun.pinyin.dicts;

import com.github.promeg.pinyinhelper.PinyinMapDict;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractPhraseDict extends PinyinMapDict {

    protected static final String KEY_VALUE_SEPARATOR = ": ";
    protected static final String VALUE_ARRAY_SEPARATOR = " ";
    protected final Map<String, String[]> mDict;

    protected String dictFile;

    protected AbstractPhraseDict(String dictFile) {
        this.dictFile = dictFile;
        mDict = new HashMap<>();
        init();
    }

    @Override
    public Map<String, String[]> mapping() {
        return mDict;
    }

    protected void init() {
        try (BufferedReader reader = getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("#")) {
                    continue;
                }
                // process the line.
                String[] keyAndValue = line.split(KEY_VALUE_SEPARATOR);
                if (keyAndValue != null && keyAndValue.length > 1) {
                    String key = keyAndValue[0];
                    String value = keyAndValue[1];
                    String[] pinyinValues = value.split(VALUE_ARRAY_SEPARATOR);
                    mDict.put(key, pinyinValues);
                }
            }
        } catch (IOException e) {
            //
        }
    }

    protected BufferedReader getReader() throws UnsupportedEncodingException {
        return new BufferedReader(new InputStreamReader(
                Thread.currentThread().getContextClassLoader().getResourceAsStream(dictFile), "utf-8"
        ));
    }

}
