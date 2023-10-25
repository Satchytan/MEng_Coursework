// ENSF 614 Lab 4 Exercise A
// Instructor: M. Moussavi
// Submitted by: Satchytan Karalasingham, Romil Dhagat
// Development Date: October 18th, 2023
// lab4ExA.cpp

#include<vector>
#include<string>
#include <iostream>
using std::cout;
using std::cerr;
using std::endl;
using std::vector;
using std::string;

typedef vector<string> String_Vector;

String_Vector transpose(const String_Vector& sv);
// REQUIRES:
//    sv.size() >= 1
//    All the strings in sv are the same length, and that length is >= 1.
// PROMISES:
//    Return value is the "transpose" of sv, as defined in the Exercise B
//    instructions.

int main() {
    
    const int ROWS = 5;
    const int COLS = 4;
    
    char c = 'A';
    String_Vector sv;
    sv.resize(ROWS);
    
    for(int i = 0; i < ROWS; i++)
        for(int j = 0; j < COLS; j++) {
            sv.at(i).push_back(c);
            c++;
            if(c == 'Z' + 1)
                c = 'a';
            else if (c == 'z' + 1)
                c = 'A';
        }
    
    
    for(int i = 0; i < ROWS; i++) {
        cout<< sv.at(i);
        cout << endl;
    }
    
    String_Vector vs = transpose(sv);
    for(int i = 0; i < (int)vs.size(); i++)
        cout << vs.at(i) << endl;
    
    return 0;
}



String_Vector transpose (const String_Vector& sv) {
    
    // Ensure there is at least one row in the input vector.
    if (sv.empty()) {
        cerr << "Input vector is empty." << endl;
        String_Vector vs; // Return an empty vector.
        return vs;
    }

    int numRows = sv.size();
    int numCols = sv[0].size(); // Assuming all strings in sv have the same length.

    // Initialize vs with numRows of empty strings to represent columns.
    String_Vector vs(numCols, std::string(numRows, ' '));

    for (int i = 0; i < numRows; i++) {
        for (int j = 0; j < numCols; j++) {
            vs[j][i] = sv[i][j]; // Swap rows and columns.
        }
    }
    
    return vs;
    
}
