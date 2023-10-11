//
//  main.cpp
//  Quiz 1 Practice
//
//  Created by Satchytan Karalasingham on 2023-09-26.
//
#include <cstdio> // Use this for printf
#include <iostream>

bool up_then_down(const int* arr, int n);

int main(int argc, const char * argv[]) {
    
    int myArray[] = {1, 3, 5, 3, 3};
    int arrayLength = sizeof(myArray) / sizeof(myArray[0]);

    // Call the up_then_down function
    bool result = up_then_down(myArray, arrayLength);
    
    printf("%d\n", result); // Use the correct format specifier

    std::cout << "Hello, World!\n";
    return 0;
}

bool up_then_down(const int* arr, int n) {
    if (n<=0) return false;
    if (n==1) return true;
    
    int arr_len = 0;
    int increasing_len = 1;
    
    while (arr[arr_len] != '\0') {
        arr_len++;
    }
    
    int i;
    for (i = 1; i < n; i++) {
        if (arr[i] > arr[i-1]) {
            increasing_len++;
        }
        else {
            break;
        }
    }
    
    for (; i < n; i++) {
        if (arr[i] < arr[i - 1]) {
            continue;
        }
        else {
            return false;
        }
    }
    return true;
}

bool all_diff(const char* left, const char* right) {
    
}
