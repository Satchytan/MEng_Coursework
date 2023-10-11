package assignment1;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.io.FileReader;

public class a1 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// Prompt user for input of file name to analyze
		System.out.print("Enter the file name: ");
		String fileName = scanner.nextLine();
		
		// Read file contents to a String
		String content = readFileContent(fileName);
		
		// Prompt user for input of search key
		System.out.print("Enter the search key: ");
		int searchKey = scanner.nextInt();
		
		// Compute the frequency of each character in text
		Map<Character, Integer> frequencyMap = computeCharacterFrequency(content);
		
		// Display the characters and their frequencies
		System.out.println("Character Frequencies: ");
		for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
		
		// Create an integer array with the frequencies
		int[] frequencies = new int[frequencyMap.size()];
		int index = 0;
		for (int frequency : frequencyMap.values()) {
			frequencies[index++] = frequency;
		}
		
		// Sort the array and display it
		mergeSort(frequencies, 0, frequencies.length - 1);
		System.out.println("Sorted array of frequencies: " + Arrays.toString(frequencies));
		
		// Use binary search on sorted array to find key
		int searchResult = binarySearch(frequencies, searchKey);
		
		// Show the search results
		if (searchResult != -1) {
			System.out.println("Search key FOUND at index " + searchResult);
		} else {
			System.out.println("Search key NOT FOUND");
		}
		
		scanner.close();
		
	}
	
	public static String readFileContent(String fileName) {
		StringBuilder contentBuilder = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			while((line=br.readLine()) != null) {
				contentBuilder.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contentBuilder.toString();
	}
	
    private static Map<Character, Integer> computeCharacterFrequency(String content) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : content.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        return frequencyMap;
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);	//Recursively sort left subarray
            mergeSort(arr, mid + 1, right); //Recursively sort right subarray
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; ++i) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    private static int binarySearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == key) {
                return mid;
            }

            if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

}
