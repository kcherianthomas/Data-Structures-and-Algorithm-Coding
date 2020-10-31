package com;

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		/*
		 * We basically do two things First we check total gas - cost is >=0 else return
		 * zero Now we start at 0, If at any point the current gas-cost becomes less
		 * than 0 we update start as current index +1 and reset gas - cost to 0
		 */
		int val = 0;
		for (int i = 0; i < gas.length; ++i) {
			val += gas[i] - cost[i];
		}
		if (val < 0) {
			return -1;
		}
		int start = 0;
		val = 0;
		for (int i = 0; i < gas.length; ++i) {
			val += gas[i] - cost[i];
			if (val < 0) {
				start = i + 1;
				val = 0;
			}
		}
		return start;
	}
}
