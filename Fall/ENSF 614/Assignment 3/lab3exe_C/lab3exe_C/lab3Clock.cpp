//lab3Clock.cpp
// ENSF 614 Lab 3 Exercise C
// Instructor: M. Moussavi
// Submitted by: Satchytan Karalasingham, Romil Dhagat
// Development Date: October 13th, 2023// lab3CLock.cpp
// By: Romil Dhagat and Satchy Keralasingham

#include <iostream>
using namespace std;
#include "lab3Clock.h"

Clock::Clock(): hour(0), minute(0), second(0){

}

Clock::Clock(int sec){
    sec_to_hms(sec);
}

Clock::Clock(int h, int m, int s){
    if (h >= 0 && h <= 23 && m >= 0 && m <= 59 && s >= 0 && s <= 59) {
        hour = h;
        minute = m;
        second = s;
    } else {
        hour = 0;
        minute = 0;
        second = 0;
    }
}

int Clock::get_hour() const {
    return hour;
}

int Clock::get_minute() const {
    return minute;
}

int Clock::get_second() const {
    return second;
}

void Clock::set_hour(int h) {
    if (h >= 0 && h <= 23) {
        hour = h;
    }
}

void Clock::set_minute(int m) {
    if (m >= 0 && m <= 59) {
        minute = m;
    }
}

void Clock::set_second(int s) {
    if (s >= 0 && s <= 59) {
        second = s;
    }
}

void Clock::increment() {
    int sec = hms_to_sec();
    sec = (sec + 1) % 86400;
    sec_to_hms(sec);
}

void Clock::decrement() {
    int sec = hms_to_sec();
    sec = (sec - 1 + 86400) % 86400;
    sec_to_hms(sec);
}
 
void Clock::add_seconds(int seconds) {
    int sec = hms_to_sec() + seconds;
    sec = (sec + 86400) % 86400;
    sec_to_hms(sec);
}

int Clock::hms_to_sec() const {
    return (hour * 3600 + minute * 60 + second);
}

void Clock::sec_to_hms(int sec) {
    hour = sec / 3600;
    sec %= 3600;
    minute = sec / 60;
    second = sec % 60;
    if (second < 0 || second > 59) {
        second = 0;
    }
    if (hour < 0 || hour > 23) {
        hour = 0;
    }
    if (minute < 0 || minute > 59) {
        minute = 0;
    }
}
