package li.fyun.pinyin.format;

import org.apache.commons.lang3.StringUtils;

public class WithToneMarkFormatter implements PinyinFormatter {

    public String format(String pinyinArrayString) {
        return StringUtils.lowerCase(pinyinArrayString);
    }

}
