package com;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
	public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> out = new ArrayList<>();
        getCombinations(k,n,out,new ArrayList<Integer>(),1);
        return out;
    }

	private void getCombinations(int depth, int target, List<List<Integer>> out, ArrayList<Integer> list, int index) {
		if(depth==0 && target == 0) {
			out.add(new ArrayList<>(list));
		} else if(depth==0 || target<0) {
			return;
		}
		for(int i=index;i<=9;++i) {
			list.add(i);
			getCombinations(depth-1,target-i,out,list,i+1);
			list.remove(list.size()-1);
		}
		
	}
}
