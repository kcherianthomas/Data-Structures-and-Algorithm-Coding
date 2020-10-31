package com;

import java.util.List;

public class CarDistance {
	private int carDistance(int n, List<Integer> start, List<Integer> finish) {
	 boolean []check = new boolean[n+1];
     for(int i=0;i<=n;++i) {
         check[i] = false;
     }
     for(int i=0;i<start.size();++i) {
         for(int j=start.get(i);j<=finish.get(i);j++) {
             check[j] = true;
         }
     }
     int out =0;
     for(int i=1;i<=n;++i) {
         int count =0;
         while(!check[i]) {
             count++;
             ++i;
         }
         out = Math.max(out,count);
     }
     return out;
	}

}
