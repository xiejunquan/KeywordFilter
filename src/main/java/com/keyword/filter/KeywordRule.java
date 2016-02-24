package com.keyword.filter;

/**
 * 关键字的类型, 高等级类型包含的低等级类型
 *
 * @author 谢俊权
 * @create 2016/2/24 14:13
 */
public class KeywordRule {

    /**
     * 默认规则, 即把给出的文字当作关键字
     */
    public static final int DEFAULT = 0X01;

    /**
     * 拼音规则, 即把给出文字的拼音作为关键字, 同时包含默认规则
     */
    public static final int PINYIN = 0X02;

    /**
     * 拼音缩写规则, 即把给出文字的拼音缩写作为关键字, 同时包含默认规则
     */
    public static final int PINYIN_INITIALS = 0X03;


}
