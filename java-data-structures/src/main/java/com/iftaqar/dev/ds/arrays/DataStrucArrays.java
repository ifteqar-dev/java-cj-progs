package com.iftaqar.dev.ds.arrays;

public class DataStrucArrays {

	public static void main(String[] args) {
		int[] intArray = new int[7];

		intArray[0] = 20;
		intArray[1] = 30;
		intArray[2] = 40;
		intArray[3] = 50;
		intArray[4] = 60;
		intArray[5] = 70;
		intArray[6] = 80;
		
		int index = -1;
		for (int i = 0; i < intArray.length; i++) {
			// System.out.println(intArray[i]);
			if(intArray[i] == 50) {
				index = i;
				break;
			}
		}
		
		System.out.println("Index Value for 50: "+index);
		
		
	}

}
