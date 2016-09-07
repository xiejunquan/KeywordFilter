package com.keyword.rule;

/**
 * @author 谢俊权
 * @create 2016/9/7 10:47
 */
public enum Rule {
    DEFAULT(new DefaultRule()),
    PINYIN(new PinyinRule()),
    INITIALS(new InitialsRule()),
    MIX(new MixRule());

    private final KeywordRule keywordRule;

    Rule(KeywordRule keywordRule) {
        this.keywordRule = keywordRule;
    }

    public KeywordRule getKeywordRule() {
        return keywordRule;
    }
}
