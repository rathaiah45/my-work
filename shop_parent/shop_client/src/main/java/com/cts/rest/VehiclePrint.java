package com.cts.rest;

public class VehiclePrint {
	static boolean printHeader = true;
	static boolean printModel = true;
	static boolean printYear = true;

	public static void result(Integer vehicle) {
		Integer count = 0;
		for (int i = 1; i <= vehicle; i++) {
			if (count >= 4) {
				printHeader = true;
				printModel = true;
				printYear = true;
				count = 0;
			}
			if (printHeader) {
				System.out.print("HEADER");
				printHeader = false;
			}
			System.out.print("\t VEHICLE" + i );
			// System.out.print("2015");
			if (printModel) {
				System.out.print("MODEL");
				printModel = false;
			}
			System.out.print("\t MODEL" + i );
			if (printYear) {
				System.out.print("YEAR");
				printYear = false;
			}
			System.out.print("\t YEAR" + i );
			count++;
		}
	}

	public static void main(String[] args) {
		VehiclePrint.result(6);
	}

}
