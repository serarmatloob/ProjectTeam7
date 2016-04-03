
package edu.oakland.helper;
/**
 *
 * @author Serar
 */
public class ArrayGen {
    private int[] intArray;
    public int[] createArray(int number) {
         intArray = new int[number];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i]=i+1;
        }
        return intArray;
    }
}
