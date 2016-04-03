package edu.oakland.team7.test;
import edu.oakland.team7.production.*;
import junit.framework.*;
import java.lang.*;


public class BinaryTreeTest extends TestCase {


	private int arraySize = 2000000;
	private int[] keyArray;
	private int[] dataArray;
	private BinaryTree binaryTree;
	private boolean isOddInRange;


	public void setUp() {

		// Build random array for testing
		keyArray = new int[arraySize];
		dataArray = new int[arraySize];

		for (int i = 0; i < arraySize; i++) {

			// Min + (int)(Math.random() * ((Max - Min) + 1))
			// Try increasing the maximum random value if you want to make this program more complex.
			keyArray[i] = arraySize + (int)(Math.random() * (((arraySize * 2) + arraySize) + 1));
			dataArray[i] = dataArray[i] = 20 + (int)(Math.random() * ((2000000 - 20) + 1));
		}

		System.out.println();


		// Print out current array of keys and data
		for (int i = 0; i < arraySize; i++) {

			System.out.println(dataArray[i] + " has the key: " + keyArray[i]);
		}

		System.out.println();


		binaryTree = new BinaryTree(keyArray, dataArray);
	}


	public void testBinaryTree() {

		int[] oddNumberArray = binaryTree.getValue();
		System.out.println("The elapsed time is: " + binaryTree.getTime());


		// Print out oddNumberArray
		System.out.println();
		System.out.print("The odd numbers are: ");

		for (int num : oddNumberArray) {

			System.out.format("| %d ", num);
		}

		System.out.println("|");
		System.out.println();


		// finding out if oddNumberArray contains odd ints within given range
		for (int num : oddNumberArray) {

			if (num % 2 == 1) {

				if (num >= 900 && num <= 9000) {

					isOddInRange = true;
				} 

				else {

					isOddInRange = false;
					break;
				}
			} 
			
			else {

				isOddInRange = false;
				break;
			}
		}

		assertTrue(isOddInRange);
		
	}
}