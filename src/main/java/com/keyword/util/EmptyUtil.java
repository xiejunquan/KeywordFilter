package com.keyword.util;

import java.util.Collection;

/**
 * 空值工具类
 *
 * @author 谢俊权
 * @create 2016/2/17 10:15
 */
public class EmptyUtil {

    public static boolean isEmpty(String str){
        if(str == null || str.trim().length() <= 0)
            return true;
        return false;
    }

    public static boolean isEmpty(Collection<? extends Object> collection){
        if(collection == null || collection.isEmpty())
            return true;
        return false;
    }

    public static boolean isEmpty(Object object){
        if(object == null)
            return true;
        return false;
    }
}
