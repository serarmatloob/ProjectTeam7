package edu.oakland.team7.production;
import edu.oakland.team7.helper.*;
import java.lang.*;
import java.util.*;


public class BinaryTree {


	private int[] keyArray, dataArray;
	private int[] oddNumberArray;
	private int oddNumberToReturn = 2; // size represents how many odd numbers to find
	private int startRange = 900; // start of range for the value an odd number must have
	private int endRange = 9000; // end of range for the value an odd number must have
	private int oddNumber;
	private Node root;
	private long startTimeNano;
	private long endTimeNano;
	private ArrayList<Integer> arrayList;


	public BinaryTree(int[] keyArray, int[] dataArray) {

		this.keyArray = keyArray;
		this.dataArray = dataArray;

		oddNumberArray = new int[oddNumberToReturn];
		Arrays.fill(oddNumberArray, -1);

		arrayList = new ArrayList<Integer>(); // initilized its initial cappacity
		
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
		}

		else {

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
				}

				else {

					focusNode = focusNode.getRightChild();

					if (focusNode == null) {

						parent.setRightChild(newNode);
						return;
					}
				}
			}
		}
	}



	public void preOrderTraverseTree(Node focusNode) {

		if (focusNode != null && arrayList.size() < oddNumberToReturn) {

			if (focusNode.getData() % 2 == 1 && arrayList.size() < oddNumberToReturn) {

				oddNumber = focusNode.getData();

				if (oddNumber >= startRange && oddNumber <= endRange) {

					arrayList.add(oddNumber);
				}
			}

			if (arrayList.size() < oddNumberToReturn) {

				preOrderTraverseTree(focusNode.getLeftChild());
			}

			if (arrayList.size() < oddNumberToReturn) {
				
				preOrderTraverseTree(focusNode.getRightChild());
			}
		}
	}

	
	public void inOrderTraverseTree(Node focusNode) {

		if (focusNode != null && arrayList.size() < oddNumberToReturn) {

			if (arrayList.size() < oddNumberToReturn) {

				preOrderTraverseTree(focusNode.getLeftChild());
			}

			if (focusNode.getData() % 2 == 1 && arrayList.size() < oddNumberToReturn) { 

				oddNumber = focusNode.getData();

				if (oddNumber >= startRange && oddNumber <= endRange) {

					arrayList.add(oddNumber);
				}
			}

			if (arrayList.size() < oddNumberToReturn) {

				preOrderTraverseTree(focusNode.getRightChild());
			}
		}
	}


	public void postOrderTraverseTree(Node focusNode) {

		if (focusNode != null && arrayList.size() < oddNumberToReturn) {

			if (arrayList.size() < oddNumberToReturn) {

				preOrderTraverseTree(focusNode.getLeftChild());
			}

			if (arrayList.size() < oddNumberToReturn) {

				preOrderTraverseTree(focusNode.getRightChild());
			}

			if (focusNode.getData() % 2 == 1 && arrayList.size() < oddNumberToReturn) {

				oddNumber = focusNode.getData();

				if (oddNumber >= startRange && oddNumber <= endRange) {

					arrayList.add(oddNumber);
				}
			}
		}
	}
	


	public int[] getValue() {

		int index = 0;

		for (Integer number : arrayList) {

			oddNumberArray[index++] = number;
		}

		return oddNumberArray;
	}


	public Node getRoot() {

		return root;
	}


	public long getTime() {

		return (endTimeNano - startTimeNano);
	}


	public void findOdd() {

		startTimeNano = System.nanoTime();

		preOrderTraverseTree(root);

		endTimeNano = System.nanoTime();
	}

	
	public void findOddInOrder() {

		Arrays.fill(oddNumberArray, -1);
		arrayList.clear();

		startTimeNano = System.nanoTime();

		inOrderTraverseTree(root);

		endTimeNano = System.nanoTime();
	}


	public void findOddPostOrder() {

		Arrays.fill(oddNumberArray, -1);
		arrayList.clear();

		startTimeNano = System.nanoTime();

		postOrderTraverseTree(root);

		endTimeNano = System.nanoTime();
	}
	
}