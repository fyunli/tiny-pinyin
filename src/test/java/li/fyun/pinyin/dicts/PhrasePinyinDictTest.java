package li.fyun.pinyin.dicts;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class PhrasePinyinDictTest {

    @Test
    public void testWordsNormalDict() {
        Map<String, String[]> dicts = PhraseWordsNormalDict.getInstance().mapping();
        Assert.assertTrue(dicts.keySet().contains("一个萝卜一个坑"));
        Assert.assertTrue(dicts.size() > 42900);
        Assert.assertTrue(dicts.size() < 43900);
    }

    @Test
    public void testWordsLargeDict() {
        Map<String, String[]> dicts = PhraseWordsLargeDict.getInstance().mapping();
        Assert.assertTrue(dicts.keySet().contains("郎格罕氏岛"));
        Assert.assertTrue(dicts.size() > 398000);
        Assert.assertTrue(dicts.size() < 399000);
    }

    @Test
    public void testPinyinDict() {
        Map<String, String[]> dicts = PhrasePinyinDict.getInstance().mapping();
        Assert.assertTrue(dicts.size() > 41000);
        Assert.assertTrue(dicts.size() < 42000);
    }

}