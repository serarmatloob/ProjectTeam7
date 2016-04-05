package edu.oakland.helper;


public class Node {

    private int key;
    private int data;
    private Node leftChild;
    private Node rightChild;
    
    public Node(int key, int data){
        this.key= key;
        this.data=data;
    }
    public Node(){
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
    public void setRightChild(Node rightNode){
    	this.rightChild=rightNode;
    }
    public void setLeftChild(Node leftNode){
    	this.leftChild=leftNode;
    }
     @Override
    public String toString(){
        return data +" has the key "+key;
    }
}
