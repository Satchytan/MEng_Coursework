// lab3Clock.h
// ENSF 614 Lab 3 Exercise C
// Instructor: M. Moussavi
// Submitted by: Satchytan Karalasingham, Romil Dhagat
// Development Date: October 13th, 2023// lab3CLock.h
// By: Romil Dhagat and Satchy Keralasingham

#ifndef lab3Clock_H
#define lab3Clock_H

class Clock{
    private:
        int hour;
        int minute;
        int second;

        int hms_to_sec() const;
        void sec_to_hms(int sec);
    
    public:
        Clock();
        Clock(int seconds);
        Clock(int h, int m, int s);

        int get_hour() const;
        int get_minute() const;
        int get_second() const;

        void set_hour(int h);
        void set_minute(int m);
        void set_second(int s);

        void increment();
        void decrement();
        void add_seconds(int seconds);
};

#endif
