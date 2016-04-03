package edu.oakland.team7.test;
import edu.oakland.team7.production.*;
import edu.oakland.team7.helper.*;
import junit.framework.*;
import java.lang.*;
import java.util.*;

public class BinaryTreeTest extends TestCase {


	int arraySize = 20;
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
		// arrayGen.createEqualArray(); // this will pass as long as odd numbers are within range and contains equal of odd and even numbers
		binaryTree = new BinaryTree(arrayGen.getKeyArray(), arrayGen.getDataArray());
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

		binaryTree.findOdd();
		oddNumberArray = binaryTree.getValue();

		// Print out the odd numbers found
		System.out.println();
		System.out.print("The odd numbers found using pre order traverse are: ");

		for (int num : oddNumberArray) {

			System.out.format("| %d ", num);
		}

		System.out.println("|");
		System.out.println();

		System.out.println("The elapsed time using pre order traverse is: " + binaryTree.getTime() + " nanoseconds.");
		System.out.println();

		System.out.println("------------------------------------------------");

		binaryTree.findOddInOrder();
		oddNumberArray = binaryTree.getValue();

		// Print out the odd numbers found
		System.out.println();
		System.out.print("The odd numbers found using in order traverse are: ");

		for (int num : oddNumberArray) {

			System.out.format("| %d ", num);
		}

		System.out.println("|");
		System.out.println();

		System.out.println("The elapsed time using in order traverse is: " + binaryTree.getTime() + " nanoseconds.");
		System.out.println();

		System.out.println("------------------------------------------------");

		binaryTree.findOddPostOrder();
		oddNumberArray = binaryTree.getValue();

		// Print out the odd numbers found
		System.out.println();
		System.out.print("The odd numbers found using post order traverse are: ");

		for (int num : oddNumberArray) {

			System.out.format("| %d ", num);
		}

		System.out.println("|");
		System.out.println();

		System.out.println("The elapsed time using post order traverse is: " + binaryTree.getTime() + " nanoseconds.");
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