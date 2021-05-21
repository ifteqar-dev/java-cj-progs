package com.iftaqar.dev.ds.algs.sort;

public class BubbleSort {

	public static void main(String[] args) {

		int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

		// 1. Get the size of an array
		// 2. In an outer for loop, we will traverse from left to right
		// 3. In an inner for loop, we will check the elements
		for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
			for (int i = 0; i < lastUnsortedIndex; i++) {

				if (intArray[i] > intArray[i + 1]) {
					swap(intArray, i, i + 1);
				}
			}
		}

		System.out.println("Array is Sorted Using Bubble Sort:");
		for (int i = 0; i < intArray.length - 1; i++) {
			System.out.println(intArray[i]);
		}
	}

	public static void swap(int[] array, int i, int j) {
		if (i == j) {
			return;
		}

		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
