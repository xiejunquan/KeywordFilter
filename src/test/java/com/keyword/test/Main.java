package com.keyword.test;

import com.keyword.dfa.DFA;
import com.keyword.filter.DefaultRule;
import com.keyword.filter.Keyword;
import com.keyword.filter.PinyinInitialsRule;

/**
 * @author 谢俊权
 * @create 2016/2/23 16:37
 */
public class Main {

    public static void main(String[] args){

        Keyword keyword1 = new Keyword("共产党", new PinyinInitialsRule());
        Keyword keyword2 = new Keyword("毛泽东", new PinyinInitialsRule());
        Keyword keyword3 = new Keyword("江泽民", new DefaultRule());

        DFA dfa = new DFA();
        dfa.setKeywords(keyword1.getKeywords());
        dfa.setKeywords(keyword2.getKeywords());
        dfa.setKeywords(keyword3.getKeywords());
        dfa.build();
        System.out.println(dfa.search("让卡拉集散地卢卡加速度毛泽东gongchan共产党就阿莱克斯打进or全无额 gongchandang啊哈哈啊哈毛泽江泽民虽然特认为"));
    }
}
