package com.cts.rest;

public class Main {

	public static String swapMethod(String fname, String lname) {
		String temp = "";
		temp = fname;
		fname = lname;
		lname = temp;
		return fname + " " + lname;
	}

	public static String resultString(String input) {
		String[] str = input.split(" ");
		String finalValue="";
		Integer len = (str.length / 2);
		String result = "";
		if (str.length % 2 != 0) {
		finalValue=str[str.length-1];
		}
		int i = 0, j = 1;
		for (int k = 0; k < len; k++) {
			result = result + " " + swapMethod(str[i], str[j]);
			i = i + 2;
			j = j + 2;
		}
		return result+" "+finalValue;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(4 / 2);
		System.out
				.println(Main
						.resultString("RATHAIAH YASAM THIRUPATHAIAH RAJAMMA SRINU SRIVANI KONDALARAO"));
	}

}
