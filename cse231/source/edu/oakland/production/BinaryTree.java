
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
     private ArrayList<Integer> arrayList;

    public BinaryTree(int[] keyArray, int[] dataArray){
    	this.keyArray = keyArray;
	this.dataArray = dataArray;
	oddNumberArray = new int[oddNumberToReturn];
	Arrays.fill(oddNumberArray, -1);
	this.arrayList = new ArrayList<>();
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
    	startTime = System.nanoTime();
    	preorderTraverseTree(root);
        endTime = System.nanoTime();
    }
    public void preorderTraverseTree(Node focusNode) {

        if (focusNode != null) {

            if (focusNode.getData() % 2 !=0) {

                oddNumber = focusNode.getData();

                if (oddNumber >= startRange && oddNumber <= endRange) {
                	integers++;
                	arrayList.add(oddNumber);
                }
            }
            if(integers<oddNumberToReturn){
            	preorderTraverseTree(focusNode.getLeftChild());
            }
            if(integers<oddNumberToReturn){
            	preorderTraverseTree(focusNode.getRightChild());
            }
        }
    }

    public int[] getOddNumberArray(){
    	int index=0;
    
    	//for(Integer number: arrayList){
    	//	oddNumberArray[index++]=number;
    	//}
    	
    	for(int i=0;i<arrayList.size();i++){
    		if( arrayList.get(i)!=null){
    			oddNumberArray[i] = arrayList.get(i);
    		}
    		
    	}
    	
    	return oddNumberArray;
    }
    public long getTime(){
    	return (endTime-startTime);
    }
    public Node getRoot(){
    	return root;
    }
}

