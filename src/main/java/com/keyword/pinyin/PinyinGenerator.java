package com.keyword.pinyin;

import com.keyword.util.EmptyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author 谢俊权
 * @create 2016/9/7 10:58
 */
public class PinyinGenerator {

    private static final Logger logger = LoggerFactory.getLogger(PinyinGenerator.class);

    private static final String UNICODE_TO_CHINESE_PINYIN_TXT = "unicode_to_chinese_pinyin.txt";

    private static final Properties chinesePinyinMap = new Properties();

    private static PinyinGenerator pinyinGenerator = new PinyinGenerator();

    private PinyinGenerator() {
        URL url = ClassLoader.getSystemResource(UNICODE_TO_CHINESE_PINYIN_TXT);
        loadUnicodeToChinesePinyinTxt(url.getPath());
    }

    public static PinyinGenerator getInstance(){
        return pinyinGenerator;
    }

    /**
     * 加载unicode的拼音对应表
     * @param unicodeToChinesePinyinTxt
     */
    public static void loadUnicodeToChinesePinyinTxt(String unicodeToChinesePinyinTxt){
        InputStream is = null;
        try {
            if(!chinesePinyinMap.isEmpty()){
                chinesePinyinMap.clear();
            }
            is = new FileInputStream(unicodeToChinesePinyinTxt);
            chinesePinyinMap.load(is);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    logger.error("error to close input stream {}", unicodeToChinesePinyinTxt, e);
                }
            }
        }
    }

    public static String getPinyin(PinyinHandler handler, String chinese){

        StringBuilder pinyinBuilder = new StringBuilder();
        if(!EmptyUtil.isEmpty(chinese)){
            int length = chinese.length();
            for(int i = 0; i < length; i++){
                int codePoint = chinese.codePointAt(i);
                String code = Integer.toHexString(codePoint).toUpperCase();
                String pinyinProperty = chinesePinyinMap.getProperty(code);
                if(!EmptyUtil.isEmpty(pinyinProperty)) {
                    String pinyin = getPinyinFromProperty(pinyinProperty);
                    pinyinBuilder.append(handler.handle(pinyin));
                }else{
                    pinyinBuilder.append(chinese.charAt(i));
                }
            }
        }
        return pinyinBuilder.toString();
    }

    private static String getPinyinFromProperty(String pinyin){

        int begin = pinyin.lastIndexOf(Field.LEFT_BRACKET) + 1;
        int end =  pinyin.indexOf(Field.RIGHT_BRACKET);
        String temp = pinyin.substring(begin, end);
        String[] pinyinArray = temp.split(Field.COMMA);
        List<String> pinyinList = getListFromPinyinArray(pinyinArray);
        if(EmptyUtil.isEmpty(pinyinList))
            return null;
        return pinyinList.get(0);
    }

    private static List<String> getListFromPinyinArray(String[] array){
        List<String> list = new ArrayList<String>();
        int length = array.length;
        for(int i = 0; i < length; i++){
            String pinyinWithNumber = array[i];
            String pinyin = pinyinWithNumber.replaceAll("[1-5]", "");
            if(!list.contains(pinyin)){
                list.add(pinyin);
            }
        }
        return list;
    }

    private static class Field{
        static final String LEFT_BRACKET = "(";
        static final String RIGHT_BRACKET = ")";
        static final String COMMA = ",";
    }
}
