package com.keyword.filter;

import java.util.HashSet;
import java.util.Set;

/**
 * 默认规则, 取给出的文字作为关键字
 *
 * @author 谢俊权
 * @create 2016/2/25 10:31
 */
public class DefaultRule implements KeywordRule{

    public Set<String> getKeywords(String word) {
        Set<String> set = new HashSet<String>();
        set.add(word);
        return set;
    }
}
