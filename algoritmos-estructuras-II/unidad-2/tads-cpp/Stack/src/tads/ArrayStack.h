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
        // TODO: Verificar si size_ == capacity. Si es asi, hacer resize.
        // Luego insertar 'item' en el array y aumentar size_.
    }

    T pop() override {
        // TODO: Verificar isEmpty(). Si es asi, lanzar std::out_of_range.
        // Guardar el tope, decrementar size_, y retornar el elemento.
        return T(); // Placeholder
    }

    T top() const override {
        // TODO: Verificar isEmpty(). Retornar el elemento en size_ - 1.
        return T(); // Placeholder
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