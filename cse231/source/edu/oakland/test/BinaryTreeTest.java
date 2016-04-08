package edu.oakland.test;
import edu.oakland.production.*;
import edu.oakland.helper.*;
import junit.framework.*;

/**
* This is a JUnit Test class that will test BinaryTree class and checks if it searches and returns
* the first two odd integers within the binaryTree and within given range.
*
* @author Serar Matloob, Michael Frieze, Tiantian Ma, Jesse Emelian
* @version 1.0 - Date: 160407
* @since 1.0
*/

public class BinaryTreeTest extends TestCase{
	/**
	**Instance Variables
	*The variable binaryTree of type BinaryTree is used to hold a reference 
	*to a BinaryTree object for scope purposes.
	*
	*The variable arrayGen of type ArrayGen is used to hold a reference 
	*to a ArrayGen object for scope purposes.
	*/
	private BinaryTree binaryTree;
	private ArrayGen arrayGen;
	private int[] keys, data;
	private int startRange,endRange;
	private int arraySize;

	/**
	*This method initializes the test by creating the test arrays (Keys and Data) within a given size
	*and passing them to the BinaryTree.
	*/
	public void setUp(){

		arraySize = 20; // number of array elements
		startRange = 900; // start of range for the value an odd number must have
		endRange = 9000; // end of range for the value an odd number must have;

		arrayGen= new ArrayGen(arraySize);
		arrayGen.createNodeKeys();
		arrayGen.createRandomDataArray();
		keys=arrayGen.getKeyArray();
		data=arrayGen.getDataArray();

		binaryTree = new BinaryTree(keys,data);

	}
	/**
	*This method starts the test by calling buildBinaryTree() method to build the binaryTree and then calls 
	*searchOddPreOrder() method to search for first two odds using preorderTraversel method.
	*
	*If the returned array from the search contains the two odd integers within the given range then it returns a boolean true.
	*/
	public void testBinaryTree(){
		binaryTree.buildBinaryTree();
		binaryTree.searchOddPreOrder();
		//binaryTree.searchOddPostOrder();

		System.out.println("\nArray search time: " +  binaryTree.getTime() +" nanoseconds");

		int[] oddNumber=binaryTree.getValues();

		System.out.print("Odd numbers: ");

		for(int i = 0;i<oddNumber.length;i++){
			System.out.print(" [ "+oddNumber[i]+" ] ");
		}

		boolean isOddInRange;
		
		for(int i = 0; i<oddNumber.length; i++){
			isOddInRange=(oddNumber[i] %2 !=0 && oddNumber[i] >=startRange && oddNumber[i] <=endRange);
			assertTrue(isOddInRange);
		}

	}

}
