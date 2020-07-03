package com;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {

    ArrayList<Integer> list;
    int i;
    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList();
        list.addAll(getAllValues(nestedList));
        i=0;
    }

    List<Integer> getAllValues(List<NestedInteger> nestedList) {
        List<Integer> tempList = new ArrayList<>();
        for(NestedInteger temp : nestedList) {
            if(temp.isInteger()) {
                tempList.add(temp.getInteger());
            } else {
                tempList.addAll(getAllValues(temp.getList()));
            }
        }
        return tempList;
    }
    
    @Override
    public Integer next() {
        return list.get(i++);
    }

    @Override
    public boolean hasNext() {
        if(i<list.size()) { 
            return true;
        }
        return false;
    }
}
