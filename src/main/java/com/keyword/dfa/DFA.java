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
        DFAState currDFAState = getFirstDFAState(keyword);
        if(!EmptyUtil.isEmpty(currDFAState)) {
            int length = keyword.length();
            for (int i = 1; i < length; i++) {
                String name = String.valueOf(keyword.charAt(i));
                if(!currDFAState.existNextState(name)){
                    boolean isEnd = (i == length - 1) ? true : false;
                    DFAState newDFAState = new DFAState(name, isEnd);
                    currDFAState.setNextState(newDFAState);
                    currDFAState = newDFAState;
                }
            }
        }
    }

    private DFAState getFirstDFAState(String keyword){

        if(!EmptyUtil.isEmpty(keyword) && keyword.length() > 0){
            int length = keyword.length();
            String firstName = String.valueOf(keyword.charAt(0));
            DFAState currDFAState = stateDiagram.get(firstName);
            if(EmptyUtil.isEmpty(currDFAState)){
                boolean isEnd = (length == 1) ? true : false;
                currDFAState = new DFAState(firstName, isEnd);
                stateDiagram.put(firstName, currDFAState);
            }
            return currDFAState;
        }
        return null;
    }


}
