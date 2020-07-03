package com;

import java.util.HashMap;
import java.util.Map;

public class FourSum2 {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		Map<Integer,Integer> sumAB = new HashMap<>();
		int count =0;
		for(int i=0;i<A.length;++i) {
			for(int j=0;j<B.length;++j) {
				int sum = A[i]+B[j];
				if(sumAB.containsKey(sum)) {
					sumAB.put(sum, sumAB.get(sum)+1);
				} else {
					sumAB.put(sum, 1);
				}
			}
		}
		for(int i=0;i<C.length;++i) {
			for(int j=0;j<D.length;++j) {
				int sum = C[i]+D[j];
				sum=0-sum;
				if(sumAB.containsKey(sum)) {
					count+=sumAB.get(sum);
				} 
			}
		}
		return count;
	}
}
