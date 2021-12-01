/* 
 * CSC 225 - Assignment 3
 * Name: Sanskruti Padmawar
 * Student number: V00921515
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class ArrayMatch {

	/*
	 * match Purpose: Determine if the two given arrays 'match' Parameters: int[] a,
	 * int[] b - the two arrays Returns: boolean - true if arrays 'match', false
	 * otherwise Preconditions: a and b have the same number of elements
	 */
	public static boolean match(int[] a, int[] b) {
		// Base case: are lengths odd?
		if (a.length % 2 != 0 && a.length == b.length) {
			for (int i = 0; i < a.length; i++) {
				if (a[i] != b[i]) {
					return false;
				}

			}
			return true;
			// split the arrays if length is even
		} else if (a.length % 2 == 0 && b.length % 2 == 0 && a.length == b.length) {
			int midLenA = a.length / 2;
			int midLenB = b.length / 2;

			int[] a1 = new int[midLenA];
			int[] a2 = new int[midLenA];
			int[] b1 = new int[midLenB];
			int[] b2 = new int[midLenB];

			for (int x = 0; x < a.length; x++) {
				if (x <= midLenA - 1) {
					a1[x] = a[x];

				} else if (x > midLenA - 1) {
					a2[x - midLenA] = a[x];
				}
			}

			for (int x = 0; x < b.length; x++) {
				if (x <= midLenB - 1) {
					b1[x] = b[x];
				} else if (x > midLenB - 1) {
					b2[x - midLenB] = b[x];
				}
			}

			// Check if sub arrays match using a recursive call
			boolean A1matchB1 = match(a1, b1);
			boolean A2matchB2 = match(a2, b2);
			boolean A1matchB2 = match(a1, b2);
			boolean A2matchB1 = match(a2, b1);

			if ((A1matchB1 && A2matchB2) || (A1matchB1 && A1matchB2 || (A2matchB1 && A2matchB2))) {
				return true;
			}
			return false;
		}

		return false;
	}

	/*
	 * fillArray Purpose: Fills arrays with contents read from Scanner Parameters:
	 * int[] x, Scanner fileReader Returns: nothing
	 */
	public static void fillArray(int[] x, Scanner fileReader) throws NoSuchElementException {
		Scanner f = new Scanner(fileReader.nextLine());
		for (int i = 0; i < x.length; i++) {
			x[i] = f.nextInt();
		}
	}

	/*
	 * a3Setup Purpose: Initializes the input arrays for Assignment 3 match
	 * detection by reading data from the text file named fname Parameters: String
	 * fname - name of the file containing input data Returns: nothing
	 */
	public static void a3Setup(String fname) {
		Scanner fileReader = null;
		int[] A = null;
		int[] B = null;

		try {
			fileReader = new Scanner(new File(fname));
		} catch (FileNotFoundException e) {
			System.out.println("Error finding input file");
			e.printStackTrace();
			return;
		}

		try {
			int size = Integer.parseInt(fileReader.nextLine());
			A = new int[size];
			B = new int[size];
			fillArray(A, fileReader);
			fillArray(B, fileReader);
		} catch (NoSuchElementException e) {
			System.out.println("Error reading input file data");
			e.printStackTrace();
		}

		if (match(A, B)) {
			System.out.println("match found");
		} else {
			System.out.println("no matches");
		}
	}

	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Incorrect usage, should be:");
			System.out.println("java MysteryArray filename.txt");
			return;
		}
		a3Setup(args[0]);
	}
}