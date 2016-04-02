/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary;

/**
 *
 * @author Serar
 */
class Node {

    int key;
    int value;
    String name;
    Node leftChild;
    Node rightChild;
    
    Node(int intKey, int stringName){
        this.key= intKey;
        this.value=stringName;
        //this.name = stringName;
    }
    @Override
    public String toString(){
        return value +" has the key "+key;
    }
    public int getValue(){
        return value;
    }
    
}
