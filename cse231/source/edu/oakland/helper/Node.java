package edu.oakland.helper;

/**
 *
 * @author Serar
 */
public class Node {

    private int key;
    private int data;
    private Node leftChild;
    private Node rightChild;
    
    public Node(int key, int data){
        this.key= key;
        this.data=data;
    }
    public int getKey(){
    	return key;
    }
    public int getData(){
        return data;
    }
    public Node getLeftChild(){
    	return leftChild;
    }
    public Node getRightChild(){
    	return rightChild;
    }
    public void setRightChild(Node leftNode){
    	this.leftChild=leftNode;
    }
    public void setLeftChild(Node rightNode){
    	this.rightChild=rightNode;
    }
     @Override
    public String toString(){
        return data +" Which has the key "+key;
    }
}
