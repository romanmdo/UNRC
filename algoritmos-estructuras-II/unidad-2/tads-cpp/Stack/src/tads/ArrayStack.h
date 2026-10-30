#ifndef ARRAYSTACK_H
#define ARRAYSTACK_H

#include "Stack.h"
#include <stdexcept>
#include <sstream>

template <typename T>
class ArrayStack : public Stack<T> {
private:
    static const int INIT_CAPACITY = 4;
    T* array;
    int size_; // Equivale al 'size' de tus apuntes
    int capacity;

    void resize(int new_capacity) {
        if (new_capacity <= size_) {
            throw std::invalid_argument("La nueva capacidad debe ser mayor al size actual");
        }
        T* copy = new T[new_capacity];
        for (int i = 0; i < size_; i++) {
            copy[i] = array[i];
        }
        delete[] array; // Liberamos la memoria del arreglo viejo
        array = copy;
        capacity = new_capacity;
    }

public:
    ArrayStack() {
        capacity = INIT_CAPACITY;
        array = new T[capacity];
        size_ = 0;
    }

    ~ArrayStack() override {
        delete[] array; // Prevencion de fugas de memoria
    }

    void push(T item) override {
        if (size_ == capacity)
        {
            resize(2  * capacity);
        }
        
        array[size_] = item;
        size_++;
    }

    T pop() override {
        if (isEmpty())
        {
            throw std::invalid_argument("La pila esta vacia");
        }

        T elemento = array[size_ - 1];

        // Al hacer size--, el elemento anterior queda inaccesible.
        size_--;

        return T(elemento);
    }

    T top() const override {
        T elemento = array[size_ - 1];
        return T(elemento); 
    }

    int size() const override {
        return size_;
    }

    bool isEmpty() const override {
        return size_ == 0;
    }

    std::string toString() const override {
        std::stringstream ss;
        ss << "[";
        for (int i = 0; i < size_; i++) {
            ss << array[i];
            if (i < size_ - 1) ss << ", ";
        }
        ss << "]";
        return ss.str();
    }

    bool repOK() const override {
        if (size_ < 0 || size_ > capacity) return false;
        return true;
    }
};

#endif