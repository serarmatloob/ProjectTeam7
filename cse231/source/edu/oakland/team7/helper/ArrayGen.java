package edu.oakland.team7.helper;
import java.util.*;

public class ArrayGen {


	private int arraySize;
	private int maxValue = 50000; // default value
	private int minValue = 0; // default value 
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
			// As we're adding to a set, this will automatically do a containment check
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

    	Integer next;
		Set<Integer> generated = new LinkedHashSet<Integer>();
		this.dataArray = new int[arraySize];
		int index = 0;

		while (generated.size() < arraySize) {

			next = random.nextInt(maxValue) + minValue;
			
			if (next % 2 == 0) {

				generated.add(next);
			}
		}

		for (Integer data : generated) {

			dataArray[index++] = data;
		}
    }


    public void createOddDataArray() {

    	Integer next;
		Set<Integer> generated = new LinkedHashSet<Integer>();
		this.dataArray = new int[arraySize];
		int index = 0;

		while (generated.size() < arraySize) {

			next = random.nextInt(maxValue) + minValue;
			
			if (next % 2 == 1) {

				generated.add(next);
			}
		}

		for (Integer data : generated) {

			dataArray[index++] = data;
		}
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

