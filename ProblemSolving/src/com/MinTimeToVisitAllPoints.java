package com;
/*On a plane there are n points with integer coordinates points[i] = [xi, yi]. 
 *Your task is to find the minimum time in seconds to visit all points.
 *You can move according to the next rules:
 *In one second always you can either move vertically, horizontally by one unit 
 *or diagonally (it means to move one unit vertically and one unit horizontally in one second).
 *You have to visit the points in the same order as they appear in the array.
 */
public class MinTimeToVisitAllPoints {
	/* The idea is that in order to find the min time you will need to find difference
	 * in the x and y value for i and i+1th pair(Make sure to use the absolute values). 
	 * The max of these x and y will give distance between that point.
	 * The time complexity is O(N)
	 */
public int minTimeToVisitAllPoints(int[][] points) {
	 int count=0;
     for(int i=0;i<points.length-1;++i) {
     	int x = Math.abs(points[i+1][0]-points[i][0]);
     	int y = Math.abs(points[i+1][1]-points[i][1]);
     	count+=Math.max(x, y);
    }
    return count;
    }
}
