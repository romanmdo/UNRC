#ifndef LINKEDSTACK_H
#define LINKEDSTACK_H

#include "Stack.h"
#include <stdexcept>
#include <sstream>
#include <vector>

template <typename T>
class LinkedStack : public Stack<T> {
private:
    struct Node {
        T item;
        Node* next;
        Node(T val) : item(val), next(nullptr) {}
    };

    Node* top_; // Equivale al 'top' o 'first'[cite: 5, 6]
    int size_;

public:
    LinkedStack() {
        top_ = nullptr;
        size_ = 0;
    }

    ~LinkedStack() override {
        // Hay que liberar todos los nodos manualmente al destruir la clase
        while (!isEmpty()) {
            pop();
        }
    }

    void push(T item) override {
        Node* nuevoNodo = new Node(item);
        Node* oldtop_ = top_;
        top_ = nuevoNodo;
        top_->next = oldtop_;
        size_++;
    }

    T pop() override {
        if (isEmpty())
        {
            throw std::invalid_argument("La pila esta vacia");
        }

        Node* nodoDelete = top_;
        
        T elemento = top_->item;
        top_ = top_->next;
        delete nodoDelete;
        size_--;
        return T(elemento);
    }

    T top() const override {
        T elemento = top_->item;
        return T(elemento);
    }

    int size() const override {
        return size_;
    }

    bool isEmpty() const override {
        return top_ == nullptr; 
    }

    std::string toString() const override {
        // Simulando la logica iterativa para imprimir el array[cite: 5]
        std::vector<T> temp;
        Node* curr = top_;
        while (curr != nullptr) {
            temp.push_back(curr->item);
            curr = curr->next;
        }
        
        std::stringstream ss;
        ss << "[";
        for (int i = temp.size() - 1; i >= 0; i--) { // Invertimos para simular output de ArrayStack
            ss << temp[i];
            if (i > 0) ss << ", ";
        }
        ss << "]";
        return ss.str();
    }

    bool repOK() const override {
        if (size_ < 0) return false;
        
        int count = 0;
        Node* curr = top_;
        while (curr != nullptr && count <= size_) {
            count++;
            curr = curr->next;
        }
        
        return count == size_ && curr == nullptr;
    }
};

#endif