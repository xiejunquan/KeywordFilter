package com.keyword.filter;

/**
 * 关键字描述
 *
 * @author 谢俊权
 * @create 2016/2/24 15:03
 */
public class Keyword {

    private String name;
    private KeywordRule rule;

    public Keyword(String name, KeywordRule rule) {
        this.name = name;
        this.rule = rule;
    }

    public KeywordRule getRule() {
        return rule;
    }

    public String getName() {
        return name;
    }
}
