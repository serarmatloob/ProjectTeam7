package edu.oakland.test;
import edu.oakland.production.*;
import edu.oakland.helper.*;
import junit.framework.*;


public class BinaryTreeTest extends TestCase{
	private BinaryTree binaryTree;
	private int[] keys, data;
	private int startRange = 900; // start of range for the value an odd number must have
	private int endRange = 9000; // end of range for the value an odd number must have;
	private int arraySize = 20;

	public void setUp(){

		ArrayGen arrayGen= new ArrayGen(arraySize);
		arrayGen.createNodeKeys();
		arrayGen.createRandomDataArray();
		keys=arrayGen.getKeyArray();
		data=arrayGen.getDataArray();
		
		binaryTree = new BinaryTree(keys,data);

	}
	public void testBinaryTree(){

		binaryTree.searchOdd();

		System.out.println("\n\nArray search time: " +  binaryTree.getTime() +" nanoseconds");

		int[] oddNumber=binaryTree.getOddNumberArray();
		
		System.out.print("Odd numbers: ");
		
		for(int i = 0;i<oddNumber.length;i++){
			System.out.print(" [ "+oddNumber[i]+" ] ");
		}
		for(int i = 0; i<oddNumber.length; i++){

			assertTrue(oddNumber[i] %2 !=0);
			assertTrue(oddNumber[i] >=startRange && oddNumber[i] <=endRange);

		}

	}

}
