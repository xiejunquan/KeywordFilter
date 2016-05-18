package com.keyword.rule;

import java.util.Set;

/**
 * 关键字的类型, 高等级类型包含的低等级类型
 *
 * @author 谢俊权
 * @create 2016/2/24 14:13
 */
public interface KeywordRule {

    /**
     * 返回通过某种规则处理后的多个拓展关键字
     * @param word
     * @return
     */
    Set<String> getKeywords(String word);
}
