package com;

public class MaxumumScoreYouCanObtainFromCards {
	public int maxScore(int[] cardPoints, int k) {
        int sum =0;
        int i =0;
        while(i<k) {
            sum+=cardPoints[i++];
        }
        int out = sum;
        int j=cardPoints.length -1;
        while(k>=0) {
            sum = sum - cardPoints[k--] + cardPoints[j--];
            out = Math.max(sum,out);
        }
        return out;
    }
}
