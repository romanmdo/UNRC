#ifndef STACK_H
#define STACK_H

#include <stdexcept>
#include <string>

// Especificacion del TAD Stack
template <typename T>
class Stack {
public:
    virtual ~Stack() = default; // Destructor virtual obligatorio en C++

    // Agrega un elemento al tope de la pila
    virtual void push(T item) = 0;

    // Elimina y retorna el elemento en el tope
    virtual T pop() = 0;

    // Retorna el elemento en el tope sin eliminarlo
    virtual T top() const = 0;

    // Devuelve el numero de elementos
    virtual int size() const = 0;

    // Devuelve true si la pila no contiene elementos
    virtual bool isEmpty() const = 0;

    // Funcion de abstraccion y verificacion
    virtual std::string toString() const = 0;
    virtual bool repOK() const = 0;
};

#endif