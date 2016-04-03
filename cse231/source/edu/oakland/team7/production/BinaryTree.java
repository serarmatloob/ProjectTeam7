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


	public BinaryTree(int[] keyArray, int[] dataArray) {

		this.keyArray = keyArray;
		this.dataArray = dataArray;

		oddNumberArray = new int[oddNumberToReturn];

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

		if (focusNode != null && oddNumberArray[oddNumberToReturn -1] == 0) {

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

			if (oddNumberArray[oddNumberToReturn - 1] == 0) {

				preOrderTraverseTree(focusNode.getLeftChild());
			}

			if (oddNumberArray[oddNumberToReturn - 1] == 0) {
				
				preOrderTraverseTree(focusNode.getRightChild());
			}
		}
	}


	public void inOrderTraverseTree(Node focusNode) {

		if (focusNode != null && oddNumberArray[oddNumberToReturn -1] == 0) {

			if (oddNumberArray[oddNumberToReturn - 1] == 0) {

				inOrderTraverseTree(focusNode.getLeftChild());
			}

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

			if (oddNumberArray[oddNumberToReturn - 1] == 0) {

				inOrderTraverseTree(focusNode.getRightChild());
			}
		}
	}


	public void postOrderTraverseTree(Node focusNode) {

		if (focusNode != null && oddNumberArray[oddNumberToReturn -1] == 0) {

			if (oddNumberArray[oddNumberToReturn - 1] == 0) {

				postOrderTraverseTree(focusNode.getLeftChild());
			}

			if (oddNumberArray[oddNumberToReturn - 1] == 0) {

				postOrderTraverseTree(focusNode.getRightChild());
			}

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
		}
	}


	public int[] getValue() {

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

		Arrays.fill(oddNumberArray, 0);

		startTimeNano = System.nanoTime();

		inOrderTraverseTree(root);

		endTimeNano = System.nanoTime();
	}


	public void findOddPostOrder() {

		Arrays.fill(oddNumberArray, 0);

		startTimeNano = System.nanoTime();

		postOrderTraverseTree(root);

		endTimeNano = System.nanoTime();
	}
}