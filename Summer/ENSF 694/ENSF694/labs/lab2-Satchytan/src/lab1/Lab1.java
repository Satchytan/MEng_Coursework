package lab1;

import java.util.Scanner;
import java.util.Arrays;

public class Lab1 {
	
	public static int linearSearch(int[] arr, int key) {
		for(int i = 0; i < arr.length; i ++)
		{
			if(arr[i] == key)
				return i; //key FOUND and index returned
		}
		return -1; //key NOT FOUND and -1 returned
	}
	
	
	public static int improvedLinearSearch(int[] arr, int key) {
		int low = 0;
		int high = arr.length;
		int mid = arr.length/2;
		
		if (arr[mid] <= key) {
			low = mid;
		}else {
			high = mid;
		}
		
		
		for(int i = low; i < high; i ++)
		{
			if(arr[i] == key)
				return i; //key FOUND and index returned
		}
		return -1; //key NOT FOUND and -1 returned
	}
	
	
	public static int interpolationSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        
        while (low <= high && arr[low] <= key && arr[high] >= key) {
            if (low == high) {
                if (arr[low] == key) {
                    return low;
                }
                return -1;
            }
            
            int pos = low + ((key - arr[low]) * (high - low)) / (arr[high] - arr[low]);
            
            if (arr[pos] == key) {
                return pos;
            } else if (arr[pos] < key) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }
        
        return -1;
    }
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of elements in the array: ");
        int numElements = scanner.nextInt();
        
        int[] arr = new int[numElements];
        System.out.print("Enter the elements in the array: ");
        for (int i = 0; i < numElements; i++) {
        	arr[i] = scanner.nextInt();
        }
        
        System.out.print("Enter the search key: ");
        int key = scanner.nextInt();
        
        
        // Sort the array before Interpolation Search
        Arrays.sort(arr);
        
        long linearStartTime = System.nanoTime();
        int linearResult = linearSearch(arr, key);
        if (linearResult != -1) {
            System.out.println("Using Linear Search:");
            System.out.println("Search key FOUND at index " + linearResult);
        } else {
            System.out.println("Using Linear Search:");
            System.out.println("Search key NOT FOUND");
        }
        long linearEndTime   = System.nanoTime();
        
        long linearTime = linearEndTime - linearStartTime;
        System.out.println("Linear Search Time: " + linearTime);

        
        long interpolationStartTime = System.nanoTime();
        int interpolationResult = interpolationSearch(arr, key);
        if (interpolationResult != -1) {
            System.out.println("Using Interpolation Search:");
            System.out.println("Search key FOUND at index " + interpolationResult);
        } else {
            System.out.println("Using Interpolation Search:");
            System.out.println("Search key NOT FOUND");
        }
        long interpolationEndTime  = System.nanoTime();

        
        long interpolationTime = interpolationEndTime - interpolationStartTime;
        System.out.println("Interpolation Search Time: " + interpolationTime);
        
        
        long improvedLinearStartTime = System.nanoTime();
        int improvedLinearResult = linearSearch(arr, key);
        if (improvedLinearResult != -1) {
            System.out.println("Using Linear Search:");
            System.out.println("Search key FOUND at index " + improvedLinearResult);
        } else {
            System.out.println("Using Linear Search:");
            System.out.println("Search key NOT FOUND");
        }
        long improvedLinearEndTime   = System.nanoTime();
        
        long improvedLinearTime = improvedLinearEndTime - improvedLinearStartTime;
        System.out.println("Linear Search Time: " + improvedLinearTime);
        
        
        scanner.close();
    }


}

/**
 * Q2. Interpolation search performed better on average compared to linear search.
 * The improvement generally improved with input size, showing interpolation is preferable when handling large data sets.
 * The interpolation performed better because it reduces the data-set size with each iteration.
 * 
 * Q3. The linear search can be improved by implementing the very first step of a binary search.
 * That is, we first check the middle value of the array and check if it is less than the key,
 * if so, we set the lower limit (low) to this middle index. Otherwise, the upper limit (high),
 * is set to this index. The remainder of the search is performed with either the first or second half of the array only.
 */

