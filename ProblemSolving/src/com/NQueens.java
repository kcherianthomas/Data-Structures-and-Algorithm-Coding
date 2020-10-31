package com;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> out = new ArrayList<>();
		out = solve(out, n, new ArrayList<String>());
		return out;
	}

	private List<List<String>> solve(List<List<String>> out, int n, ArrayList<String> completedRows) {
		if (completedRows.size() == n) {
			out.add(new ArrayList<String>(completedRows));
			System.out.println(completedRows.get(n-1));
			return out;
		}
		char[] s = new char[n];
		for (int i = 0; i < s.length; ++i) {
			s[i] = '.';
		}
		for (int i = 0; i < n; ++i) {
			s[i] = 'Q';
			completedRows.add(new String(s));
			printList(completedRows);
			if (isValid(completedRows, n)) {
				System.out.println("row = "+(completedRows.size()-1)+ "column ="+i);
				
				out = solve(out, n, completedRows);
			}
			completedRows.remove(completedRows.size() - 1);
			s[i]='.';
		}
		return out;
	}

	private boolean isValid(ArrayList<String> completedRows, int n) {
		int curRow = completedRows.size() - 1;
		if(curRow==0) {
			return true;
		}
		String s = completedRows.get(curRow);
		int positionOfQueen = 0;
		for (positionOfQueen = 0; positionOfQueen < s.length(); ++positionOfQueen) {
			if (s.charAt(positionOfQueen) == 'Q') {
				break;
			}
		}
		int k = 1;
		for (int i = curRow - 1; i >= 0; --i) {
			String rowTocheck = completedRows.get(i);
			if (rowTocheck.charAt(positionOfQueen) == 'Q') {
				return false;
			}
			if (((positionOfQueen - k >= 0) && rowTocheck.charAt(positionOfQueen - k) == 'Q')
					|| ((positionOfQueen + k < n) && rowTocheck.charAt(positionOfQueen + k) == 'Q')) {
				return false;
			}
			k++;
		}
		return true;
	}
	
	private void printList(ArrayList<String> completedRows) {
		for(String temp: completedRows) {
			System.out.println(temp);
		}
	}
	public static void main(String []args) {
		NQueens n = new NQueens();
		n.solveNQueens(4);
	}
}
