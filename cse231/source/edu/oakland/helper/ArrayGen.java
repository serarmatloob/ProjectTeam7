package edu.oakland.helper;
import java.util.*;

public class ArrayGen {

	private int arraySize;
	private int maxValue = 20000; // default value
	private int minValue = 20; // default value
	private int[] keyArray;
	private int[] dataArray;
	private Random random;

	public ArrayGen(int arraySize) {
		this.arraySize = arraySize;
		this.random = new Random();
	}

	public void createNodeKeys() {
		Integer next;
		Set<Integer> generated = new LinkedHashSet<Integer>();
		this.keyArray = new int[arraySize];
		int index = 0;

		while (generated.size() < arraySize) {

			next = random.nextInt(arraySize);
			generated.add(next);
		}
		for (Integer key : generated) {

			keyArray[index++] = key;
		}
	}

	public void createRandomDataArray() {

		this.dataArray = new int[arraySize];

		for (int i = 0; i < arraySize; i++) {

			this.dataArray[i] = random.nextInt(maxValue) + minValue;
		}

	}

	public void createEvenDataArray() {

		int[] evenArray = new int[arraySize];
		for(int i = 0; i<arraySize;i++){
			int number = random.nextInt(maxValue) + minValue;
			if(number %2 ==0){
				evenArray[i]=number;
			}
			else{
				evenArray[i]=number+1;
			}
		}
		dataArray = evenArray;
	}

	public void createOddDataArray() {

		int[] oddArray = new int[arraySize];
		for(int i = 0; i<arraySize;i++){
			int number = random.nextInt(maxValue) + minValue;
			if(number %2 !=0){
				oddArray[i]=number;
			}
			else{
				oddArray[i]=number+1;
			}
		}
		dataArray = oddArray;
	}

	public int[] getKeyArray() {

		return keyArray;
	}

	public int[] getDataArray() {

		return dataArray;
	}

	public void setMinValue(int minimum) {

		this.minValue = minimum;
	}

	public void setMaxValue(int maximum) {

		this.maxValue = maximum;
	}
}