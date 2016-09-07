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

    /**
     * 设置敏感关键字的集合
     * @param keywordSet
     */
    public void setKeywords(Set<Keyword> keywordSet){
        if(!EmptyUtil.isEmpty(keywordSet)){
            for (Keyword keyword : keywordSet) {
                dfa.setKeywords(keyword.getKeywords());
            }
            keywords.addAll(keywordSet);
        }
    }

    /**
     * 设置敏感关键字
     * @param keyword
     */
    public void setKeyword(Keyword keyword){
        if(!EmptyUtil.isEmpty(keyword)){
            dfa.setKeywords(keyword.getKeywords());
            keywords.add(keyword);
        }
    }

    public Set<String> filter(Set<String> wordSet){
        return filter(wordSet, new DefaultReplacer());
    }

    /**
     * 获取过滤了敏感词的原文
     * @param wordSet   需要被过滤的原文集合
     * @param handler   过滤关键字的处理办法
     * @return
     */
    public Set<String> filter(Set<String> wordSet, KeywordReplacer handler){
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

    public String filter(String word){
        return filter(word, new DefaultReplacer());
    }

    /**
     * 获取过滤了敏感词的原文
     * @param word   需要被过滤的原文
     * @param handler   过滤关键字的处理办法
     * @return
     */
    public String filter(String word, KeywordReplacer handler){

        String filterWord = word;
        if(!EmptyUtil.isEmpty(word)){
            if(!dfa.isBuilded()){
                dfa.build();
            }
            String notEmptyWord = filterWord.replaceAll("[\t\n\r\\v\f ]", "");
            Set<String> keywordSet = dfa.search(notEmptyWord);
            if(!keywordSet.isEmpty()){
                filterWord = handler.handle(keywordSet, notEmptyWord);
            }
        }
        return filterWord;
    }




}
