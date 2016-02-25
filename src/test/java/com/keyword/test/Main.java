package com.keyword.test;

import com.keyword.filter.*;

/**
 * @author 谢俊权
 * @create 2016/2/23 16:37
 */
public class Main {

    public static void main(String[] args){

        Keyword keyword1 = new Keyword("共产党", new PinyinInitialsRule());
        Keyword keyword2 = new Keyword("毛泽东", new PinyinInitialsRule());
        Keyword keyword3 = new Keyword("江泽民", new DefaultRule());


        KeywordFilter keywordFilter = new KeywordFilter();
        keywordFilter.setKeyword(keyword1);
        keywordFilter.setKeyword(keyword2);
        keywordFilter.setKeyword(keyword3);
        System.out.println(keywordFilter.filter("让卡拉集散地卢卡加速度毛泽东gongchan共产党就阿莱克斯打进or全无额 gongchandang啊哈哈啊哈毛泽江泽民虽然特认为", new DefaultHandler()));
    }
}
