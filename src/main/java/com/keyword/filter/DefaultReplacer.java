package com.keyword.filter;

import java.util.Set;

/**
 * 默认过滤方式, 将敏感关键字替换成星号
 *
 * @author 谢俊权
 * @create 2016/2/25 17:02
 */
public class DefaultReplacer implements KeywordReplacer {

    private static final String REPLACE = "*";

    public String handle(Set<String> keywordSet, String word) {

        for (String keyword : keywordSet) {
            int length = keyword.length();
            StringBuilder replaceBuilder = new StringBuilder();
            for (int i = 0; i < length; i++) {
                replaceBuilder.append(REPLACE);
            }
            word = word.replaceAll(keyword, replaceBuilder.toString());
        }
        return word;
    }
}
