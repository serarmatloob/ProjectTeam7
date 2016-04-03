package edu.oakland.test;
import edu.oakland.production.*;
import edu.oakland.helper.*;
import java.util.ArrayList;
import java.util.Random;
import junit.framework.*; 


public class BinaryTreeTest extends TestCase{
	private BinaryTree binaryTree;
	private Node node;
	private long startTime;
        private long endTime;
	public void setUp(){
		node = new Node();
		int[] oddArray= new int[2];
		int startRange=900;
		int endRange=9000;
		binaryTree = new BinaryTree(node, oddArray, startRange, endRange);
		
		Random random = new Random();
        	int size = 20000;
        
        	ArrayList<Integer> list = new ArrayList<>();
        	for (int i = 0; i < size; i++) {
        		list.add(i);
        	}
        
        	int[] keys = new int[size];
        	for (int i = 0; i < size; i++) {
        		keys[i] = list.remove((int) (Math.random() * list.size()));
        	}
        	int[] data = new int[size];
        	for (int i = 0; i < data.length; i++) {
        		int number = random.nextInt(1000);
        		data[i] = number;
        	}

        	for (int i = 0; i < keys.length; i++) {
        		binaryTree.addNode(keys[i], data[i]);
        	}

        	
	}
	public void testBinaryTree(){
		int startRange=900;
		int endRange=9000;
		startTime = System.currentTimeMillis();
        	binaryTree.preorderTraverseTree2(binaryTree.getRoot());
        	endTime = System.currentTimeMillis();
        	System.out.println("Time took: " + (endTime - startTime)+" milliseconds");
        	System.out.println("right childs: " + binaryTree.rightCount);
        	System.out.println("left childs: " + binaryTree.leftCount);
        	
        	for(int i=0;i<binaryTree.getOddNumberArray().length;i++){
        		System.out.println("Odd number: "+binaryTree.getOddNumberArray()[i]);
        		assertTrue(binaryTree.getOddNumberArray()[i] %2 !=0);
        		assertTrue(binaryTree.getOddNumberArray()[i] >=startRange && binaryTree.getOddNumberArray()[i] <=endRange);
        	}
        	
	}
}
