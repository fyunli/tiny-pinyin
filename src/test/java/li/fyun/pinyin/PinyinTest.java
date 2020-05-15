package li.fyun.pinyin;

import li.fyun.pinyin.dicts.PhrasePinyinDict;
import li.fyun.pinyin.dicts.PhraseWordsNormalDict;
import li.fyun.pinyin.format.PinyinFormat;
import org.junit.Assert;
import org.junit.Test;

public class PinyinTest {

    @Test
    public void testToPinyin() {
        String str = "解数";
        TinyPinyin.addDict(PhrasePinyinDict.getInstance());
        TinyPinyin.addDict(PhraseWordsNormalDict.getInstance());
        Assert.assertEquals("xièshù", TinyPinyin.toPinyin(str));
        Assert.assertEquals("xieshu", TinyPinyin.toPinyin(str, PinyinFormat.WITHOUT_TONE));
        Assert.assertEquals("xie4, shu4", TinyPinyin.toPinyin(str," ", PinyinFormat.WITH_TONE_NUMBER));
    }

    @Test
    public void testToFirstLetters() {
        String str = "你好世界，我爱你！";
        TinyPinyin.addDict(PhrasePinyinDict.getInstance());
        TinyPinyin.addDict(PhraseWordsNormalDict.getInstance());
        System.out.println(TinyPinyin.toFirstLetters(str));
    }

}