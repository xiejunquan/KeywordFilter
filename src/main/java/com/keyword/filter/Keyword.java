package com.keyword.filter;

import com.keyword.rule.KeywordRule;
import com.keyword.rule.Rule;

import java.util.*;

/**
 * 关键字描述
 *
 * @author 谢俊权
 * @create 2016/2/24 15:03
 */
public class Keyword {

    private String word;
    private List<Rule> ruleList = new ArrayList<Rule>();

    public Keyword(String word, Rule... rule) {
        this.word = word;
        this.ruleList.addAll(Arrays.asList(rule));
        if(!this.ruleList.contains(Rule.DEFAULT)){
            this.ruleList.add(Rule.DEFAULT);
        }
    }

    public Set<String> getKeywords(){
        Set<String> keywordSet = new HashSet<String>();
        for (Rule rule : ruleList) {
            KeywordRule keywordRule = rule.getKeywordRule();
            Set<String> keywords = keywordRule.getKeywords(word);
            keywordSet.addAll(keywords);
        }
       return keywordSet;
    }
}
