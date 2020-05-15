package li.fyun.pinyin;

import com.github.promeg.pinyinhelper.Pinyin;
import com.github.promeg.pinyinhelper.PinyinDict;
import li.fyun.pinyin.format.*;
import org.apache.commons.lang3.StringUtils;

public class TinyPinyin {

    public static void addDict(PinyinDict dict) {
        Pinyin.add(dict);
    }

    public static String toPinyin(String str, PinyinFormat... format) {
        return toPinyin(str, "", format);
    }

    public static String toPinyin(String str, String separator, PinyinFormat... format) {
        PinyinFormatter formatter = PinyinFormatter.instanceOf(format);
        return formatter.format(Pinyin.toPinyin(str, separator));
    }

    public static String toFirstLetters(String str) {
        return getFirstLetters(toPinyin(str, " ", PinyinFormat.WITHOUT_TONE));
    }

    private static String getFirstLetters(String text) {
        String firstLetters = "";
        text = text.replaceAll("[.,]", ""); // Replace dots, etc (optional)
        for (String s : text.split(" ")) {
            firstLetters += s.charAt(0);
        }
        return StringUtils.upperCase(firstLetters);
    }

}
