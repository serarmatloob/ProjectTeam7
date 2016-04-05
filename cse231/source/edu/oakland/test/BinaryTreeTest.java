package edu.oakland.test;
import edu.oakland.production.*;
import edu.oakland.helper.*;
import java.util.ArrayList;
import java.util.Random;
import junit.framework.*; 


public class BinaryTreeTest extends TestCase{
	private BinaryTree binaryTree, binaryTree2, binaryTree3;
	private int[] keys, keys2, keys3, data, data2, data3;
	private ArrayList<Integer> list, list2, list3;
	private int startRange = 900; // start of range for the value an odd number must have
     	private int endRange = 9000; // end of range for the value an odd number must have;
	int size = 20;
	int size2= 2000;
	int size3=20000;
	int min=20;
	int max=20000;
	
	public void setUp(){
		
		ArrayGen array1= new ArrayGen(20000);
		array1.createNodeKeys();
		array1.createRandomDataArray();
		
		keys=array1.getKeyArray();
		data=array1.getDataArray();
		
		ArrayGen array2= new ArrayGen(20000);
		array2.createNodeKeys();
		array2.createEvenDataArray();
		
		keys2=array2.getKeyArray();
		data2=array2.getDataArray();
		
		ArrayGen array3= new ArrayGen(20000);
		array3.createNodeKeys();
		array3.createOddDataArray();
		
		keys3=array3.getKeyArray();
		data3=array3.getDataArray();
		
	}
	public void testBinaryTree(){
		
		binaryTree = new BinaryTree(keys,data);
		
        	binaryTree.searchOdd();
        	
        	System.out.println("\n\nArray 1 Searching  Time:  " +  binaryTree.getTime());
        	
        	int[] oddNumber=binaryTree.getOddNumberArray();
        	System.out.print("Odd numbers in (Set1 equal array): ");
        	for(int i = 0;i<oddNumber.length;i++){
        		System.out.print(" [ "+oddNumber[i]+" ] ");
        	}
		for(int i=0;i<oddNumber.length;i++){
			
        		assertTrue(oddNumber[i] %2 !=0);
        		assertTrue(oddNumber[i] >=startRange && oddNumber[i] <=endRange);
        		
        	}
        
        	
	}
	public void testBinaryTree2(){
		
		binaryTree2 = new BinaryTree(keys2,data2);
		
		binaryTree2.searchOdd();
		
        	System.out.println("\n\nArray 2 Search  Time:  " +  binaryTree2.getTime());
        	
        	int[] oddNumber=binaryTree2.getOddNumberArray();
        	System.out.print("Odd numbers in (Set2 even array): ");
        	
        	for(int i = 0;i<oddNumber.length;i++){
        		System.out.print(" [ "+oddNumber[i]+" ] ");
        	}
		for(int i=0;i<oddNumber.length;i++){
			
        		assertTrue(oddNumber[i] %2 !=0);
        		assertTrue(oddNumber[i] >=startRange && oddNumber[i] <=endRange);
        		
        	}
	}
	public void testBinaryTree3(){
		
		binaryTree3 = new BinaryTree(keys3,data3);
		
		binaryTree3.searchOdd();
		
		System.out.println("\n\nArray 3 Search  Time:  " +  binaryTree3.getTime());
        	
		int[] oddNumber=binaryTree3.getOddNumberArray();
		System.out.print("Odd numbers in (Set3 odd array): ");
		for(int i = 0;i<oddNumber.length;i++){
        		System.out.print(" [ "+oddNumber[i]+" ] ");
        	}
		
		for(int i=0;i<oddNumber.length;i++){
        		assertTrue(oddNumber[i] %2 !=0);
        		assertTrue(oddNumber[i] >=startRange && oddNumber[i] <=endRange);
        	}
	}
}
