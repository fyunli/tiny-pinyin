package li.fyun.pinyin.format;

import org.apache.commons.lang3.ArrayUtils;

public interface PinyinFormatter {

    String ALL_UNMARKED_VOWEL = "aeiouv";
    String ALL_MARKED_VOWEL = "āáǎàēéěèīíǐìōóǒòūúǔùǖǘǚǜ"; // 所有带声调的拼音字母

    WithToneMarkFormatter WITH_TONE_MARK_FORMATTER = new WithToneMarkFormatter();
    WithoutToneFormatter WITHOUT_TONE_FORMATTER = new WithoutToneFormatter();
    WithToneNumberFormatter WITH_TONE_NUMBER_FORMATTER = new WithToneNumberFormatter();

    String format(String str);

    static PinyinFormatter instanceOf(PinyinFormat... formats) {
        PinyinFormat format = PinyinFormat.WITH_TONE_MARK;
        if (ArrayUtils.isNotEmpty(formats)) {
            format = formats[0];
        }
        if (PinyinFormat.WITHOUT_TONE.equals(format)) {
            return WITHOUT_TONE_FORMATTER;
        } else if (PinyinFormat.WITH_TONE_NUMBER.equals(format)) {
            return WITH_TONE_NUMBER_FORMATTER;
        } else {
            return WITH_TONE_MARK_FORMATTER;
        }
    }

}
