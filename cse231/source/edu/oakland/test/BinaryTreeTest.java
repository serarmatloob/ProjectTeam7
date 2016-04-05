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
		
		//create set1 arrays of 20 elements (keys and data)
        	list = new ArrayList<>();
        	for (int i = 0; i < size; i++) {
        		list.add(i);
        	}
        	keys = new int[size];
        	data = new int[size];
        	for (int i = 0; i < size; i++) {
        		keys[i] = list.remove((int) (Math.random() * list.size()));
        		data[i]=min+(int)(Math.random()*((max-min)+1));
        	}
        	//create set2 arrays of size 2000 elements (keys and data)
        	list2 = new ArrayList<>();
        	for (int i = 0; i < size2; i++) {
        		list2.add(i);
        	}
        	keys2 = new int[size2];
        	data2 = new int[size2];
        	for (int i = 0; i < size2; i++) {
        		keys2[i] = list2.remove((int) (Math.random() * list2.size()));
        		data2[i]=min+(int)(Math.random()*((max-min)+1));
        	}
        	//create set3 arrays 20000 elements (keys and data)
        	list3 = new ArrayList<>();
        	for (int i = 0; i < size3; i++) {
        		list3.add(i);
        	}
        	keys3 = new int[size3];
        	data3 = new int[size3];
        	for (int i = 0; i < size3; i++) {
        		keys3[i] = list3.remove((int) (Math.random() * list3.size()));
        		data3[i]=min+(int)(Math.random()*((max-min)+1));
        	}

	}
	public void testBinaryTree(){
		
		binaryTree = new BinaryTree(keys,data);
		
        	binaryTree.searchOdd();
        	
        	System.out.println("Searching Array 1 Time:  " +  binaryTree.getTime());
        	
        	int[] oddNumber=binaryTree.getOddNumberArray();
        	
		for(int i=0;i<oddNumber.length;i++){
        		System.out.println("Odd numbers(Set1): "+oddNumber[i]);
        		assertTrue(oddNumber[i] %2 !=0);
        		assertTrue(oddNumber[i] >=startRange && oddNumber[i] <=endRange);
        	}
        
        	
	}
	public void testBinaryTree2(){
		
		binaryTree2 = new BinaryTree(keys2,data2);
		
		binaryTree2.searchOdd();
		
        	System.out.println("Searching Array 2 Time:  " +  binaryTree2.getTime());
        	
        	int[] oddNumber=binaryTree2.getOddNumberArray();
        	
		for(int i=0;i<oddNumber.length;i++){
        		System.out.println("Odd numbers(Set2): "+oddNumber[i]);
        		assertTrue(oddNumber[i] %2 !=0);
        		assertTrue(oddNumber[i] >=startRange && oddNumber[i] <=endRange);
        	}
	}
	public void testBinaryTree3(){
		
		binaryTree3 = new BinaryTree(keys3,data3);
		
		binaryTree3.searchOdd();
		
		System.out.println("Searching Array 3 Time:  " +  binaryTree3.getTime());
        	
		int[] oddNumber=binaryTree3.getOddNumberArray();
		
		for(int i=0;i<oddNumber.length;i++){
        		System.out.println("Odd numbers(Set3): "+oddNumber[i]);
        		assertTrue(oddNumber[i] %2 !=0);
        		assertTrue(oddNumber[i] >=startRange && oddNumber[i] <=endRange);
        	}
	}
}
