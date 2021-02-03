package com;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {
	public String convert(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}
		List<StringBuilder> bld = new ArrayList<>();
		for (int i = 0; i < numRows; i++) {
			bld.add(new StringBuilder());
		}
		boolean moveDown = true;
		int row = 0;
		for (int i = 0; i < s.length(); ++i) {

			bld.get(row).append(s.charAt(i));
			row += moveDown ? 1 : -1;
			if (row == numRows - 1 || row == 0) {
				moveDown = !moveDown;
			}

		}
		StringBuilder out = new StringBuilder();
		for (StringBuilder temp : bld) {
			out.append(temp);
		}
		return out.toString();

	}
}
