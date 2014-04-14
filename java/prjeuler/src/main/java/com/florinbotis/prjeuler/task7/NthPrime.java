package com.florinbotis.prjeuler.task7;

import java.util.HashSet;

/**
By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

What is the 10 001st prime number?
 * 
 * @author botisf
 *
 */
public class NthPrime {

	private static HashSet<Integer> nonPrimes = new HashSet<Integer>();

	/**
	 * if n=1 return 2
	 * 
	 * if n=2 return 3
	 * 
	 * else
	 * 
	 * iterate over all numbers from 4 to ... until the nth prime is found
	 * 
	 * 1. Check if nonPrimes set contains the crt value, if not go on, else continue with the next iteration
	 * 
	 * 2. Check if the number is prime
	 *    a) if it is prime increment the primes index (if is the nth then return) and add all multiples (from 2 to 1000) of the primes to nonPrimes set
	 *    b) else continue to next iteration   
	 * 
	 * 
	 * @param n
	 * @return
	 */
	public static int nthPrime(int n) {
		if (n == 1)
			return 2;
		else if (n == 2)
			return 3;
		else {
			int primeIndex = 2; //because 2,3 were already considered so crt index is 2
			int nextVal = 4;

			while (primeIndex != n) {
				int val = nextVal++;

				if (nonPrimes.contains(val)) {
					continue;
				}

				boolean isPrime = checkPrime(val);
				if (isPrime) {
					primeIndex++;
					addPrimeMultiplesToNonPrimes(val);
					System.out.printf("Completed: %f \n", ((double) primeIndex / n) * 100);
				}
			}
			return nextVal - 1;
		}

	}

	/**
	 * Adds all multiples (from 2 to 1000)  of the "prime" parameter to nonPrimes list
	 * @param prime
	 */
	private static void addPrimeMultiplesToNonPrimes(int prime) {
		int last = prime * 2;
		nonPrimes.add(prime * 2);
		for (int i = 3; i < 1000; i++) {
			last += prime;
			nonPrimes.add(last);
		}
	}

	/**
	 * Naive method to check if a number is prime
	 * 
	 * @return true if number is prime
	 */
	private static boolean checkPrime(int n) {
		int max_divisor = (int) Math.sqrt(n);
		int divisor = 5;
		if (n % 2 == 0 || n % 3 == 0)
			return false;
		while (divisor <= max_divisor) {
			if (n % divisor == 0 || n % (divisor + 2) == 0) {
				return false;
			}
			divisor += 6;
		}
		return true;
	}

	public static void main(String[] args) {
		try {
			System.out.println(nthPrime(100001));
		} catch (OutOfMemoryError errror) {
			System.out.println("OOM...N is too big");
			throw errror;
		}

	}

}
