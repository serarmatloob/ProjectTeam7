package edu.oakland.team7.production;

import edu.oakland.team7.helper.*;

public class BinaryTree {


    private int[] keyArray, dataArray;
    private int[] oddNumberArray;
    private int oddNumberArraySize = 2; // size represents how many odd numbers to find
    private int startRange = 900; // start of range for the value an odd number must have
    private int endRange = 9000; // end of range for the value an odd number must have
    private int oddNumber;
    private Node root;


    public BinaryTree(int[] keyArray, int[] dataArray) {

        this.keyArray = keyArray;
        this.dataArray = dataArray;

        oddNumberArray = new int[oddNumberArraySize];

        buildBinaryTree();
        findOddNumbers(root);
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

                        parent.setLeftChild(newNode);
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


    public void findOddNumbers(Node focusNode) {

        if (focusNode != null) {

            if (focusNode.getData() % 2 == 1) {

                oddNumber = focusNode.getData();

                if (oddNumber >= startRange && oddNumber <= endRange) {

                    for (int i = 0; i < oddNumberArray.length; i++) {

                        if (oddNumberArray[i] == 0) {

                            oddNumberArray[i] = oddNumber;
                            break;
                        }
                    }
                }
            }

            findOddNumbers(focusNode.getLeftChild());
            findOddNumbers(focusNode.getRightChild());
        }
    }


    public int[] getOddNumberArray() {

        return oddNumberArray;
    }
}
