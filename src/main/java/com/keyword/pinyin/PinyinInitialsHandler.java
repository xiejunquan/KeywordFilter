package com.keyword.pinyin;

/**
 * @author 谢俊权
 * @create 2016/9/7 10:57
 */
public class PinyinInitialsHandler implements PinyinHandler{

    public String handle(String pinyin) {
        return pinyin.substring(0, 1);
    }
}
