package edu.oakland.team7.test;
import edu.oakland.team7.production.*;
import junit.framework.*;


public class BinaryTreeTest extends TestCase {


	private int arraySize = 20000;
	private int[] keyArray;
	private int[] dataArray;
	private BinaryTree binaryTree;
	private boolean isOddInRange;


	public void setUp() {

		//Build random array for testing
		keyArray = new int[arraySize];
		dataArray = new int[arraySize];


		for (int i = 0; i < arraySize; i++) {

			//Min + (int)(Math.random() * ((Max - Min) + 1))
			keyArray[i] = arraySize + (int)(Math.random() * (((arraySize * 2) + arraySize) + 1));
			dataArray[i] = dataArray[i] = 20 + (int)(Math.random() * ((20000 - 20) + 1));
		}

		System.out.println();


		//Print out current array of keys and data
		System.out.println("Keys:");

		for (int num : keyArray) {

			System.out.format("| %d ", num);
		}

		System.out.println();
		System.out.println();
		System.out.println("Data:");

		for (int num : dataArray) {

			System.out.format("| %d ", num);
		}

		System.out.println();
		System.out.println();


		binaryTree = new BinaryTree(keyArray, dataArray);
	}


	public void testBinaryTree() {


		// Uncomment whichever section you want to use for test
		binaryTree.preorderTraverseTree(binaryTree.getRoot());
		int[] oddNumberArray = binaryTree.getValue();

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