package edu.oakland.helper;

/**
 *
 * @author Serar
 */
public class Node {

    public int key;
    public int value;
    public Node leftChild;
    public Node rightChild;
    
    public Node(int key, int value){
        this.key= key;
        this.value=value;
    }
    @Override
    public String toString(){
        return value +" has the key "+key;
    }
    public int getValue(){
        return value;
    }
    
}
