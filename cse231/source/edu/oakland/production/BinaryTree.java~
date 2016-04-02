
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
    int leftCount;
    int rightCount;
    int integers;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BinaryTree theTree = new BinaryTree();
        Random random = new Random();
        long startTime;
        long endTime;
        int size = 20000;
        
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        
        int[] keys = new int[size];
        for (int i = 0; i < size; i++) {
            keys[i] = list.remove((int) (Math.random() * list.size()));
        }
        int[] data = new int[size];
        for (int i = 0; i < data.length; i++) {
            int number = random.nextInt(1000);
            data[i] = number;
        }

        for (int i = 0; i < keys.length; i++) {
            theTree.addNode(keys[i], data[i]);
        }

        startTime = System.currentTimeMillis();
        theTree.preorderTraverseTree(theTree.root);
        endTime = System.currentTimeMillis();
        System.out.println("Time took: " + (endTime - startTime));
        System.out.println("right childs: " + theTree.rightCount);
        System.out.println("left childs: " + theTree.leftCount);
    }

    private void addNode(int key, int name) {
        Node newNode = new Node(key, name);
        if (root == null) {
            root = newNode;
        } else {
            Node focusNode = root;
            Node parent;
            while (true) {
                parent = focusNode;
                if (key < focusNode.key) {
                    focusNode = focusNode.leftChild;
                    if (focusNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }

                } else {
                    focusNode = focusNode.rightChild;
                    if (focusNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }

        }
    }

private void preorderTraverseTree(Node focusNode) {
         
        //System.out.println("Entered preorder function");
        if (focusNode != null) {
            if (focusNode.rightChild != null && integers<2) {
                rightCount++;
                 if(focusNode.rightChild.value % 2 != 0) {
                    System.out.println(focusNode.rightChild);
                    integers++;
                }
            }
            if (focusNode.leftChild != null && integers<2) {
                leftCount++;
                if (focusNode.leftChild.value % 2 != 0) {
                    System.out.println(focusNode.leftChild);
                    integers++;
                }
            }
            preorderTraverseTree(focusNode.leftChild);
            preorderTraverseTree(focusNode.rightChild);
        }
    }
}

