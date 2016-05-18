package com.keyword.rule;

import com.keyword.util.EmptyUtil;
import com.keyword.util.PinYinUtil;

import java.util.Set;

/**
 * 获取汉字的拼音的首字母, 同时包含拼音规则
 *
 * @author 谢俊权
 * @create 2016/2/25 10:46
 */
public class PinyinInitialsRule implements KeywordRule{

    public Set<String> getKeywords(String word) {
        PinyinRule pinyinRule = new PinyinRule();
        Set<String> set = pinyinRule.getKeywords(word);
        String pinyin = PinYinUtil.getPinyinInitials(word);
        if(!EmptyUtil.isEmpty(pinyin)){
            set.add(pinyin);
        }
        return set;
    }
}
