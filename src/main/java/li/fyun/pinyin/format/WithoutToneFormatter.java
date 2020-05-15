package li.fyun.pinyin.format;

import org.apache.commons.lang3.StringUtils;

public class WithoutToneFormatter implements PinyinFormatter {

    public String format(String pinyinArrayString) {
        pinyinArrayString = StringUtils.lowerCase(pinyinArrayString);
        for (int i = ALL_MARKED_VOWEL.length() - 1; i >= 0; i--) {
            char originalChar = ALL_MARKED_VOWEL.charAt(i);
            char replaceChar = ALL_UNMARKED_VOWEL.charAt((i - i % 4) / 4);
            pinyinArrayString = pinyinArrayString.replace(String.valueOf(originalChar), String.valueOf(replaceChar));
        }
        // 将拼音中的ü替换为v
        return StringUtils.replace(pinyinArrayString, "ü", "v");
    }

}
