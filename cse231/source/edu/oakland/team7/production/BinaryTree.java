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


	public void preorderTraverseTree(Node focusNode) {

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

				preorderTraverseTree(focusNode.getLeftChild());
			}

			if (oddNumberArray[oddNumberArraySize - 1] == 0) {
				
				preorderTraverseTree(focusNode.getRightChild());
			}
		}
	}


	public int[] getValue() {

		System.out.println();
		System.out.print("The odd numbers are: ");

		for (int num : oddNumberArray) {

			System.out.format("| %d ", num);
		}

		System.out.println();
		System.out.println();

		return oddNumberArray;
	}


	public Node getRoot() {

		return root;
	}
}