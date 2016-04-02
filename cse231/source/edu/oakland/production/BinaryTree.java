
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
    private int leftCount;
    private int rightCount;
    private int integers;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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

private void preorderTraverseTree(Node focusNode) {
         
        //System.out.println("Entered preorder function");
        if (focusNode != null) {
            if (focusNode.getRightChild() != null && integers<2) {
                rightCount++;
                 if(focusNode.getRightChild().getData() % 2 != 0) {
                    System.out.println(focusNode.getRightChild());
                    integers++;
                }
            }
            if (focusNode.getLeftChild() != null && integers<2) {
                leftCount++;
                if (focusNode.getLeftChild().getData() % 2 != 0) {
                    System.out.println(focusNode.getLeftChild());
                    integers++;
                }
            }
            preorderTraverseTree(focusNode.getLeftChild());
            preorderTraverseTree(focusNode.getRightChild());
        }
    }
}

