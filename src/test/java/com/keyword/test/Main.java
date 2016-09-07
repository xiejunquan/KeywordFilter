package com.keyword.test;

import com.keyword.filter.Keyword;
import com.keyword.filter.KeywordFilter;
import com.keyword.rule.Rule;

/**
 * @author 谢俊权
 * @create 2016/2/23 16:37
 */
public class Main {

    public static void main(String[] args){

        Keyword keyword1 = new Keyword("共产党", Rule.DEFAULT, Rule.PINYIN, Rule.INITIALS);
        Keyword keyword2 = new Keyword("毛泽东", Rule.DEFAULT, Rule.PINYIN, Rule.INITIALS);
        Keyword keyword3 = new Keyword("法轮功", Rule.DEFAULT, Rule.PINYIN, Rule.INITIALS);
        Keyword keyword4 = new Keyword("江泽民", Rule.DEFAULT);


        KeywordFilter keywordFilter = new KeywordFilter();
        keywordFilter.setKeyword(keyword1);
        keywordFilter.setKeyword(keyword2);
        keywordFilter.setKeyword(keyword3);
        keywordFilter.setKeyword(keyword4);
        System.out.println(keywordFilter.filter("让卡拉集散地卢卡加速度毛泽\t\n   \r东gongchan共产党falungong就阿莱克斯打进or全无额 gongchandang啊哈哈啊哈毛泽dong江泽民虽然特认为"));

    }
}
