package com.keyword.filter;

import com.keyword.util.EmptyUtil;
import com.keyword.util.PinYinUtil;

import java.util.Set;

/**
 * 拼音规则, 取给出文字的拼音作为关键字, 同时包含默认规则
 *
 * @author 谢俊权
 * @create 2016/2/25 10:34
 */
public class PinyinRule implements KeywordRule{

    public Set<String> getKeywords(String word) {
        DefaultRule defaultRule = new DefaultRule();
        Set<String> set =  defaultRule.getKeywords(word);
        String pinyin = PinYinUtil.getPinyin(word);
        if(!EmptyUtil.isEmpty(pinyin)){
            set.add(pinyin);
        }
        return set;
    }
}
