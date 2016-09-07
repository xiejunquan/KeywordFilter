package com.keyword.rule;

import com.keyword.pinyin.PinyinGenerator;
import com.keyword.pinyin.PinyinHandler;

import java.util.HashSet;
import java.util.Set;

/**
 * 中文和拼音混合规则
 *
 * @author 谢俊权
 * @create 2016/9/7 10:36
 */
public class MixRule implements KeywordRule{

    public Set<String> getKeywords(String word) {
        PinyinGenerator generator = PinyinGenerator.getInstance();
        String pinyin = generator.getPinyin(new PinyinHandler() {
            public String handle(String pinyin) {
                return String.valueOf(pinyin + ",");
            }
        }, word);
        Set<String> keywordSet = new HashSet<String>();
        String[] pinyinArray = pinyin.split(",");

        return null;
    }
}
