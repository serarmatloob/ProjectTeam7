package edu.oakland.team7.test;
import edu.oakland.team7.production.*;
import junit.framework.*;

public class BinaryTreeTest extends TestCase {

    private int arraySize = 20;
    private int[] keyArray;
    private int[] dataArray;
    private BinaryTree binaryTree;
    private boolean isOddInRange;
    
    
	public void setUp() {
		
		// Build random Array for test
        keyArray = new int[arraySize];
        dataArray = new int[arraySize];
        
        for (int i = 0; i < arraySize; i++) {
        	
        	// Min + (int)(Math.random() * ((Max - Min) + 1))
            keyArray[i] = arraySize + (int)(Math.random() * (((arraySize * 2) + arraySize) + 1));
            dataArray[i] = 20 + (int)(Math.random() * ((20000 - 20) + 1));
            
        }
        
        System.out.println();
        
        
        // Print out currently used array
        System.out.println("Keys:");
        for (int num : keyArray) {
        	
            System.out.format("| %d | ", num);
            
        }
        
        System.out.println();
        System.out.println();
        
        System.out.println("Data:");
        for (int num : dataArray) {
        	
            System.out.format("| %d | ", num);
            
        }
        
        System.out.println();
        System.out.println();
        
        binaryTree = new BinaryTree(keyArray, dataArray);
        
	}
	
	
	
	public void testBinaryTree() {
		
		// Uncomment whichever section you want to use for test
		
		// This is the actual binary tree returning an array
		binaryTree.preorderTraverseTree(binaryTree.getRoot());
        int[] oddNumberArray = binaryTree.getOddNumberArray();
        
        
        // This array will fail because the 1st number is even
        // System.out.println("This is a test. Above Arrays are not in use");
        // int[] oddNumberArray = {900, 8651};
        
        
        // This array will fail because the 2nd number is even
        // System.out.println("This is a test. Above Arrays are not in use");
        // int[] oddNumberArray = {4973, 7322};
        
        
        // This array will fail because the 1st number is out of range
        // System.out.println("This is a test. Above Arrays are not in use");
        // int[] oddNumberArray = {899, 1061};
        
        
        // This array will fail because the 2nd number is out of range
        // System.out.println("This is a test. Above Arrays are not in use");
        // int[] oddNumberArray = {8999, 45};
        
        
        // This array will pass because both values are odd and within range
        // System.out.println("This is a test. Above Arrays are not in use");
        // int[] oddNumberArray = {901, 8999};
        
        
        // finding out if oddNumberArray contains odd ints within given range
        for (int num : oddNumberArray) {
        	
        	if (num % 2 == 1) {
        		
        		if (num >= 900 && num <= 9000) {
        			
        			isOddInRange = true;
        			
        		} else {
        			
        			isOddInRange = false;
        			break;
        			
        		}
        		
        	} else {
        		
        		isOddInRange = false;
        		break;
        		
        	}
        	
        }
		
        assertTrue(isOddInRange);
        
	}
}