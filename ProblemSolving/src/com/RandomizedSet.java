package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
	Map<Integer, Integer> map = null;
	ArrayList<Integer> list = null;
	int i;

	/** Initialize your data structure here. */
	public RandomizedSet() {
		map = new HashMap<>();
		list = new ArrayList<>();
		i = 0;
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already contain
	 * the specified element.
	 */
	public boolean insert(int val) {
		if (!map.containsKey(val)) {
			list.add(val);
			map.put(val, i++);
			return true;
		}
		return false;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the specified
	 * element.
	 */
	public boolean remove(int val) {
		if (map.containsKey(val)) {
			int lastVal = list.get(i-1);
			if(lastVal==val) {
				list.remove(i-1);
				map.remove(val);
				i--;
				return true;
			}
			int curIndex = map.get(val);
			list.set(curIndex, lastVal);
			list.remove(i-1);
			map.remove(val);
			map.put(lastVal, curIndex);
			i--;
			return true;
		}
		return false;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		Random r =  new Random();
		return list.get(r.nextInt(list.size()));
	}
	
	public static void main(String []args) {
		  RandomizedSet obj = new RandomizedSet();
		  boolean param_1 = obj.insert(0);
		  boolean param_2 = obj.insert(1);

		  boolean param_3 = obj.remove(0);
		  boolean param_4 = obj.insert(2);
		  boolean param_5 = obj.remove(1);

		  int param_6 = obj.getRandom();
	}
}
