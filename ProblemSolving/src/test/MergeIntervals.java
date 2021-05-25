package test;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
	public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,((a,b)->a[0]-b[0]));
        ArrayList<int[]> outList = new ArrayList<>();
        outList.add(intervals[0]);
        for(int i=1;i<intervals.length;++i) {
            int prevEndDate = outList.get(outList.size()-1)[1];
            int curStartDate = intervals[i][0];
            int curEndDate = intervals[i][1];
            if(curStartDate<=prevEndDate) {
            	int prevStartDate = outList.get(outList.size()-1)[0];
            	outList.set(outList.size()-1, new int[] {prevStartDate,Math.max(prevEndDate, curEndDate)});
            } else {
            	outList.add(new int[] {curStartDate,curEndDate});
            }
        }
        return outList.toArray(new int[outList.size()][]);
    }
}
