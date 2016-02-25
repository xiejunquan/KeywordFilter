package com.keyword.filter;

import java.util.Set;

/**
 * 关键字的类型, 高等级类型包含的低等级类型
 *
 * @author 谢俊权
 * @create 2016/2/24 14:13
 */
public interface KeywordRule {

    Set<String> getKeywords(String word);
}
