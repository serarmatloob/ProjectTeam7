package edu.oakland.team7.helper;


public class Node {	

    private int key;
    private int data;
    private Node leftChild;
    private Node rightChild;


    public Node(int key, int data) {

        this.key = key;
        this.data = data;

    }
    

    public String toString() {

        return data + " has the key " + key;

    }
    

    public int getKey() {

        return key;

    }
    

    public int getData() {

        return data;

    }
    

    public Node getLeftChild() {

        return leftChild;

    }
    

    public Node getRightChild() {

        return rightChild;

    }
    

    public void setLeftChild(Node newNode) {

        this.leftChild = newNode;

    }
    

    public void setRightChild(Node newNode) {

        this.rightChild = newNode;

    }

    
}
