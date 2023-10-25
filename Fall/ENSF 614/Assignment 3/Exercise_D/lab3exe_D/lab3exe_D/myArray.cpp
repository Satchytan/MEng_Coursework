// myArray.cpp
// ENSF 614 Lab 3 Exercise D
// Instructor: M. Moussavi
// Submitted by: Satchytan Karalasingham, Romil Dhagat
// Development Date: October 13th, 2023
// This program demonstrates the use of all the features
// of the MyArray class.


#include "MyArray.h"

MyArray::MyArray() : sizeM(0), storageM(nullptr)
{
    // Constructor for an empty array
}

MyArray::MyArray(const EType *builtin, int sizeA) : sizeM(sizeA)
{
    // Constructor to create an object by copying a built-in array
    storageM = new EType[sizeA];
    for (int i = 0; i < sizeA; i++)
    {
        storageM[i] = builtin[i];
    }
}

MyArray::MyArray(const MyArray &source) : sizeM(source.sizeM)
{
    // Copy constructor
    storageM = new EType[sizeM];
    for (int i = 0; i < sizeM; i++)
    {
        storageM[i] = source.storageM[i];
    }
}

MyArray &MyArray::operator=(const MyArray &rhs)
{
    // Assignment operator
    if (this != &rhs)
    {
        // Check for self-assignment
        if (storageM)
        {
            delete[] storageM;
        }
        sizeM = rhs.sizeM;
        storageM = new EType[sizeM];
        for (int i = 0; i < sizeM; i++)
        {
            storageM[i] = rhs.storageM[i];
        }
    }
    return *this;
}

MyArray::~MyArray()
{
    // Destructor
    if (storageM)
    {
        delete[] storageM;
    }
}

int MyArray::size() const
{
    return sizeM;
}

EType MyArray::at(int i) const
{
    // Check for valid index
    if (i >= 0 && i < sizeM)
    {
        return storageM[i];
    }
    else
    {
        return 0;
    }
}

void MyArray::set(int i, EType new_value)
{
    // Check for valid index
    if (i >= 0 && i < sizeM)
    {
        storageM[i] = new_value;
    }
}

void MyArray::resize(int new_size)
{
    if (new_size < 0)
    {
    }
    else if (new_size == 0)
    {
        // If the new size is zero, deallocate the storage
        if (storageM)
        {
            delete[] storageM;
            storageM = nullptr;
        }
        sizeM = 0;
    }
    else
    {
        // Allocate a new array and copy elements
        EType *newStorage = new EType[new_size];
        int elementsToCopy = (new_size < sizeM) ? new_size : sizeM;
        for (int i = 0; i < elementsToCopy; i++)
        {
            newStorage[i] = storageM[i];
        }

        // Deallocate the old storage and update the size and storage pointer
        if (storageM)
        {
            delete[] storageM;
        }
        sizeM = new_size;
        storageM = newStorage;
    }
}
