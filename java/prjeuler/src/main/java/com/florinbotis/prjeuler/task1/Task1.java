package com.florinbotis.prjeuler.task1;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
*  
*  Find the sum of all the multiples of 3 or 5 below 1000.
 * @author botisf
 *
 */
public class Task1 {

	/**
	 * 
	 * 3*(1+2+...+n3) + 5 * (1+2+...+n5)-15*(1+2+...+n15) 
	 * 
	 * @param max
	 * @return
	 */
	public static int sumMultiples3And5(int max) {
		int n3 = (max - 1) / 3;
		int n5 = (max - 1) / 5;
		int n15 = (max - 1) / 15;

		int sum3 = 3 * n3 * (n3 + 1) / 2;
		int sum5 = 5 * n5 * (n5 + 1) / 2;
		int sum15 = 15 * n15 * (n15 + 1) / 2;

		return sum3 + sum5 - sum15;
	}

	public static void main(String[] args) {
		System.out.println(sumMultiples3And5(1000));
		System.out.println("233168");
	}
}
