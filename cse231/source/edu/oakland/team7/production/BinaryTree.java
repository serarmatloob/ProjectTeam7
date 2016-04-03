package edu.oakland.team7.production;
import edu.oakland.team7.helper.*;
import java.lang.*;


public class BinaryTree {

	private int[] keyArray, dataArray;
	private int[] oddNumberArray;
	private int oddNumberArraySize = 2; // size represents how many odd numbers to find
	private int startRange = 900; // start of range for the value an odd number must have
	private int endRange = 905; // end of range for the value an odd number must have
	private int oddNumber;
	private Node root;
	private long startTime;
	private long endTime;

	public BinaryTree(int[] keyArray, int[] dataArray) {

		this.keyArray = keyArray;
		this.dataArray = dataArray;

		oddNumberArray = new int[oddNumberArraySize];

		buildBinaryTree();
		traverseTree();
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

		if (focusNode != null && oddNumberArray[oddNumberArraySize -1] == 0) {

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

			if (oddNumberArray[oddNumberArraySize - 1] == 0) {

				preOrderTraverseTree(focusNode.getLeftChild());
			}

			if (oddNumberArray[oddNumberArraySize - 1] == 0) {
				
				preOrderTraverseTree(focusNode.getRightChild());
			}
		}
	}

	public void inOrderTraverseTree(Node focusNode) {

		if (focusNode != null && oddNumberArray[oddNumberArraySize -1] == 0) {

			if (oddNumberArray[oddNumberArraySize - 1] == 0) {

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

			if (oddNumberArray[oddNumberArraySize - 1] == 0) {

				inOrderTraverseTree(focusNode.getRightChild());
			}
		}
	}

	public void postOrderTraverseTree(Node focusNode) {

		if (focusNode != null && oddNumberArray[oddNumberArraySize -1] == 0) {

			if (oddNumberArray[oddNumberArraySize - 1] == 0) {

				postOrderTraverseTree(focusNode.getLeftChild());
			}

			if (oddNumberArray[oddNumberArraySize - 1] == 0) {

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

		return (endTime - startTime);
	}

	public void traverseTree() {

		System.out.println("This is using IN-order traversal to find the odd numbers.");
		System.out.println();
		System.out.println("The size of random array is: 10,000,000");
		System.out.println("The range of possible random numbers generated in array is: 20 to 4,000,000");
		System.out.println("The range of numbers that we are looking for that contain odd ints is: 900 to 905");
		System.out.println();


		startTime = System.currentTimeMillis();
		inOrderTraverseTree(root);
		// postOrderTraverseTree(root);
		// preOrderTraverseTree(root);
		endTime = System.currentTimeMillis();
	}
}