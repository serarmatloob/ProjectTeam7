package edu.oakland.team7.test;
import edu.oakland.team7.production.*;
import edu.oakland.team7.helper.*;
import junit.framework.*;
import java.lang.*;
import java.util.*;

public class BinaryTreeTest extends TestCase {


	int arraySize = 20000;
	private ArrayGen arrayGen;
	private BinaryTree binaryTree;
	private boolean isOddInRange;
	private int[] oddNumberArray;


	public void setUp() {

		arrayGen = new ArrayGen(arraySize);
		arrayGen.createNodeKeys();
		arrayGen.createRandomDataArray(); // this will pass as long as odd numbers are within range
		// arrayGen.createEvenDataArray(); // this will fail the test
		// arrayGen.createOddDataArray(); // this will pass as long as odd numbers are within range
		binaryTree = new BinaryTree(arrayGen.getKeyArray(), arrayGen.getDataArray());
		binaryTree.buildBinaryTree();
	}


	public void testBinaryTree() {
		
		
		// Print out the array
		System.out.println();
		for (int i = 0; i < arraySize; i++) {

			System.out.println(arrayGen.getDataArray()[i] + " has the key: " + arrayGen.getKeyArray()[i]);
		}
		
		

		// Print out array size
		System.out.println();
		System.out.println("The size of the array is: " + arraySize);
		System.out.println();

		System.out.println("--------------------------------------------------------");

		// Using preorder Traversal
		binaryTree.findOddInOrder();
		oddNumberArray = binaryTree.getValue();

		// Print out the odd numbers found
		System.out.println();
		System.out.print("The odd numbers found using IN ORDER TRAVERSE are: ");

		for (int num : oddNumberArray) {

			System.out.format("| %d ", num);
		}

		System.out.println("|");
		System.out.println();

		System.out.println("The elapsed time using IN ORDER TRAVERSE is: " + binaryTree.getTime() + " nanoseconds.");
		System.out.println();

		System.out.println("--------------------------------------------------------");


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