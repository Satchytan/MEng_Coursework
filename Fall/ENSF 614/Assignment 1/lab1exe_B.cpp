/*
 *  lab1exe_B.cpp
 *  ENSF 614 Lab 1, exercise B
 *  Created by Mahmood Moussavi
 *  Completed by: Satchytan Karalasingham
 */

#include <iostream>
#include <cmath>
using namespace std;

const double G = 9.8; /* gravitation acceleration 9.8 m/s^2 */
const double PI = 3.141592654;

void create_table(double v);
double Projectile_travel_time(double a, double v);
double Projectile_travel_distance(double a, double v);
double degree_to_radian(double d);

int main(void)
{
    double velocity;

    cout << "Please enter the velocity at which the projectile is launched (m/sec): ";
    cin >> velocity;

    if (!cin) // means if cin failed to read
    {
        cout << "Invlid input. Bye...\n";
        exit(1);
    }

    while (velocity < 0)
    {
        cout << "\nplease enter a positive number for velocity: ";
        cin >> velocity;
        if (!cin)
        {
            cout << "Invlid input. Bye...";
            exit(1);
        }
    }

    return 0;
}

void create_table(double v)
{
    cout << "Angle (deg)   Time (sec)   Distance (m)" << endl;
    cout.precision(6); // Set the precision for the output

    for (double angle = 0; angle <= 90; angle += 5)
    {
        double radians = degree_to_radian(angle);
        double time = Projectile_travel_time(radians, v);
        double distance = Projectile_travel_distance(radians, v);

        cout << angle << "           " << time << "         " << distance << endl;
    }
}

double Projectile_travel_time(double a, double v)
{
    return (2 * v * sin(a)) / G;
}

double Projectile_travel_distance(double a, double v)
{
    return (v * v * sin(2 * a)) / G;
}

double degree_to_radian(double d)
{
    return d * (PI / 180.0);
}
