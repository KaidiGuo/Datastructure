import java.util.Random;
import java.util.Scanner;

public class mergeSort {
	public static void doMergeSort(int[] inputArray, int leftIndex, int rightIndex) {
		if (inputArray.length >= 10) {
			if (leftIndex < rightIndex) {
				int mediumIndex = (leftIndex + rightIndex) / 2;
				int sizeOfFirstArray = mediumIndex - leftIndex + 1;
				int sizeOfSecondArray = rightIndex - mediumIndex;

				int[] firstArray = new int [sizeOfFirstArray];
				int[] secondArray = new int [sizeOfSecondArray];

				for (int i = 0; i < sizeOfFirstArray; i++) {
					firstArray[i] = inputArray[leftIndex + i];
				}

				for (int j = 0; j < sizeOfSecondArray; j++) {
					secondArray[j] = inputArray[mediumIndex + 1 + j];
				}

				if (sizeOfFirstArray <= 10) {
					doInsertionSort(firstArray, sizeOfFirstArray);
				} else {
					doMergeSort(firstArray, 0, sizeOfFirstArray-1);
				}

				if (sizeOfSecondArray <= 10) {
					doInsertionSort(secondArray, sizeOfSecondArray);
				} else {
					doMergeSort(secondArray, 0, sizeOfSecondArray-1);
				}

				mergeArrays(inputArray, leftIndex, mediumIndex, rightIndex, sizeOfFirstArray, sizeOfSecondArray, firstArray, secondArray);
			}
		}
	}

	public static void mergeArrays(int[] inputArray, int leftIndex, int mediumIndex, int rightIndex, int sizeOfFirstArray, int sizeOfSecondArray, int[] firstArray, int[] secondArray) {

		int temp1 = 0, temp2 = 0;
		int keyElement = leftIndex;

		while (temp1 < sizeOfFirstArray && temp2 < sizeOfSecondArray) {
			if (firstArray[temp1] <= secondArray[temp2]) {
				inputArray[keyElement] = firstArray[temp1];
				temp1++;
			} else {
				inputArray[keyElement] = secondArray[temp2];
				temp2++;
			}
			keyElement++;
		}

		while (temp1 < sizeOfFirstArray) {
			inputArray[keyElement] = firstArray[temp1];
			temp1++;
			keyElement++;
		}

		while (temp2 < sizeOfSecondArray) {
			inputArray[keyElement] = secondArray[temp2];
			temp2++;
			keyElement++;
		}
	}

	/**
	 * Function to perform Insertion Sort
	 * This method is invoked when the number of input elements is less than 10
	 *
	 * @param  - Array whose element needs to be sorted through 'Insertion Sort'
	 */

	public static void doInsertionSort(int[] inputArray, int numberOfInputElements) {
		for (int i = 1; i < numberOfInputElements; i++) {
			int key = inputArray[i];
			int j = i-1;
			while ((j > -1) && (inputArray[j] > key)) {
				inputArray[j+1] = inputArray[j];
				j--;
			}
			inputArray[j+1] = key;
		}
	}
}