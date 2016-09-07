package com.keyword.rule;

import com.keyword.pinyin.PinyinGenerator;
import com.keyword.pinyin.PinyinInitialsHandler;

import java.util.HashSet;
import java.util.Set;

/**
 * 获取汉字的拼音的首字母, 同时包含拼音规则
 *
 * @author 谢俊权
 * @create 2016/2/25 10:46
 */
public class InitialsRule implements KeywordRule{

    public Set<String> getKeywords(String word) {
        PinyinGenerator generator = PinyinGenerator.getInstance();
        String pinyin = generator.getPinyin(new PinyinInitialsHandler(), word);
        Set<String> keywordSet = new HashSet<String>();
        keywordSet.add(pinyin);
        return keywordSet;
    }
}
