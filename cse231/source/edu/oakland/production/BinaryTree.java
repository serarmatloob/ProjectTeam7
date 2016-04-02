/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary;

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
    //static int[] numbers={50,51,53,42,57,34,81,71};
    //static int[] array={7,3,9,1,2,11,4,5};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BinaryTree theTree = new BinaryTree();
        Random random = new Random();
        long startTime;
        long endTime;
        //numbers= new int[20];
        int size = 20000;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        
        int[] a = new int[size];
        for (int count = 0; count < size; count++) {
            a[count] = list.remove((int) (Math.random() * list.size()));
        }
        int[] numbers = new int[size];
        for (int i = 0; i < numbers.length; i++) {
            int number = random.nextInt(1000);
            numbers[i] = number;
        }
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = a[i];
        }

        ArrayGen arrayGen = new ArrayGen();
        //array = arrayGen.createArray(6000);
        //int[] array = {1,4,3};
        //String[] stringArray ={"one", "two", "three"};
        for (int i = 0; i < array.length; i++) {
            theTree.addNode(array[i], numbers[i]);
        }

        //theTree.addNode(25, "Vice President");
        //theTree.addNode(75, "Sales Manager");
        //theTree.preorderTraverseTree(theTree.root);
            theTree.integers=0;
        startTime = System.currentTimeMillis();
        //theTree.findOdd();
        theTree.preorderTraverseTree2(theTree.root);
        endTime = System.currentTimeMillis();
        //System.out.println("Time took: "+(endTime)+"::"+(startTime));
        System.out.println("Time took: " + (endTime - startTime));
        //System.out.println("node is " + theTree.findNode(100));
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
            //System.out.println(focusNode);
            //int val = focusNode.leftChild.;
            if (focusNode.rightChild != null) {
                rightCount++;
                 if(focusNode.rightChild.value % 2 != 0) {
//                    //System.out.println(focusNode.rightChild.value);
//                    //System.out.println("Checking right child");
                    System.out.println(focusNode.rightChild);
                }
            }
            if (focusNode.leftChild != null) {
                leftCount++;
//                //System.out.println(focusNode.leftChild.key);
                if (focusNode.leftChild.value % 2 != 0) {
//                    //System.out.println("Checking left child");
                    System.out.println(focusNode.leftChild);
            }
            }
            preorderTraverseTree(focusNode.leftChild);
            preorderTraverseTree(focusNode.rightChild);
        }
    }
private void preorderTraverseTree2(Node focusNode) {
         
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
            preorderTraverseTree2(focusNode.leftChild);
            preorderTraverseTree2(focusNode.rightChild);
        }
    }

//    private Node findNode(int key) {
//        Node focusNode = root;
//        while (focusNode.key != key) {
//            if (key < focusNode.key) {
//                focusNode = focusNode.leftChild;
//            } else {
//                focusNode = focusNode.rightChild;
//            }
//            if (focusNode == null) {
//                //System.out.println("Returning null");
//                return null;
//            }
//        }
//        return focusNode;
//    }
//
//    private void findOdd() {
//        Node focusNode = root;
////        if (focusNode != null) {
////            //System.out.println(focusNode);
////            //int val = focusNode.leftChild.;
////            if (focusNode.rightChild != null) {
////                rightCount++;
////                if (focusNode.rightChild.value % 2 != 0) {
////                    //System.out.println(focusNode.rightChild.value);
////                    //System.out.println("Checking right child");
////                    System.out.println(focusNode.rightChild);
////                }
////            }
////            if (focusNode.leftChild != null) {
////                leftCount++;
////                //System.out.println(focusNode.leftChild.key);
////                if (focusNode.leftChild.value % 2 != 0) {
////                    //System.out.println("Checking left child");
////                    System.out.println(focusNode.leftChild);
////                }
////            }
////        }
//        int odds = 0;
//        while (odds < 3) {
//            
//            if (focusNode != null) {
//                //System.out.println("oddddddds are : "+odds);
//                if (focusNode.rightChild != null) {
//                    if (focusNode.rightChild.value % 2 != 0) {
//                        //focusNode = focusNode.rightChild;
//                        System.out.println(focusNode.rightChild.value);
//                        //focusNode = focusNode.leftChild;
//                        //System.out.println(focusNode.value);
//                        //;
//                        odds++;
//                         //return;
//                    }
//                    //return;
//                    
////            if (key < focusNode.key) {
////                focusNode = focusNode.leftChild;
////            } else {
////                focusNode = focusNode.rightChild;
////            }
////            if (focusNode == null) {
////                //System.out.println("Returning null");
////                return null;
////            }
//                }
//                if (focusNode.leftChild != null) {
//                    //System.out.println(focusNode.leftChild.key);
//                    if (focusNode.leftChild.value % 2 != 0) {
//                        //System.out.println("Checking left child");
//                        System.out.println(focusNode.leftChild.value);
//                        odds++;
//                       // return;
//                    }
//                }
//                preorderTraverseTree(focusNode.leftChild);
//                preorderTraverseTree(focusNode.rightChild);
//            }
//            
//        }
//
//    }
}

