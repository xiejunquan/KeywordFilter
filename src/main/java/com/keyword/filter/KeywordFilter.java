package com.keyword.filter;

import com.keyword.dfa.DFA;
import com.keyword.util.EmptyUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * 关键词过滤操作类
 *
 * @author 谢俊权
 * @create 2016/2/23 16:57
 */
public class KeywordFilter {

    private DFA dfa = new DFA();

    private Set<Keyword> keywords = new HashSet<Keyword>();

    public void setKeywords(Set<Keyword> keywordSet){
        if(!EmptyUtil.isEmpty(keywordSet)){
            for (Keyword keyword : keywordSet) {
                dfa.setKeywords(keyword.getKeywords());
            }
            keywords.addAll(keywordSet);
        }
    }

    public void setKeyword(Keyword keyword){
        if(!EmptyUtil.isEmpty(keyword)){
            dfa.setKeywords(keyword.getKeywords());
            keywords.add(keyword);
        }
    }

    public Set<String> filter(Set<String> wordSet, KeywordHandler handler){
        Set<String> result = new HashSet<String>();
        if(!EmptyUtil.isEmpty(wordSet)){
            if(!dfa.isBuilded()){
                dfa.build();
            }
            for (String word : wordSet) {
                result.add(filter(word, handler));
            }
        }
        return result;
    }

    public String filter(String word, KeywordHandler handler){

        String filterWord = word;
        if(!EmptyUtil.isEmpty(word)){
            if(!dfa.isBuilded()){
                dfa.build();
            }
            Set<String> keywordSet = dfa.search(word);
            filterWord = handler.handle(keywordSet, word);
        }
        return filterWord;
    }




}
