package com.keyword.dfa;

import java.util.HashMap;
import java.util.Map;

/**
 * dfa的状态
 *
 * @author 谢俊权
 * @create 2016/2/23 17:26
 */
public class DFAState {

    private String stateName;
    private boolean isEnd;
    private Map<String, DFAState> nextStateMap = new HashMap<String, DFAState>();


    public DFAState(String stateName, boolean isEnd) {
        this.stateName = stateName;
        this.isEnd = isEnd;
    }

    public void setNextState(DFAState state){
        String stateName = state.getStateName();
        nextStateMap.put(stateName, state);
    }

    public DFAState getNextState(String stateName){
        return nextStateMap.get(stateName);
    }

    public boolean existNextState(String stateName){
        return nextStateMap.containsKey(stateName);
    }

    public String getStateName() {
        return stateName;
    }

    public boolean isEnd() {
        return isEnd;
    }
}
