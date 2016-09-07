package com.keyword.filter;

import java.util.Set;

/**
 * 处理文字中的关键字
 *
 * @author 谢俊权
 * @create 2016/2/25 16:57
 */
public interface KeywordReplacer {

    String handle(Set<String> keywordSet, String word);
}
