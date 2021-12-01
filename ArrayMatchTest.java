/* 
 * CSC 225 - Assignment 3
 * Name: Sanskruti Padmawar
 * Student number: V00921515
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class ArrayMatchTest {

	/*
	 * match Purpose: Determine if the two given arrays 'match' Parameters: int[] a,
	 * int[] b - the two arrays Returns: boolean - true if arrays 'match', false
	 * otherwise Preconditions: a and b have the same number of elements
	 */
	public static boolean match(int[] a, int[] b) {
		// 1. for loop to check condition 1 (are the full arrays equal to each other)
		if (a.length % 2 != 0) { // condition if A & B's size is an odd number
			for (int i = 0; i < a.length && a.length == b.length; i++) {
				if (a[i] != b[i]) {
					return false;
				}

			}
			// 2. split the arrays if length is even
		} else if (a.length % 2 == 0 && b.length % 2 == 0) {
			int midLenA = (a.length + 1) / 2;
			int midLenB = (b.length + 1) / 2;

			int[] a1 = { 0 };
			int[] a2 = { 0 };
			int[] b1 = { 0 };
			int[] b2 = { 0 };

            int size = a.length;
            if (size == 1) {
                System.out.println("Done Splitting Array");
            } else {
                for (int i = 0; i < a.length; i++) {
                    if (a.length < midLenA) {
                        
                    } else {

                    }
                    System.out.println(a1);
                }
                for (int j = 0; j < midLenB; j++) {

                }
            }



		// 	for (int i = 0; i < a.length; i++) {
		// 		if (a[i] < midLenA) {
		// 			a1[i] += a[i];
		// 		} else {
		// 			a2[i] += a[i];
		// 		}

		// 	}
		// 	for (int j = 0; j < b.length; j++) {
		// 		if (b[j] < midLenB) {
		// 			b1[j] += b[j];
		// 		} else {
		// 			b2[j] += b[j];
		// 		}

		// 	}

		// 	// 3. Check if subarrays are weird equal using a recursive call: there are 4
		// 	// conditions to check
		// 	boolean A1matchB1 = match(a1, b1);
		// 	boolean A2matchB2 = match(a2, b2);
		// 	boolean A1matchB2 = match(a1, b2);
		// 	boolean A2matchB1 = match(a2, b1);

		// 	int n = 3;
		// 	// base case
		// 	if (n == 0) {
        //         System.out.println("Done comparing sub arrays.");
		// 		return false;
		// 	} else {
		// 		n--;
		// 		if (A1matchB1 && A2matchB2)
		// 			return true;
		// 		if (A1matchB1 && A1matchB2)
		// 			return true;
		// 		if ((A2matchB1 && A2matchB2))
		// 			return true;
			
		// 	}

		// 	// 4. Combine the conditions from 3 and check if they evaluate to true: three
		// 	// cases to check
		// 	// (a1 == b1) && (a2 == b2) isCondition2True = doesA1WeirdEqualB1 &&
		// 	// doesA2WeirdEqualB2
		// 	// (a1 == b1) && (a1 == b2)
		// 	// (a2 == b1) && (a2 == b2)

		// 	// 5. Check if any of the combinations from 4 evaluate to true - if they do,
		// 	// return true, otherwise return false
		// 	// return isCondition2True ||
		// }
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

// method sum(Number num) { // 5
// if (num == 1) { //base case
// return 1
// } else {
// return num + sum(num - 1)
// }
// }