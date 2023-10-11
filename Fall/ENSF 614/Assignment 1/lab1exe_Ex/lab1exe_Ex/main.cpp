/*
 *  Filename: lab1exe_E.cpp
 *  Assignment: ENSF 614 Lab 1 Exercise E
 *  Created by Mahmood Moussavi
 *  Completed by: Satchytan Karalasingham
 *  Submission Date: Sept 20, 2023
 */

#include <iostream>
using namespace std;

void time_convert(int ms_time, int *minutes_ptr, double *seconds_ptr) {
    /*
     * Converts time in milliseconds to time in minutes and seconds.
     * For example, converts 123400 ms to 2 minutes and 3.4 seconds.
     * REQUIRES:
     *    ms_time >= 0.
     *    minutes_ptr and seconds_ptr point to variables.
     * PROMISES:
     *    0 <= *seconds_ptr & *seconds_ptr < 60.0
     *    *minutes_ptr minutes + *seconds_ptr seconds is equivalent to
     *    ms_time ms.
     */

    *minutes_ptr = ms_time / (1000 * 60);
    ms_time %= (1000 * 60);
    *seconds_ptr = static_cast<double>(ms_time) / 1000.0;
}

int main(void) {
    int millisec;
    int minutes;
    double seconds;

    cout << "Enter a time interval as an integer number of milliseconds: ";
    cin >> millisec;

    if (!cin) {
        cout << "Unable to convert your input to an int.\n";
        return 1;
    }

    cout << "Doing conversion for input of " << millisec << " milliseconds ... \n";

    // Call the time_convert function
    time_convert(millisec, &minutes, &seconds);

    cout << "That is equivalent to " << minutes << " minute(s) and " << seconds << " second(s).\n";

    return 0;
}
