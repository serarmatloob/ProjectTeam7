
package edu.oakland.production;
import edu.oakland.helper.*;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Serar
 */
public class BinaryTree {

     private Node root;
     private int integers;
     private int[] oddNumberArray;
     private int oddNumber;
     private int startRange;
     private int endRange;
     public int leftCount;
     public int rightCount;
     private long startTime,endTime;

    public BinaryTree(Node node, int[] oddNumberArray, int startRange, int endRange){
    	this.root = node;
    	this.oddNumberArray=oddNumberArray;
    	this.startRange=startRange;
    	this.endRange=endRange;
    }
    public BinaryTree(){
    }
    public Node getRoot(){
    	return root;
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
    	preorderTraverseTree2(root);
        endTime = System.currentTimeMillis();
    }
    public void preorderTraverseTree2(Node focusNode) {
    		//rightCount++;
        //System.out.println("Entered preorder function");
        if (focusNode != null) {
            if(focusNode.getRightChild()!=null){
               rightCount++;
            }
            if(focusNode.getLeftChild()!=null){
                leftCount++;
            }

            if (focusNode.getData() % 2 == 1) {

                oddNumber = focusNode.getData();

                if (oddNumber >= startRange && oddNumber <= endRange) {
                	
                	integers++;

                    for (int i = 0; i < oddNumberArray.length; i++) {

                        if (oddNumberArray[i] == 0) {

                            oddNumberArray[i] = oddNumber;
                            break;
                        }
                    }
                }
            }
            if(integers<oddNumberArray.length){
            	preorderTraverseTree2(focusNode.getLeftChild());
            }
            if(integers<oddNumberArray.length){
            	preorderTraverseTree2(focusNode.getRightChild());
            }
        }
    }
    
 /* public void preorderTraverseTree(Node focusNode) {
         rightCount++;
        //System.out.println("Entered preorder function");
        if (focusNode != null) {
            if (focusNode.getRightChild() != null && integers<2) {
                //rightCount++;
                 if(focusNode.getRightChild().getData() % 2 != 0) {
                    System.out.println(focusNode.getRightChild());
                    integers++;
                }
            }
            if (focusNode.getLeftChild() != null && integers<2) {
                //leftCount++;
                if (focusNode.getLeftChild().getData() % 2 != 0) {
                    System.out.println(focusNode.getLeftChild());
                    integers++;
                }
            }
            preorderTraverseTree(focusNode.getLeftChild());
            preorderTraverseTree(focusNode.getRightChild());
        }
    }  */
    public int[] getOddNumberArray(){
    	return oddNumberArray;
    }
    public long getTime(){
    	//System.out.println(endTime+"   "+startTime);
    	return (endTime-startTime);
    }
}

