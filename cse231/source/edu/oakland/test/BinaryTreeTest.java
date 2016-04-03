package edu.oakland.test;
import edu.oakland.production.*;
import edu.oakland.helper.*;
import java.util.ArrayList;
import java.util.Random;
import junit.framework.*; 


public class BinaryTreeTest extends TestCase{
	private BinaryTree binaryTree;
	private Node node;
	
	public void setUp(){
		node = new Node();
		int[] oddArray= new int[2];
		int startRange=900;
		int endRange=905;
		binaryTree = new BinaryTree(node, oddArray, startRange, endRange);
		
		Random random = new Random();
        	int size = 10000000;
        
        	ArrayList<Integer> list = new ArrayList<>();
        	for (int i = 0; i < size; i++) {
        		list.add(i);
        	}
        	long t1=System.currentTimeMillis();
        	int[] keys = new int[size];
        	for (int i = 0; i < size; i++) {
        		//keys[i] = list.remove((int) (Math.random() * list.size()));
        		keys[i]=20+(int)(Math.random()*((4000000-20)+1));
        	}
        	
        	int[] data = new int[size];
        	for (int i = 0; i < data.length; i++) {
        		//int number = random.nextInt(200000);
        		//data[i] = number;
        		data[i]=20+(int)(Math.random()*((4000000-20)+1));
        	}

        	for (int i = 0; i < keys.length; i++) {
        		binaryTree.addNode(keys[i], data[i]);
        	}
        	long t2=System.currentTimeMillis();
        	
        	System.out.println("Time took to create and build arrays: "+(t2-t1));

        	
	}
	public void testBinaryTree(){
		int startRange=900;
		int endRange=905;
		//startTime = System.currentTimeMillis();
        	binaryTree.searchOdd();
        	//endTime = System.currentTimeMillis();
        	
        	System.out.println("Time took to search: " + binaryTree.getTime());
        	System.out.println("right childs: " + binaryTree.rightCount);
        	System.out.println("left childs: " + binaryTree.leftCount);
        	
        	for(int i=0;i<binaryTree.getOddNumberArray().length;i++){
        		System.out.println("Odd number: "+binaryTree.getOddNumberArray()[i]);
        		assertTrue(binaryTree.getOddNumberArray()[i] %2 !=0);
        		assertTrue(binaryTree.getOddNumberArray()[i] >=startRange && binaryTree.getOddNumberArray()[i] <=endRange);
        	}
        	
	}
}
