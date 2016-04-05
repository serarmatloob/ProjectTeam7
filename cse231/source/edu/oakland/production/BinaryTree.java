
package edu.oakland.production;
import edu.oakland.helper.*;
import java.util.*;


public class BinaryTree {

     private Node root;
     private int[] keyArray, dataArray;
     private int integers;
     private int[] oddNumberArray;
     private int oddNumberToReturn = 2;
     private int oddNumber;
     private int startRange = 900; 
     private int endRange = 9000; 
     private long startTime,endTime;

    public BinaryTree(int[] keyArray, int[] dataArray){
    	this.keyArray = keyArray;
	this.dataArray = dataArray;
	oddNumberArray = new int[oddNumberToReturn];
	Arrays.fill(oddNumberArray, -1);
	buildBinaryTree();
    }
    public void buildBinaryTree() {
		for (int i = 0; i < keyArray.length; i++) {
			addNode(keyArray[i], dataArray[i]);
		}
	}

    public void addNode(int key, int data) {
        Node newNode = new Node(key, data);
        if (root == null) {
            root = newNode;
        } else {
            Node focusNode = root;
            Node parent;
            while (true) {
                parent = focusNode;
                if (key < focusNode.getKey()) {
                    focusNode = focusNode.getLeftChild();
                    if (focusNode == null) {
                        parent.setLeftChild(newNode) ;
                        return;
                    }

                } else {
                    focusNode = focusNode.getRightChild();
                    if (focusNode == null) {
                        parent.setRightChild(newNode);
                        return;
                    }
                }
            }

        }
    }
    public void searchOdd(){
    	startTime = System.currentTimeMillis();
    	preorderTraverseTree(root);
        endTime = System.currentTimeMillis();
    }
    public void preorderTraverseTree(Node focusNode) {

        if (focusNode != null) {

            if (focusNode.getData() % 2 !=0) {

                oddNumber = focusNode.getData();

                if (oddNumber >= startRange && oddNumber <= endRange) {
                	
                	integers++;

                    for (int i = 0; i < oddNumberArray.length; i++) {

                        if (oddNumberArray[i] == -1) {

                            oddNumberArray[i] = oddNumber;
                            break;
                        }
                    }
                }
            }
            if(integers<oddNumberArray.length){
            	preorderTraverseTree(focusNode.getLeftChild());
            }
            if(integers<oddNumberArray.length){
            	preorderTraverseTree(focusNode.getRightChild());
            }
        }
    }

    public int[] getOddNumberArray(){
    	return oddNumberArray;
    }
    public long getTime(){
    	return (endTime-startTime);
    }
    public Node getRoot(){
    	return root;
    }
}

