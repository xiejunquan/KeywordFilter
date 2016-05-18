package com.keyword.filter;

import com.keyword.rule.KeywordRule;

import java.util.Set;

/**
 * 关键字描述
 *
 * @author 谢俊权
 * @create 2016/2/24 15:03
 */
public class Keyword {

    private String word;
    private KeywordRule rule;

    public Keyword(String word, KeywordRule rule) {
        this.word = word;
        this.rule = rule;
    }

    public Set<String> getKeywords(){
       return rule.getKeywords(word);
    }

    public KeywordRule getRule() {
        return rule;
    }

    public String getWord() {
        return word;
    }
}
