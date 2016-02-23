package com.keyword.dfa;

import com.keyword.util.EmptyUtil;

import java.util.*;

/**
 * DFA算法
 *
 * @author 谢俊权
 * @create 2016/2/23 16:58
 */
public class DFA {

    private Map<String, DFAState> stateDiagram = new HashMap<String, DFAState>();

    private Set<String> keywordSet = new HashSet<String>();

    private static class DFAHolder{
        public static DFA dfa = new DFA();
    }
    public static DFA getInstance(){
        return DFAHolder.dfa;
    }
    private DFA(){
    }

    public void setKeywords(Set<String> keywordSet) {
        if(!EmptyUtil.isEmpty(keywordSet)){
            Iterator<String> it = keywordSet.iterator();
            while(it.hasNext()){
                String name = it.next();
                setKeyword(name);
            }
        }
    }









    public void setKeyword(String keyword){
        keywordSet.add(keyword);
        setKeywordToDFAState(keyword);
    }

    private void setKeywordToDFAState(String keyword){
        int length = keyword.length();
        for(int i = 0; i < length; i++){
            char ch = keyword.charAt(i);
            String name = String.valueOf(ch);
            if(i == 0){

            }else {

            }
            boolean isEnd = false;
            if(i >= length - 1){
                isEnd = true;
            }
            setDFAState(name, isEnd);
        }
    }

    private void setFirstDFAState(String stateName, boolean isEnd){

    }

    private void setDFAState(String stateName, boolean isEnd){
        if(stateDiagram.containsKey(stateName)){

        }
    }



}
